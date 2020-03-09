package com.cedz.kata.poker.game;

public class RiverOrTurnStep implements RoundStep {
  @Override
  public void doAction(Round round) {
    round.getDraw().add(round.getDeck().pop());
  }
}
