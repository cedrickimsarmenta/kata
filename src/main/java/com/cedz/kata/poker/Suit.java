package com.cedz.kata.poker;

public enum Suit {
  DIAMOND("diamond","♦"),
  HEART("heart","♥"),
  SPADE("spade","♠"),
  CLUBS("clubs","♣");

  Suit(String name, String displayText) {
    this.name = name;
    this.displayText = displayText;
  }

  private String name;
  private String displayText;

  public String getName() {
    return name;
  }

  public String getDisplayText() {
    return displayText;
  }
}
