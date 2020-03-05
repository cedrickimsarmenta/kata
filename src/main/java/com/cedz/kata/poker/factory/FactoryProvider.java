package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.HandType;

import java.util.HashMap;
import java.util.Map;

public class FactoryProvider {

  private static Map<HandType, HandTypeProcessorFactory> FACTORY_MAP = new HashMap<>();

  static {
    FACTORY_MAP.put(HandType.HIGH_CARD, new HighCardProcessorFactory());
    FACTORY_MAP.put(HandType.PAIR, new PairProcessorFactory());

  }

  public static HandTypeProcessorFactory getFactory(HandType handType) {
    return FACTORY_MAP.get(handType);
  }

}
