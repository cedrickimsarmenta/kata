package com.cedz.kata.poker.handChecker;

import com.cedz.kata.poker.HandType;
import com.cedz.kata.poker.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StraightChecker extends  AbstractHandChecker {
  @Override
  protected HandType doCheck(HandContext context) {

    if(context.getRankCounts().size() == 5) {
      List<Integer> rankIndexes = context.getRankCounts().keySet().stream().map(Rank::getRank).collect(Collectors.toList());
      Collections.sort(rankIndexes);

      //check for standard straight, eg, 2-3-4-5-6, 10-J-Q-K-A
      if (checkStraight(rankIndexes)) {
        return HandType.STRAIGHT;
      };

      //Note that while Ace is a high card, it can also be used as lower card for the straight 1-2-3-4-5. For Such case, the straight high card will be 5, not Ace
      if(rankIndexes.contains(Rank.ACE.getRank())) {
        //ACE will always be the highest rank, when ranks are unique. Set it to rank = 1 then re-sort
        rankIndexes.set(rankIndexes.size() -1, 1);
        Collections.sort(rankIndexes);

        //Check again for straight
        if (checkStraight(rankIndexes)) {
          return HandType.STRAIGHT;
        };
      }
    }
    return null;
  }

  private boolean checkStraight(List<Integer> rankIndexes) {
    for(int i = 1; i < rankIndexes.size() ; i ++) {
      if(rankIndexes.get(i) - rankIndexes.get(i-1) != 1 ) {
        return false;
      }
    }
    return true;
  }
}
