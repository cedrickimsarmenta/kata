package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Hand;
import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairChecker extends AbstractHandChecker {


  @Override
  public HandType doCheck(HandContext context) {


    Collection<Integer> counts = context.getRankCounts().values();
    if(Collections.max(counts) == 2) {
      if(Collections.frequency(counts, 2) == 1) {
        return HandType.PAIR;
      }
    }
    return null;
  }
}
