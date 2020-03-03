package com.cedz.kata.minesweeper;

public class Minesweeper {

  public static final String NEW_LINE = "\n";
  public static final String SPACE = " ";
  public static final char BOMB = '*';
  private int rows;
  private int columns;
  private char[][] board;

  public Minesweeper(String input) {
    if(input == null) {
      return;
    }

    String[] lines = input.split(NEW_LINE);

    String[] boardData = lines[0].split(SPACE);

    if (boardData.length != 2) {
      throw new IllegalStateException("illegal specification of board size");
    }

    this.rows = Integer.parseInt(boardData[0]);
    this.columns = Integer.parseInt(boardData[1]);

    this.board = new char[rows][];

    for(int i=0; i<rows ; i++) {
      this.board[i] = new char[rows];
    }

    for(int i = 0; i < rows; i++) {
      String line = lines[i+1];
      for(int j = 0; j < columns ; j++) {
        char tileChar = line.charAt(j);

        if(tileChar == BOMB){
          board[i][j] = BOMB;
        }

      }
    }

  }


  public String board() {
    StringBuilder display = new StringBuilder();
    for(int i = 0 ; i < rows; i ++) {
      for(int j = 0 ; j < columns; j++) {
        display.append(board[i][j]);
      }

      if(i != rows - 1) {
        display.append(NEW_LINE);
      }
    }

    return display.toString();
  }
}
