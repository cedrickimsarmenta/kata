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
    cards                                                           || expectedResult
    [HEART_2, HEART_3, HEART_4, HEART_5, SPADE_7]                   || HandType.HIGH_CARD
    [HEART_2, SPADE_2, HEART_3, HEART_4, SPADE_5]                   || HandType.PAIR
    [HEART_2, SPADE_2, HEART_4, HEART_4, SPADE_5]                   || HandType.TWO_PAIRS
    [HEART_2, SPADE_2, CLUBS_2, HEART_4, SPADE_5]                   || HandType.TRIO
    [HEART_2, SPADE_3, CLUBS_4, HEART_5, SPADE_6]                   || HandType.STRAIGHT
    [SPADE_6, SPADE_3, CLUBS_4, HEART_5, HEART_2]                   || HandType.STRAIGHT
    [HEART_10, SPADE_JACK, CLUBS_QUEEN, HEART_KING, SPADE_ACE]      || HandType.STRAIGHT
    [HEART_ACE, SPADE_2, CLUBS_3, HEART_4, SPADE_5]                 || HandType.STRAIGHT
    [SPADE_JACK, CLUBS_QUEEN, HEART_KING, SPADE_ACE, SPADE_2]       || HandType.HIGH_CARD
    [CLUBS_QUEEN, HEART_KING, SPADE_ACE, SPADE_2, SPADE_3]          || HandType.HIGH_CARD
  }
}