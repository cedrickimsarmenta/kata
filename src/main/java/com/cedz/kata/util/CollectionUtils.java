package com.cedz.kata.util;

import java.util.Map;

public class CollectionUtils {

  public static <T> void initOrIncrement(Map<T, Integer> map, T key) {
    map.putIfAbsent(key, 0);
    map.put(key, map.get(key) + 1);
  }
}
