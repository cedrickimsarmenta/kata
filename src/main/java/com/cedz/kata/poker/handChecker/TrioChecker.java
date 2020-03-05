package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;

import java.util.Collection;
import java.util.Collections;

public class TrioChecker extends  AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {

    Collection<Integer> counts = context.getRankCounts().values();
    if(counts.contains(3)) {
        return HandType.TRIO;
    }
    return null;
  }
}
