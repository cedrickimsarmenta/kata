package com.cedz.kata.minesweeper;

public class Minesweeper {

  public static final String NEW_LINE = "\n";
  public static final String SPACE = " ";
  public static final char BOMB = '*';
  private int rows;
  private int columns;
  private Tile[][] board;

  public Minesweeper(String input) {
    if(input == null) {
      return;
    }

    String[] lines = input.split(NEW_LINE);
    parseMetadata(lines[0]);
    initBoard();
    readBombs(lines);
  }

  private void readBombs(String[] lines) {
    for(int i = 0; i < rows; i++) {
      String line = lines[i+1];
      for(int j = 0; j < columns ; j++) {
        char tileChar = line.charAt(j);

        if(tileChar == BOMB){
          BombTile bombTile = new BombTile(i,j);
          board[i][j] = bombTile;
          bombTile.updateNeighbors(board);
        }
      }
    }
  }

  private void parseMetadata(String line) {
    String[] boardData = line.split(SPACE);

    if (boardData.length != 2) {
      throw new IllegalStateException("illegal specification of board size");
    }

    this.rows = Integer.parseInt(boardData[0]);
    this.columns = Integer.parseInt(boardData[1]);
  }

  private void initBoard() {
    this.board = new Tile[rows][];

    for(int i=0; i<rows ; i++) {
      this.board[i] = new Tile[columns];

      for(int j = 0; j < columns ; j ++) {
        //By default, everything is a safe tile.
        this.board[i][j] = new SafeTile(i,j);
      }
    }
  }

  public String board() {
    StringBuilder display = new StringBuilder();
    for(int i = 0 ; i < rows; i ++) {
      for(int j = 0 ; j < columns; j++) {
        display.append(board[i][j].display());
      }

      if(i != rows - 1) {
        display.append(NEW_LINE);
      }
    }

    return display.toString();
  }
}
