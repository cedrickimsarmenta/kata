package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Hand;
import com.cedz.kata.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Round {
  private List<Player> players = new ArrayList<>();
  private Map<Player, List<Card>> playerHand = new HashMap<>();
  private Map<Player, Hand> playerBestHand = new HashMap<>();

  private Map<Player, RoundStatus> playerResult = new HashMap<>();
  private List<RoundStep> steps = new ArrayList<>();
  private PokerIO  pokerIO;
  public Round() {
    //Used to interact with the user. for now, let's always use the console
    pokerIO = new ConsolePokerIO();
    steps.add(new DealStep());
    steps.add(new BurnStep());
    steps.add(new FlopStep());
    steps.add(new BurnStep());
    steps.add(new RiverOrTurnStep());
    steps.add(new BurnStep());
    steps.add(new RiverOrTurnStep());
    steps.add(new ShowdownStep());


  }


  private Stack<Card> deck = new Stack<>();
  private List<Card> draw = new ArrayList<>();

  private BigDecimal potMoney = BigDecimal.ZERO;

  public void dealCard(Card card, Player p) {
    CollectionUtils.initOrAppend(playerHand, p, card);
  }

  public List<Card> getCardsByPlayer(Player p) {
    return playerHand.get(p);
  }
  public void bet(Player player, BigDecimal amount) {
    if(player.getMoney().compareTo(amount) < 0) {
      throw new IllegalArgumentException("Player: " + player.getUsername() + " does not have enough money");
    }
    potMoney = MoneyUtils.add(potMoney, amount);
  }

  public void addPlayer(List<Player> players) {
    this.players.addAll(players);
  }

  public Map<Player, RoundStatus> start() {

    System.out.println("Starting Game");
    pokerIO.printStatus(this);

    for(RoundStep step : steps) {
      System.out.println("Executing step: " + step);
      step.doAction(this);
      if(!(step instanceof BurnStep)) {
        pokerIO.printStatus(this);
      }
    }

    pokerIO.printResult(this);
    return playerResult;
  }


  public List<Player> getPlayers() {
    return players;
  }

  public Map<Player, RoundStatus> getPlayerResult() {
    return playerResult;
  }

  public Stack<Card> getDeck() {
    return deck;
  }

  public List<Card> getDraw() {
    return draw;
  }

  public BigDecimal getPotMoney() {
    return potMoney;
  }


  public Map<Player, Hand> getPlayerBestHand() {
    return playerBestHand;
  }
}
