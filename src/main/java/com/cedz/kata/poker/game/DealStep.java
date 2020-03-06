package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;

import java.util.Arrays;
import java.util.Collections;

public class DealStep implements RoundStep {
  @Override
  public void doAction(Round round) {
    //Get Fresh Set of Courds
    round.getDeck().addAll(Arrays.asList(Card.values()));

    //Shuffle
    Collections.shuffle(round.getDeck());

    //Assign 2 cards per player
    for(int i = 0 ; i < 2; i ++) {
      for (Player p : round.getPlayers()) {
        round.dealCard(round.getDeck().pop(), p);
      }
    }
  }
}
