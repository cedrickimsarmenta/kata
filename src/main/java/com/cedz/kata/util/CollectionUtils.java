package com.cedz.kata.util;

import java.util.ArrayList;
import java.util.Collection;
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
}
