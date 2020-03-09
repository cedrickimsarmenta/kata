package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;

import java.util.Collection;
import java.util.Collections;

public class FourOfAKindChecker extends  AbstractCountChecker {

  public FourOfAKindChecker() {
    super(4, HandType.FOUR_OF_A_KIND);
  }
}
