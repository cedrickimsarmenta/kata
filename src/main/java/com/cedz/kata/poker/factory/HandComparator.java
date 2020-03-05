package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.Hand;
import com.cedz.kata.poker.Poker;
import com.cedz.kata.util.CollectionUtils;

import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {
  @Override
  public int compare(Hand o1, Hand o2) {
    if (o1.getHandType() != o2.getHandType()) {
      return o1.getHandType().getScore() < o2.getHandType().getScore() ? -1 : 1;
    } else if(o1.getHighCard() != o2.getHighCard()) {
      return o1.getHighCard().getRank() < o2.getHighCard().getRank() ? -1 : 1;
    } else if(!CollectionUtils.isNullOrEmpty(o1.getKicker()) && !CollectionUtils.isNullOrEmpty(o2.getKicker()) ) {
        Hand kicker1 = Poker.bestHand(o1.getKicker());
        Hand kicker2 = Poker.bestHand(o2.getKicker());
        return compare(kicker1, kicker2);
    }
    return 0;
  }
}
