package com.cedz.kata.poker;

public enum HandType {
  //The lowest possible hand
  HIGH_CARD("High Card", "The best card is the highest card", 0),
  PAIR("Pair", "The best card is a single pair", 1),
  TWO_PAIRS("Two Pair", "The best card are 2 pairs", 2),
  TRIO("Three of a Kind", "The best card are 3 of a kind", 3),
  STRAIGHT("Straight", "All 5 cards are consecutive", 4),
  FLUSH("Flush", "All 5 cards are the same suite", 5),
  FULL_HOUSE("Full House", "A pair and a trio", 6),
  FOUR_OF_A_KIND("Four of a Kind", "Four of a kind", 7),
  STRAIGHT_FLUSH("Straight Flush", "Cards are both straight and flush", 8),
  ROYAL_FLUSH("Royal Flush", "Cards are both straight and flush, and high card is Ace", 9);

  HandType(String name, String description, int score) {
    this.name = name;
    this.description = description;
    this.score = score;
  }

  private String name;
  private String description;
  private int score;
}
