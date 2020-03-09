package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;

import java.util.Collection;
import java.util.Collections;

public class TrioChecker extends  AbstractCountChecker {
  public TrioChecker() {
    super(3, HandType.TRIO);
  }
}
