package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.handChecker.HighCardChecker;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;

public interface HandTypeProcessorFactory {
  HighCardCalculator getHighCardChecker();
}
