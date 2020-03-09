package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Hand;
import com.cedz.kata.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public class ConsolePokerIO implements PokerIO {
  @Override
  public void printStatus(Round round) {

    System.out.println("Draw: ");
    printCards(round.getDraw());


    System.out.println("Players: ");

    for(Player p : round.getPlayers()) {
      System.out.print(p.getUsername() + " Chips: " + p.getMoney());
      System.out.println(" Cards: ");

      printCards(round.getCardsByPlayer(p));
    }

    System.out.println("Pot value: " + round.getPotMoney());

  }

  @Override
  public void printResult(Round round) {
    System.out.println("Best Hands by player: " );

    for(Player p : round.getPlayerBestHand().keySet()) {
      Hand hand = round.getPlayerBestHand().get(p);

      System.out.println("Player " + p + " cards: " + hand);
    }

    System.out.println("Congratulations to our winners: " );

    for(Player p : round.getPlayerResult().keySet()) {
      RoundStatus status = round.getPlayerResult().get(p);
      if(status == RoundStatus.WIN) {
          System.out.println(p);
      }
    }
  }

  private void printCards(List<Card> draw) {
    if(draw == null) {
      return;
    }
    for (Card card : draw) {
      System.out.print(card.display() + " ");
    }

    System.out.println();
  }
}
