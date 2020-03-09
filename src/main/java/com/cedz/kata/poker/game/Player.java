package com.cedz.kata.poker.game;

import java.math.BigDecimal;
import java.util.Objects;

public class Player {
   private String username;
   private BigDecimal money = BigDecimal.ZERO;


  public Player(String username) {
    this.username = username;
  }


  public String getUsername() {
    return username;
  }

  public BigDecimal getMoney() {
    return money;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(username, player.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }

  public void deposit(BigDecimal amount) {

    money = MoneyUtils.add(money, amount);
   }

  @Override
  public String toString() {
    return username;
  }
}
