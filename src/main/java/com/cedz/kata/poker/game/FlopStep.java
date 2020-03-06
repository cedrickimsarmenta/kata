package com.cedz.kata.poker.game;

public class FlopStep implements RoundStep {
  @Override
  public void doAction(Round round) {
    round.getDraw().add(round.getDeck().pop());
    round.getDraw().add(round.getDeck().pop());
    round.getDraw().add(round.getDeck().pop());
  }
}
