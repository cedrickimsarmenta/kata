package com.cedz.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTile implements Tile {
  public static final String NEW_TILE = "@";
  protected int x;
  protected int y;
  private boolean open = false;
  private FlagType flag = FlagType.NONE;

  public AbstractTile(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void flag(FlagType flagType) {
    this.flag = flagType;
  }


  @Override
  public void leftClick(Tile[][] board) {
    this.open = true;
  }

  @Override
  public String display() {
    if(this.open) {
     return this.displayState();
    } else if (this.flag != FlagType.NONE) {
      return this.flag.getDisplay();
    }else {
      return NEW_TILE;
    }
  }

  protected List<Tile> getNeighbors(Tile[][] board) {
    List<Tile> neighbors = new ArrayList<>();

    boolean notLastColumn =  this.y < board[x].length - 1;
    boolean notLastRow =this.x < board.length - 1;
    boolean notFirstRow = x > 0;
    boolean notFirstColumn = y > 0;

    if(notFirstColumn) {
      neighbors.add(board[x][y-1]);
    }
    if(notLastColumn) {
      neighbors.add(board[x][y+1]);
    }
    if(notFirstRow) {
      neighbors.add(board[x-1][y]);
    }
    if(notLastRow) {
      neighbors.add(board[x+1][y]);
    }
    if(notFirstRow && notFirstColumn) {
      neighbors.add(board[x-1][y-1]);
    }
    if(notLastRow && notLastColumn) {
      neighbors.add(board[x+1][y+1]);
    }

    if(notLastRow && notFirstColumn) {
      neighbors.add(board[x+1][y-1]);
    }

    if(notFirstRow && notLastColumn) {
      neighbors.add(board[x-1][y+1]);
    }
    return neighbors;
  }


  @Override
  public String toString() {
    return "AbstractTile{" +
        "x=" + x +
        ", y=" + y +
        ", open=" + open +
        '}';
  }
}
