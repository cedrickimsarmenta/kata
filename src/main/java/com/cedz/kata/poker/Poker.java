package com.cedz.kata.poker;

import com.cedz.kata.poker.handChecker.HandChecker;
import com.cedz.kata.poker.handChecker.HandContext;
import com.cedz.kata.poker.handChecker.HighCardChecker;
import com.cedz.kata.poker.handChecker.PairChecker;
import com.cedz.kata.poker.handChecker.StraightChecker;
import com.cedz.kata.poker.handChecker.TrioChecker;
import com.cedz.kata.poker.handChecker.TwoPairChecker;
import com.cedz.kata.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker {

  private static HandChecker root;
  static {
    //Init the checkers
    StraightChecker straightChecker = new StraightChecker();
    TrioChecker trioChecker = new TrioChecker();
    TwoPairChecker twoPairChecker = new TwoPairChecker();
    PairChecker pairChecker = new PairChecker();
    HighCardChecker highCardChecker = new HighCardChecker();


    root = straightChecker;
    straightChecker.setNext(trioChecker);
    trioChecker.setNext(twoPairChecker);
    twoPairChecker.setNext(pairChecker);
    pairChecker.setNext(highCardChecker);
  }

  public static Hand bestHand(List<Card> cards) {
    return new Hand(root.check(new HandContext(cards)));
  }




}
