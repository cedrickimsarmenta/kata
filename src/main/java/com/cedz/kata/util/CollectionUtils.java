package com.cedz.kata.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

  public static <T> void initOrIncrement(Map<T, Integer> map, T key) {
    map.putIfAbsent(key, 0);
    map.put(key, map.get(key) + 1);
  }

  public static <K,V> V getFirstValue(Map<K,V> map) {
    return new ArrayList<V>(map.values()).get(0);
  }

  public static  boolean isNullOrEmpty(Collection c) {
    return c == null || c.size() == 0;
  }


  public static <T> void  combinationUtil(List<T> list , List<List<T>> container,
      List<T> data,
      int start,
      int end, int index, int r)
  {
    // Current combination is ready, add it to the container
    if (index == r) {
      container.add( new ArrayList<>(data));
      return;
    }

    // replace index with all possible elements. The condition
    // "end-i+1 >= r-index" makes sure that including one element
    // at index will make a combination with remaining elements
    // at remaining positions
    for (int i=start; i<=end && end-i+1 >= r-index; i++) {
      if(data.size() > index) {
        data.set(index, list.get(i));
      } else {
        data.add(list.get(i));
      }
      combinationUtil(list, container, data, i+1, end, index+1, r);
    }
  }

  /**
   * Get all combinations of list taking N elements
   * @param list
   * @param r
   * @param <T>
   * @return
   */
  public static <T> List<List<T>> getAllCombinations(List<T> list, int r)
  {
    // A temporary array to store all combination one by one
    List<List<T>> container = new ArrayList<>();
    int n = list.size();
    List<T> data = new ArrayList<>();
    // Print all combination using temprary array 'data[]'
    combinationUtil(list, container,  data, 0, n-1, 0, r);

    return container;
  }
}
