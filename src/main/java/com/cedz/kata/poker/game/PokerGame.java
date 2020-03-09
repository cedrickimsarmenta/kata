package com.cedz.kata.poker.game;

import java.math.BigDecimal;
import java.util.Scanner;

import javafx.scene.control.Tab;

public class PokerGame {
  public static void main (String args[]) {
    Player cedz = new Player("Cedz");
    cedz.deposit(new BigDecimal(50000));

    Player vernie = new Player("Vernie");
    vernie.deposit(new BigDecimal(50000));

    Player levi = new Player("Levi1031");
    levi.deposit(new BigDecimal(50000));

    Player joennie = new Player("Jones");
    joennie.deposit(new BigDecimal(50000));

    Player alexis = new Player("Lex");
    alexis.deposit(new BigDecimal(50000));



    Table table = new Table();
    table.join(cedz);
    table.join(vernie);
    table.join(levi);
    table.join(joennie);
    table.join(alexis);


    System.out.println("WELCOME TO CEDDIE-POKER !");
    while(true) {

      System.out.println("PRESS ANY KEY TO START A ROUND");
      Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      String command = myObj.nextLine();  // Read user input

      table.startRound();
    }
  }
}
