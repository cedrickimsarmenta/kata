package com.cedz.kata.poker;

import java.util.List;

public class Hand {
  private List<Card> cards;
  private HandType handType;

  public Hand(HandType handType, List<Card> cards) {
    this.handType = handType;
    this.cards = cards;
  }

  public HandType getHandType() {
    return handType;
  }


  public List<Card> getCards() {
    return cards;
  }
}

