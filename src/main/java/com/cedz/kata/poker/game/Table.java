package com.cedz.kata.poker.game;

import java.util.ArrayList;
import java.util.List;

public class Table {
  private List<Player> players = new ArrayList<>();
  //So we have game history
  private List<Round> rounds = new ArrayList<>();

  public void startRound() {
    Round round = new Round();
    round.addPlayer(players);
    round.start();
    rounds.add(round);
  }

  public void join(Player player) {
    this.players.add(player);
  }

  public void leave(Player player) {
    this.players.add(player);
  }
}
