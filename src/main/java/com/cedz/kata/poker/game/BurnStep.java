package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;

public class BurnStep implements RoundStep {
  //Store so we have history
  private Card card;
  @Override
  public void doAction(Round round) {
    //Burn a card
    this.card = round.getDeck().pop();
  }
}
