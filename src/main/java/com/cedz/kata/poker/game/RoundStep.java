package com.cedz.kata.poker.game;

import com.cedz.kata.poker.Card;

import java.util.List;

public interface RoundStep {
  void doAction(Round round);
}
