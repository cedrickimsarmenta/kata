package com.cedz.kata.poker;

public enum HandType {
  //The lowest possible hand
  HIGH_CARD("High Card", "The best card is the highest card", 0, true),
  PAIR("Pair", "The best card is a single pair", 1, true),
  TWO_PAIRS("Two Pair", "The best card are 2 pairs", 2, true),
  TRIO("Three of a Kind", "The best card are 3 of a kind", 3, false),
  STRAIGHT("Straight", "All 5 cards are consecutive", 4, false),
  FLUSH("Flush", "All 5 cards are the same suite", 5, true),
  FULL_HOUSE("Full House", "A pair and a trio", 6, false),
  FOUR_OF_A_KIND("Four of a Kind", "Four of a kind", 7, false),
  STRAIGHT_FLUSH("Straight Flush", "Cards are both straight and flush", 8, false),
  ROYAL_FLUSH("Royal Flush", "Cards are both straight and flush, and high card is Ace", 9, false);

  HandType(String name, String description, int score,  boolean kickerable) {
    this.name = name;
    this.description = description;
    this.score = score;
    this.kickerable =  kickerable;
  }
  private boolean kickerable;
  private String name;
  private String description;
  private int score;


  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getScore() {
    return score;
  }

  public boolean isKickerable() {
    return kickerable;
  }
}
