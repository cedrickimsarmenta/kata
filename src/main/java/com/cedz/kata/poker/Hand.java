package com.cedz.kata.poker;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {
  private List<Card> cards;
  private HandType handType;
  private Rank highCard;
  private List<Card> kicker;

  public Hand(HandType handType, List<Card> cards, Rank highCard) {
    this.handType = handType;
    this.cards = cards;
    this.highCard = highCard;
    calculateKicker();
  }



  private void calculateKicker(){

    if(this.handType.isKickerable()) {
      //Just remove the high cards from the cards
      this.kicker = cards.stream()
          .filter(c->
              c.getRank() != highCard
          )
          .collect(Collectors.toList());
    }

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


  @Override
  public String toString() {
    return "Hand{" +
        "cards=" + cards +
        '}';
  }

  public List<Card> getKicker() {
    return kicker;
  }
}

