package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.Rank;
import com.cedz.kata.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  public List<Integer> getRankValues() {
    List<Integer> rankIndexes = this.getRankCounts().keySet().stream().map(Rank::getRank).collect(Collectors.toList());
    Collections.sort(rankIndexes);

    return rankIndexes;
  }

  public List<Rank> getSortedRanksDesc() {
    List<Rank> rankIndexes = new ArrayList<>(this.getRankCounts().keySet());

    Collections.sort(rankIndexes, new Comparator<Rank>() {
      @Override
      public int compare(Rank o1, Rank o2) {
        return o2.getRank().compareTo(o1.getRank());
      }
    });

    return rankIndexes;
  }
}
