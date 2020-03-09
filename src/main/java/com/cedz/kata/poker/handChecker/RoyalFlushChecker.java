package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;

import java.util.Collections;
import java.util.List;

public class RoyalFlushChecker extends AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {
    //Re use checker logic, but without chaining
    StraightFlushChecker straightFlushChecker = new StraightFlushChecker();


    if(straightFlushChecker.check(context) != null) {
      List<Integer> rankValues = context.getRankValues();
      //A straight flush, with high card Ace
      //Note that a straight can also be 1-2-3-4-5, do not consider Royal flush
      if(Collections.max(rankValues) == Rank.ACE.getRank() && !rankValues.contains(Rank.TWO.getRank())) {
        return  HandType.ROYAL_FLUSH;
      }
    }

    return null;
  }
}
