package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;

public class StraightFlushChecker extends  AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {
    //Re use checker logic, but without chaining
    FlushChecker flushChecker = new FlushChecker();
    StraightChecker straightChecker = new StraightChecker();

    if(flushChecker.check(context) != null && straightChecker.check(context) != null) {
      //Both a straight and a pair
      return  HandType.STRAIGHT_FLUSH;
    }
    return null;
  }
}
