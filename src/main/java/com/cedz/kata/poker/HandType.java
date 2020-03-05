package com.cedz.kata.poker;

public enum HandType {
  //The lowest possible hand
  HIGH_CARD("High Card", "The best card is the highest card", 0),
  PAIR("Pair", "The best card is a single pair", 1),
  TWO_PAIRS("Two Pair", "The best card are 2 pairs", 2),
  TRIO("Three of a Kind", "The best card are 3 of a kind", 3),
  STRAIGHT("Straight", "All 5 cards are consecutive", 4),
  FLUSH("FLUSH", "All 5 cards are the same suite", 5)


  ;

  HandType(String name, String description, int score) {
    this.name = name;
    this.description = description;
    this.score = score;
  }

  private String name;
  private String description;
  private int score;
}
