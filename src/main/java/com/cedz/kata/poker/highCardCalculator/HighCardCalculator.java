package com.cedz.kata.poker.highCardCalculator;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.poker.handChecker.HandContext;

public interface HighCardCalculator {
  Rank calculate(HandContext context);

}
