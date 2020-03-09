package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.Card;
import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Suit;
import com.cedz.kata.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlushChecker extends AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {
    Map<Suit, Integer> countsBySuit = new HashMap<>();
    for(Card c : context.getCards())   {
      CollectionUtils.initOrIncrement(countsBySuit, c.getSuit());
    }

    if(countsBySuit.size() == 1 && CollectionUtils.getFirstValue(countsBySuit) == 5) {
      return HandType.FLUSH;
    }
    return null;
  }
}
