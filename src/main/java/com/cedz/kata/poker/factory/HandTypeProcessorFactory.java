package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;

public interface HandTypeProcessorFactory {
  HighCardCalculator getHighCardChecker();
}
