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
    boolean notLastColumn =  this.y < board[x].length - 1;
    boolean notLastRow =this.x < board.length - 1;
    boolean notFirstRow = x > 0;
    boolean notFirstColumn = y > 0;
    if(notFirstColumn) {
      board[x][y-1].incrementBombCount();
    }
    if(notLastColumn) {
      board[x][y+1].incrementBombCount();
    }
    if(notFirstRow) {
      board[x-1][y].incrementBombCount();
    }
    if(notLastRow) {
      board[x+1][y].incrementBombCount();
    }
    if(notFirstRow && notFirstColumn) {
      board[x-1][y-1].incrementBombCount();
    }
    if(notLastRow && notLastColumn) {
      board[x+1][y+1].incrementBombCount();
    }
    if(notLastRow && notFirstColumn) {
      board[x+1][y-1].incrementBombCount();
    }
    if(notFirstRow && notLastColumn) {
      board[x-1][y+1].incrementBombCount();
    }





  }
}
