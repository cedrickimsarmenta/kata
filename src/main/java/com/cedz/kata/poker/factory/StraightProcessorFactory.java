package com.cedz.kata.poker.factory;

import com.cedz.kata.poker.Rank;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;
import com.cedz.kata.poker.highCardCalculator.StraightHighCardCalculator;

import java.util.List;

public class StraightProcessorFactory implements HandTypeProcessorFactory {
  @Override
  public HighCardCalculator getHighCardChecker() {

    return new StraightHighCardCalculator();
  }
}
