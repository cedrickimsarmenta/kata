package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.highCardCalculator.CountHighCardCalculator;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;

public class FourOfAKindProcessorFactory implements HandTypeProcessorFactory {
  @Override
  public HighCardCalculator getHighCardChecker() {
    return new CountHighCardCalculator(4);
  }
}
