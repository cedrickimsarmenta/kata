package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.HandType;

import java.util.List;

public class HighCardChecker extends AbstractHandChecker {


  @Override
  public HandType doCheck(List<Card> cards) {
    return HandType.HIGH_CARD;
  }
}
