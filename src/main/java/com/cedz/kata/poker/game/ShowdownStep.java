package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Hand;
import com.cedz.kata.poker.Poker;
import com.cedz.kata.poker.factory.HandComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowdownStep implements RoundStep {

  private static final HandComparator comparator = new HandComparator();
  @Override
  public void doAction(Round round) {
    List<Player> winners = new ArrayList<>();

    Hand bestHand = null;
    List<Card>  draw = round.getDraw();
    for(Player p : round.getPlayers()) {
      List<Card>  playerCards = round.getCardsByPlayer(p);
      List<Card> combinedCards = new ArrayList<Card>(draw);
      combinedCards.addAll(playerCards);

      Hand playerHand = Poker.bestHand(combinedCards,5);

      round.getPlayerBestHand().put(p, playerHand);
      if(bestHand == null || comparator.compare(playerHand, bestHand) >= 0 ) {

        if(bestHand != null && comparator.compare(playerHand, bestHand) > 0)winners.clear();

        bestHand = playerHand;
        winners.add(p);
      }
    }


    for(Player p : round.getPlayers()) {
      if(winners.contains(p)) {
        round.getPlayerResult().put(p, RoundStatus.WIN);
      } else {
        round.getPlayerResult().put(p, RoundStatus.LOSE);
      }
    }
  }
}
