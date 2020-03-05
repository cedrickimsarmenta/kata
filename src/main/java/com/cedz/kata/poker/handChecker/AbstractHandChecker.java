package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.HandType;

import java.util.List;

public abstract class AbstractHandChecker implements  HandChecker {
  protected HandChecker next;


  @Override
  public HandChecker getNext() {
    return next;
  }

  @Override
  public void setNext(HandChecker next) {
    this.next = next;
  }

  @Override
  public HandType check(HandContext context) {

    HandType handType = doCheck(context);

    if(handType != null) {
      return handType;
    }
    if(next != null) {
      return next.check(context);
    }

    return null;
  }

  protected abstract HandType doCheck(HandContext context);
}
