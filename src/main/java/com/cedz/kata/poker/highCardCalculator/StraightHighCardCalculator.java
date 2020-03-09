package com.cedz.kata.poker.highCardCalculator;

import com.cedz.kata.poker.Rank;
import com.cedz.kata.poker.handChecker.HandContext;

import java.util.List;

public class StraightHighCardCalculator implements  HighCardCalculator {
  @Override
  public Rank calculate(HandContext context) {

    List<Rank> ranks = context.getSortedRanksDesc();

    if(ranks.contains(Rank.ACE) && ranks.contains(Rank.TWO)) {
      //A lower ace straight. Aka 1-2-3-4-5
      return Rank.FIVE;
    }
    return ranks.get(0);
  }
}
