package com.cedz.kata.poker.highCardCalculator;

import com.cedz.kata.poker.Rank;
import com.cedz.kata.poker.handChecker.HandContext;

import java.util.Map;

/**
 * can be used by pair, 2 pairs, trio, and four of a kind to look for the highcard based on count
 */
public class CountHighCardCalculator implements HighCardCalculator {
  private int count;

  public CountHighCardCalculator(int count) {
    this.count = count;
  }

  @Override
  public Rank calculate(HandContext context) {
    return context.filterRanksByCount(2).get(0);
  }
}
