package com.cedz.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class MinesweeperGame {

  public static final String REVEAL = "1";
  public static final String COMMAND_DELIMITER = "-";

  public static void main (String[] args) {
    //TODO: Clean up handling of game
    String meta = generateBoard();

    Minesweeper minesweeper = new Minesweeper(meta);
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Welcome to minesweeper!:\n");
    while (true) {
      System.out.println("Board:\n");
      System.out.println(minesweeper.userBoard());

      System.out.println("Enter command: \n[1]Reveal Item. Format (1-x-y) where x is the row and y is column. Example 1-0-0 reveals the tile at 0,0 coordinate\n");

      String command = myObj.nextLine();  // Read user input


      if (command.startsWith(REVEAL)) {
        String[] params = command.split(COMMAND_DELIMITER);
        Integer x = null;
        Integer y = null;

        try {
          x = Integer.parseInt(params[1]);
          y = Integer.parseInt(params[2]);
        } catch (Exception e) {
          System.out.println("Invalid input.\n");
          continue;
        }
        minesweeper.leftClick(x,y);

        GameState state = minesweeper.getState();
        switch (state) {
          case WIN:
            System.out.println("Congratulations! You win! \n");
            System.out.println("Board:\n");
            System.out.println(minesweeper.userBoard());
            return;
          case LOSE:
            System.out.println("Ooops! Sorry, you LOSE! \n");
            System.out.println("Board: \n");
            System.out.println(minesweeper.userBoard());
            return;
          case PENDING:
            continue;
        }
      }

    }
  }

  private static String generateBoard() {
    int rows = 5;
    int columns = 5;
    int bombCount = 5;

    StringBuilder input = new StringBuilder(rows + " " + columns + "\n");

    List<StringBuilder> field = new ArrayList<>();
    for(int i = 0 ; i < rows ; i ++) {
      StringBuilder line = new StringBuilder();
      for(int j= 0 ; j < columns ; j++) {
        line.append(".");
      }
      field.add(line);
    }

    int bombs =  0;
    while(bombs < bombCount) {
      int randomRow = Math.abs(new Random().nextInt()) % rows;
      int randomColumn = Math.abs(new Random().nextInt()) % columns;

      StringBuilder line = field.get(randomRow);

      char tile = line.charAt(randomColumn);

      if(tile != '*') {
        line.setCharAt(randomColumn, '*');
        bombs++;
      }
    }

    for(int i = 0 ; i < field.size(); i ++) {

      StringBuilder fieldItem = field.get(i);
      input.append(fieldItem);

      if(i != field.size() -1) {
        input.append("\n");
      }
    }

    return input.toString();
  }


}
