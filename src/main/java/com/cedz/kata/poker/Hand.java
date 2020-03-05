package com.cedz.kata.poker;

import com.cedz.kata.poker.handChecker.HighCardChecker;

import java.util.List;

public class Hand {
  private List<Card> cards;
  private HandType handType;
  private Rank highCard;


  public Hand(HandType handType, List<Card> cards, Rank highCard) {
    this.handType = handType;
    this.cards = cards;
    this.highCard = highCard;
  }

  public HandType getHandType() {
    return handType;
  }

  public Rank getHighCard() {
    return highCard;
  }

  public List<Card> getCards() {
    return cards;
  }
}

