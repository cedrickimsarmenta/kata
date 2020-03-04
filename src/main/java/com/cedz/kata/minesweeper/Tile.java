package com.cedz.kata.minesweeper;

public interface Tile {
  /**
   * Display the state of the tile. For admin purposes and tracing only
   * @return
   */
  String displayState();
  void flag(FlagType flagType);
  FlagType getFlag();
  void incrementBombCount();
  int getNeighborBombCount();

  boolean isBomb();

  boolean isOpen();
  /**
   * Display what the user will see for the tile
   * @return
   */
  String display();

  void leftClick(Tile[][] board);

}
