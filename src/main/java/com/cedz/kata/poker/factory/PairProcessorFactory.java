package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;
import com.cedz.kata.poker.highCardCalculator.CountHighCardCalculator;

public class PairProcessorFactory implements HandTypeProcessorFactory {
  @Override
  public HighCardCalculator getHighCardChecker() {
    return new CountHighCardCalculator(2);
  }
}
