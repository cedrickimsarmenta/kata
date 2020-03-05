package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.highCardCalculator.CountHighCardCalculator;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;

public class TrioProcessorFactory implements  HandTypeProcessorFactory {
  @Override
  public HighCardCalculator getHighCardChecker() {
    return new CountHighCardCalculator(3);
  }
}
