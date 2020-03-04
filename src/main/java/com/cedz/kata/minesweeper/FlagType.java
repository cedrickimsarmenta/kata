package com.cedz.kata.minesweeper;

public enum FlagType {
  UNCERTAIN("?","To be used by player when he is not sure if bomb or not"),
  BOMB("F", "Player believes tile is a bomb"),
  NONE(null, "Used by player when he wants to remove a bomb flag");


  FlagType(String display, String description) {
    this.display = display;
    this.description = description;
  }

  private String display;
  private String description;


  public String getDisplay() {
    return display;
  }
}
