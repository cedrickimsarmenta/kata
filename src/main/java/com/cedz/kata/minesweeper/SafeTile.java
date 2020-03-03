package com.cedz.kata.minesweeper;

public class SafeTile extends AbstractTile {

  private int numberOfBombNeighbors = 0;

  public SafeTile(int x, int y) {
    super(x, y);
  }

  @Override
  public String display() {
    return numberOfBombNeighbors + "";
  }

  @Override
  public void incrementBombCount() {
    this.numberOfBombNeighbors = numberOfBombNeighbors+1;
  }
}
