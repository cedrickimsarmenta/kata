package com.cedz.kata.minesweeper;

public class SafeTile extends AbstractTile {

  private int numberOfBombNeighbors = 0;

  public SafeTile(int x, int y) {
    super(x, y);
  }

  @Override
  public String displayState() {
    return numberOfBombNeighbors + "";
  }

  @Override
  public void incrementBombCount() {
    this.numberOfBombNeighbors = numberOfBombNeighbors+1;
  }

  @Override
  public int getNeighborBombCount() {
    return numberOfBombNeighbors;
  }

  @Override
  public boolean isBomb() {
    return false;
  }


  @Override
  public void leftClick(Tile[][] board) {
    super.leftClick(board);

    if(this.getNeighborBombCount() == 0) {

      for(Tile tile : getNeighbors(board)) {
        if(!tile.isOpen() && !tile.isBomb()) {
          tile.leftClick(board);
        }
      }
    }

  }


}
