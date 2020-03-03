package com.cedz.kata.minesweeper;

public abstract class AbstractTile implements Tile {
  protected int x;
  protected int y;

  public AbstractTile(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
