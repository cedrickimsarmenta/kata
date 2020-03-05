package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;

public class FullHouseChecker extends  AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {
    //Re use checker logic, but without chaining
    TrioChecker trioChecker = new TrioChecker();
    PairChecker pairChecker = new PairChecker();

    if(trioChecker.check(context) != null && pairChecker.check(context) != null) {
      //A trio and a pair
      return  HandType.FULL_HOUSE;
    }
    return null;
  }
}
