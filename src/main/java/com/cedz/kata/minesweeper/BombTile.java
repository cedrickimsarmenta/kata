package com.cedz.kata.minesweeper;

public class BombTile extends AbstractTile {
  public BombTile(int x, int y) {
    super(x, y);
  }

  @Override
  public String displayState() {
    return "*";
  }

  @Override
  public void incrementBombCount() {
    //do nothing for bombs
  }

  @Override
  public int getNeighborBombCount() {
    return 0;
  }

  @Override
  public boolean isBomb() {
    return true;
  }

  public void updateNeighbors(Tile[][] board) {
    for(Tile tile : getNeighbors(board)) {
      tile.incrementBombCount();
    }
  }

}
