package com.cedz.kata.potter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javafx.util.Pair;

public class Potter {

  public static final BigDecimal SINGLE_UNIT_PRICE = new BigDecimal("8");

  public static final BigDecimal DISCOUNT_INCREMENT = new BigDecimal("0.05");

  public static BigDecimal compute(Map<Integer, Integer> order) {
    BigDecimal total = BigDecimal.ZERO;
    removeEmpty(order);

    while(!order.isEmpty()) {
      Pair<Integer, Integer> bookSetInfo = calculateBookSetInfo(order);
      int booksInASet = bookSetInfo.getKey();
      int numberOfBookSets =bookSetInfo.getValue();

      BigDecimal currentAmount = chargeCurrent(booksInASet, numberOfBookSets);
      total = MathUtils.scale(total.add(currentAmount));
      deductIncludedBooks(order, booksInASet, numberOfBookSets);
      removeEmpty(order);
    }

    return total;
  }

  private static BigDecimal chargeCurrent(int booksInASet, int numberOfBookSets) {
    BigDecimal discount = calculateDiscount(booksInASet, numberOfBookSets);
    BigDecimal priceBase = MathUtils.scale(SINGLE_UNIT_PRICE.multiply(new BigDecimal(booksInASet)));
    BigDecimal discountedPrice = MathUtils.scale(priceBase.subtract(priceBase.multiply(discount)));

    BigDecimal currentTotal = MathUtils.scale(discountedPrice.multiply(new BigDecimal(numberOfBookSets)));

    return currentTotal;
  }
  private static BigDecimal calculateDiscount(int booksInASet, int numberOfBookSets) {

    BigDecimal discount = BigDecimal.ZERO;

    if(booksInASet > 1) {
      BigDecimal increments = new BigDecimal(booksInASet-1);
      if(booksInASet > 3) {
        //an extra increment
        increments = increments.add(BigDecimal.ONE);
      }
      discount = increments.multiply(DISCOUNT_INCREMENT);

    }

    return discount;
  }

  /**
   *
   * @param order
   * @return Pair containing number of books in the current set, and the number of instnces of the set
   */
  private static Pair<Integer, Integer> calculateBookSetInfo(Map<Integer, Integer> order) {
    long allBookTypes = order.values().size();


    int minBookCount = Collections.min(order.values());
    int maxBookCount = Collections.max(order.values());

    //By default, use all books to form a type of set
    int booksInASet = (int)allBookTypes;

    //By default, we want to form as many sets of as possible
    int numberOfBookSets = minBookCount;

    long booksWithMinCount = order.values().stream().filter(x -> x== minBookCount).count();

    if (allBookTypes == 5 && minBookCount !=maxBookCount && booksWithMinCount==2) {
      //Here we have the potential to use 2 4s instead of 1 5 and a 3
      if(minBookCount == 1) {
        //Ready to use 4, thereby, at the next iteration, 4 books will be left to form a group of 4
        booksInASet = 4;
      } else {
        //We have a potential to use 4, but there can be sets of 5 first. Prepare the books of 5, but leave a set of 5 so we can opt for 2 4s
        numberOfBookSets = minBookCount - 1;
      }
    }

    return new Pair<Integer, Integer>(booksInASet, numberOfBookSets);
  }

  private static void deductIncludedBooks(Map<Integer, Integer> order, long booksInASet, int numberOfBookSets) {
    int booksTaken = 0;

    for(Map.Entry<Integer,Integer> entry : sortEntrySetByNumberOfBooksDesc(order.entrySet())) {
      order.put(entry.getKey(), order.get(entry.getKey()) - numberOfBookSets);
      booksTaken++;

      if (booksInASet == booksTaken) {
        break;
      }
    }
  }

  private static Iterable<? extends Map.Entry<Integer, Integer>> sortEntrySetByNumberOfBooksDesc(Set<Map.Entry<Integer, Integer>> entrySet) {
    List<Map.Entry<Integer, Integer>> sortedEntrySet = new ArrayList<>(entrySet);

    Collections.sort(sortedEntrySet, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });

    return sortedEntrySet;
  }

  private static void removeEmpty(Map<Integer, Integer> order) {
    order.entrySet().removeIf(entry -> entry.getValue()<=0);
  }

  private static class MathUtils {
    public static BigDecimal scale(BigDecimal bigDecimal) {
      return  bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

  }
}
