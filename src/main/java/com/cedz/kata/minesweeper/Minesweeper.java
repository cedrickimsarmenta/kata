package com.cedz.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {

  public static final String NEW_LINE = "\n";
  public static final String SPACE = " ";
  public static final char BOMB = '*';
  private GameState state = GameState.PENDING;
  private int rows;
  private int columns;
  private int bombs = 0;

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

  public void flag(int x, int y, FlagType flagType) {
    Tile tile = board[x][y];
    tile.flag(flagType);
  }


  public void leftClick(int x, int y) {
    Tile tile = board[x][y];

    if(this.state != GameState.PENDING) {
      throw new IllegalStateException("GAME IS ALREADY OVER");
    }
    if(tile.isBomb()) {
      //Game ends. Bomb is opened
      this.revealAllBombs();
      state = GameState.LOSE;
    } else {
      tile.leftClick(board);

      if(isSolved()) {
        //Game ends, all tiles except for bombs opened
        this.revealAllBombs();
        this.state = GameState.WIN;
      }
    }
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
          bombs++;
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

  public String boardState() {
    StringBuilder display = new StringBuilder();
    for(int i = 0 ; i < rows; i ++) {
      for(int j = 0 ; j < columns; j++) {
        display.append(board[i][j].displayState());
      }

      if(i != rows - 1) {
        display.append(NEW_LINE);
      }
    }

    return display.toString();
  }
  public void revealAllBombs() {

    for(Tile tile : getAllTiles()) {
      if(tile.isBomb()) {
        tile.leftClick(board);
      }
    }
  }
  public String userBoard() {
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


  /**
   * To be solved, all mines have to be opened
   * @return
   */
  public boolean isSolved() {
    for(Tile tile : getAllTiles()) {
      if(!tile.isBomb() && !tile.isOpen()) {
        return false;
      }
    }
    return true;
  }

  private List<Tile> getAllTiles() {
    List<Tile> result = new ArrayList<>(rows * columns);
    for(int i = 0 ; i < rows; i ++) {
      for(int j = 0 ; j < columns; j++) {
        result.add(board[i][j]);
      }
    }

    return result;
  }

  public int getBombsRemaining() {
    int bombsRemaining = bombs;

    for(Tile tile : getAllTiles()) {
      if(tile.getFlag() == FlagType.BOMB) {
        bombsRemaining --;
      }
    }

    return bombsRemaining;
  }
  public GameState getState() {
    return state;
  }
}
