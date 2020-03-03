package com.cedz.kata.minesweeper;

public class SafeTile implements Tile {

  private int numberOfBombNeighbors = 0;
  @Override
  public String display() {
    return numberOfBombNeighbors + "";
  }
}
