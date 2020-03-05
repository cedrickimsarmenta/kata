package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairChecker extends AbstractHandChecker {


  @Override
  public HandType doCheck(List<Card> cards) {
    Map<Rank, Integer> rankCounts = new HashMap<>();

    for(Card c : cards)   {
      CollectionUtils.initOrIncrement(rankCounts, c.getRank());
    }

    if(Collections.max(rankCounts.values()) == 2) {
      if(Collections.frequency(rankCounts.values(), 2) == 2) {
        return HandType.TWO_PAIRS;
      }
    }
    return null;
  }
}
