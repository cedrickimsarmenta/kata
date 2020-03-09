package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Hand;
import com.cedz.kata.poker.HandType;

import java.util.Collection;

public abstract class AbstractCountChecker extends AbstractHandChecker {

  private int count;
  private HandType type;

  protected AbstractCountChecker(int count, HandType type) {
    this.count = count;
    this.type = type;
  }

  @Override
  protected HandType doCheck(HandContext context) {
    Collection<Integer> counts = context.getRankCounts().values();
    if(counts.contains(count)) {
      return type;
    }
    return null;
  }
}
