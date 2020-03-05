package com.cedz.kata.poker;

public enum Card {
  HEART_ACE(Suit.HEART, Rank.ACE),
  HEART_2(Suit.HEART, Rank.TWO),
  HEART_3(Suit.HEART, Rank.THREE),
  HEART_4(Suit.HEART, Rank.FOUR),
  HEART_5(Suit.HEART, Rank.FIVE),
  HEART_6(Suit.HEART, Rank.SIX),
  HEART_7(Suit.HEART, Rank.SEVEN),
  HEART_8(Suit.HEART, Rank.EIGHT),
  HEART_9(Suit.HEART, Rank.NINE),
  HEART_10(Suit.HEART, Rank.TEN),
  HEART_JACK(Suit.HEART, Rank.JACK),
  HEART_QUEEN(Suit.HEART, Rank.QUEEN),
  HEART_KING(Suit.HEART, Rank.KING),

  DIAMOND_ACE(Suit.DIAMOND, Rank.ACE),
  DIAMOND_2(Suit.DIAMOND, Rank.TWO),
  DIAMOND_3(Suit.DIAMOND, Rank.THREE),
  DIAMOND_4(Suit.DIAMOND, Rank.FOUR),
  DIAMOND_5(Suit.DIAMOND, Rank.FIVE),
  DIAMOND_6(Suit.DIAMOND, Rank.SIX),
  DIAMOND_7(Suit.DIAMOND, Rank.SEVEN),
  DIAMOND_8(Suit.DIAMOND, Rank.EIGHT),
  DIAMOND_9(Suit.DIAMOND, Rank.NINE),
  DIAMOND_10(Suit.DIAMOND, Rank.TEN),
  DIAMOND_JACK(Suit.DIAMOND, Rank.JACK),
  DIAMOND_QUEEN(Suit.DIAMOND, Rank.QUEEN),
  DIAMOND_KING(Suit.DIAMOND, Rank.KING),

  SPADE_ACE(Suit.SPADE, Rank.ACE),
  SPADE_2(Suit.SPADE, Rank.TWO),
  SPADE_3(Suit.SPADE, Rank.THREE),
  SPADE_4(Suit.SPADE, Rank.FOUR),
  SPADE_5(Suit.SPADE, Rank.FIVE),
  SPADE_6(Suit.SPADE, Rank.SIX),
  SPADE_7(Suit.SPADE, Rank.SEVEN),
  SPADE_8(Suit.SPADE, Rank.EIGHT),
  SPADE_9(Suit.SPADE, Rank.NINE),
  SPADE_10(Suit.SPADE, Rank.TEN),
  SPADE_JACK(Suit.SPADE, Rank.JACK),
  SPADE_QUEEN(Suit.SPADE, Rank.QUEEN),
  SPADE_KING(Suit.SPADE, Rank.KING),

  CLUBS_ACE(Suit.SPADE, Rank.ACE),
  CLUBS_2(Suit.SPADE, Rank.TWO),
  CLUBS_3(Suit.SPADE, Rank.THREE),
  CLUBS_4(Suit.SPADE, Rank.FOUR),
  CLUBS_5(Suit.SPADE, Rank.FIVE),
  CLUBS_6(Suit.SPADE, Rank.SIX),
  CLUBS_7(Suit.SPADE, Rank.SEVEN),
  CLUBS_8(Suit.SPADE, Rank.EIGHT),
  CLUBS_9(Suit.SPADE, Rank.NINE),
  CLUBS_10(Suit.SPADE, Rank.TEN),
  CLUBS_JACK(Suit.SPADE, Rank.JACK),
  CLUBS_QUEEN(Suit.SPADE, Rank.QUEEN),
  CLUBS_KING(Suit.SPADE, Rank.KING);

  Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  private Suit suit;
  private Rank rank;

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }
}
