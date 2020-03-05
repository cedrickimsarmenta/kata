package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.HandType;

import java.util.List;

public interface HandChecker {
  HandChecker getNext();
  void setNext(HandChecker handChecker);
  HandType check(List<Card> cards);
}
