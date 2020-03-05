package com.cedz.kata.poker;

public class Hand {
  private HandType handType;


  public Hand(HandType handType) {
    this.handType = handType;
  }

  public HandType getHandType() {
    return handType;
  }
}
