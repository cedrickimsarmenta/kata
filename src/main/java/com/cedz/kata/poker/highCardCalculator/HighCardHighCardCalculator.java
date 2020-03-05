package com.cedz.kata.poker.highCardCalculator;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.poker.handChecker.HandContext;

/**
 * Name is a bit confusing, but the HIGH_CARD hand type has a high card :P
 */
public class HighCardHighCardCalculator implements  HighCardCalculator {

  @Override
  public Rank calculate(HandContext context) {
    //The first rank is the best card
    return context.getSortedRanksDesc().get(0);
  }


}
