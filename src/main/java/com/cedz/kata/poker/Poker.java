package com.cedz.kata.poker;

import com.cedz.kata.poker.factory.FactoryProvider;
import com.cedz.kata.poker.factory.HandComparator;
import com.cedz.kata.poker.factory.HandTypeProcessorFactory;
import com.cedz.kata.poker.handChecker.FlushChecker;
import com.cedz.kata.poker.handChecker.FourOfAKindChecker;
import com.cedz.kata.poker.handChecker.FullHouseChecker;
import com.cedz.kata.poker.handChecker.HandChecker;
import com.cedz.kata.poker.handChecker.HandContext;
import com.cedz.kata.poker.handChecker.HighCardChecker;
import com.cedz.kata.poker.handChecker.PairChecker;
import com.cedz.kata.poker.handChecker.RoyalFlushChecker;
import com.cedz.kata.poker.handChecker.StraightChecker;
import com.cedz.kata.poker.handChecker.StraightFlushChecker;
import com.cedz.kata.poker.handChecker.TrioChecker;
import com.cedz.kata.poker.handChecker.TwoPairChecker;
import com.cedz.kata.poker.highCardCalculator.HighCardCalculator;
import com.cedz.kata.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {

  private static HandChecker root;

  static {
    //Init the checkers
    RoyalFlushChecker royalFlushChecker = new RoyalFlushChecker();
    StraightFlushChecker straightFlushChecker = new StraightFlushChecker();
    FourOfAKindChecker fourOfAKindChecker = new FourOfAKindChecker();
    FullHouseChecker fullHouseChecker = new FullHouseChecker();
    FlushChecker flushChecker = new FlushChecker();
    StraightChecker straightChecker = new StraightChecker();
    TrioChecker trioChecker = new TrioChecker();
    TwoPairChecker twoPairChecker = new TwoPairChecker();
    PairChecker pairChecker = new PairChecker();
    HighCardChecker highCardChecker = new HighCardChecker();


    root = royalFlushChecker;
    royalFlushChecker.setNext(straightFlushChecker);
    straightFlushChecker.setNext(fourOfAKindChecker);
    fourOfAKindChecker.setNext(fullHouseChecker);
    fullHouseChecker.setNext(flushChecker);
    flushChecker.setNext(straightChecker);
    straightChecker.setNext(trioChecker);
    trioChecker.setNext(twoPairChecker);
    twoPairChecker.setNext(pairChecker);
    pairChecker.setNext(highCardChecker);
  }

  public static Hand bestHand(List<Card> cards) {
    HandContext handContext = new HandContext(cards);
    HandType handType = root.check(handContext);

    if(handType != null) {

      HandTypeProcessorFactory handTypeProcessorFactory = FactoryProvider.getFactory(handType);

      HighCardCalculator highCardCalculator = handTypeProcessorFactory.getHighCardChecker();

      Hand hand = new Hand(handType, cards, highCardCalculator.calculate(handContext));

      return hand;
    }
    return null;
  }

  public static Hand bestHand(List<Card> cards, int cardsToTake) {
    List<List<Card>> potentialHands = new ArrayList<>();

    potentialHands = CollectionUtils.getAllCombinations(cards, 5);

    List<Hand> hands = new ArrayList<>();
    for(List<Card> potentialHand : potentialHands) {
      hands.add(bestHand(potentialHand));
    }

    Collections.sort(hands, new HandComparator().reversed());


    return hands.get(0);
  }



}
