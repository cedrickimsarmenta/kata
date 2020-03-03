package com.cedz.kata.minesweeper;

public class BombTile extends AbstractTile {
  public BombTile(int x, int y) {
    super(x, y);
  }

  @Override
  public String display() {
    return "*";
  }

  @Override
  public void incrementBombCount() {
    //do nothing for bombs
  }

  public void updateNeighbors(Tile[][] board) {
    if(y > 0) {
      board[x][y-1].incrementBombCount();
    }
    if(y < board[x].length - 1) {
      board[x][y+1].incrementBombCount();
    }
    if(x > 0) {
      board[x-1][y].incrementBombCount();
    }
    if(x < board.length -1) {
      board[x+1][y].incrementBombCount();
    }
  }
}
