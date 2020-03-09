package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.handChecker.HighCardChecker;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;
import com.cedz.kata.poker.highCardCalculator.HighCardHighCardCalculator;

public class HighCardProcessorFactory implements HandTypeProcessorFactory {
  @Override
  public HighCardCalculator getHighCardChecker() {
    return new HighCardHighCardCalculator();
  }
}
