package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains relevant and re-usable data about the hand
 */
public class HandContext {
  private List<Card> cards;
  //The counts per rank
  private Map<Rank, Integer> rankCounts = new HashMap<>();


  public HandContext(List<Card> cards) {
    this.cards = cards;

    for(Card c : cards)   {
      CollectionUtils.initOrIncrement(rankCounts, c.getRank());
    }
  }


  public List<Card> getCards() {
    return cards;
  }

  public Map<Rank, Integer> getRankCounts() {
    return rankCounts;
  }
}
