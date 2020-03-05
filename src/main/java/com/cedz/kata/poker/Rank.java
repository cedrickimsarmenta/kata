package com.cedz.kata.poker;

public enum Rank {

  //Ace is the highest ranked card in poker
  ACE("Ace", "A", 14),
  TWO("Two", "2", 2),
  THREE("Three", "3", 3),
  FOUR("Four", "4", 4),
  FIVE("Five", "5", 5),
  SIX("Six", "6", 6),
  SEVEN("Seven", "7", 7),
  EIGHT("Eight", "8", 8),
  NINE("Nine", "9", 9),
  TEN("Ten", "10", 10),
  JACK("Jack", "J", 11),
  QUEEN("Queen", "Q", 12),
  KING("King", "K", 13);

  Rank(String name, String label, int rank) {
    this.name = name;
    this.label = label;
    this.rank = rank;
  }

  private String name;
  private String label;
  private int rank;
}
