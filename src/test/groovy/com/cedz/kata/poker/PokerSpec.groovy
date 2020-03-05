package com.cedz.kata.poker

import com.cedz.kata.potter.Potter
import spock.lang.Specification
import spock.lang.Unroll
import static com.cedz.kata.poker.Card.*;

class PokerSpec extends Specification {

  @Unroll
  def "givenPokerCards_whenBestHand_thenShouldFindBestHand"() {

    when:
    Hand hand = Poker.bestHand(cards);

    then:
    hand.getHandType() == expectedResult

    where:
    cards                                           || expectedResult
    [HEART_2, HEART_3, HEART_4, HEART_5, SPADE_6]   || HandType.HIGH_CARD
    [HEART_2, SPADE_2, HEART_3, HEART_4, SPADE_5]   || HandType.PAIR
    [HEART_2, SPADE_2, HEART_4, HEART_4, SPADE_5]   || HandType.TWO_PAIRS
    [HEART_2, SPADE_2, CLUBS_2, HEART_4, SPADE_5]   || HandType.TRIO


  }
}