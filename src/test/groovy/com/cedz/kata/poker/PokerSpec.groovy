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
    hand.getHandType() == expectedHand
    hand.getCards() == cards
    hand.getHighCard() == expectedHighCard
    hand.getKicker() == expectedKicker

    where:
    cards                                                               || expectedHand                       | expectedHighCard              |     expectedKicker
    [HEART_2, HEART_3, HEART_4, HEART_5, SPADE_7]                       || HandType.HIGH_CARD                 |  Rank.SEVEN                   |     [HEART_2, HEART_3, HEART_4, HEART_5]
    [HEART_2, SPADE_2, HEART_3, HEART_4, SPADE_5]                       || HandType.PAIR                      |  Rank.TWO                     |     [HEART_3, HEART_4, SPADE_5]
    [HEART_2, SPADE_2, HEART_4, HEART_4, SPADE_5]                       || HandType.TWO_PAIRS                 |  Rank.FOUR                    |     [HEART_2, SPADE_2, SPADE_5]
    [HEART_2, SPADE_2, CLUBS_2, HEART_4, SPADE_5]                       || HandType.TRIO                      |  Rank.TWO                     |     null
    [HEART_2, SPADE_3, CLUBS_4, HEART_5, SPADE_6]                       || HandType.STRAIGHT                  |  Rank.SIX                     |     null
    [SPADE_6, SPADE_3, CLUBS_4, HEART_5, HEART_2]                       || HandType.STRAIGHT                  |  Rank.SIX                     |     null
    [HEART_10, SPADE_JACK, CLUBS_QUEEN, HEART_KING, SPADE_ACE]          || HandType.STRAIGHT                  |  Rank.ACE                     |     null
    [HEART_ACE, SPADE_2, CLUBS_3, HEART_4, SPADE_5]                     || HandType.STRAIGHT                  |  Rank.FIVE                    |     null
    [SPADE_JACK, CLUBS_QUEEN, HEART_KING, SPADE_ACE, SPADE_2]           || HandType.HIGH_CARD                 |  Rank.ACE                     |     [SPADE_JACK, CLUBS_QUEEN, HEART_KING, SPADE_2]
    [CLUBS_QUEEN, HEART_KING, SPADE_ACE, SPADE_2, SPADE_3]              || HandType.HIGH_CARD                 |  Rank.ACE                     |     [CLUBS_QUEEN, HEART_KING, SPADE_2, SPADE_3]
    [CLUBS_QUEEN, CLUBS_KING, CLUBS_6, CLUBS_ACE, CLUBS_3]              || HandType.FLUSH                     |  Rank.ACE                     |     [CLUBS_QUEEN, CLUBS_KING, CLUBS_6, CLUBS_3]
    [SPADE_ACE, CLUBS_2, CLUBS_3, CLUBS_4, CLUBS_5]                     || HandType.STRAIGHT                  |  Rank.FIVE                    |     null
    [HEART_QUEEN, HEART_KING, HEART_6, HEART_2, HEART_3]                || HandType.FLUSH                     |  Rank.KING                    |     [HEART_QUEEN, HEART_6, HEART_2, HEART_3]
    [HEART_QUEEN, SPADE_QUEEN, CLUBS_QUEEN, HEART_ACE, CLUBS_ACE]       ||  HandType.FULL_HOUSE               |  Rank.QUEEN                   |     null
    [HEART_QUEEN, SPADE_QUEEN, CLUBS_QUEEN, DIAMOND_QUEEN, CLUBS_ACE]   ||  HandType.FOUR_OF_A_KIND           |  Rank.QUEEN                   |     null
    [HEART_QUEEN, SPADE_QUEEN, CLUBS_QUEEN, DIAMOND_QUEEN, CLUBS_ACE]   ||  HandType.FOUR_OF_A_KIND           |  Rank.QUEEN                   |     null
    [HEART_3, HEART_4, HEART_5, HEART_6, HEART_7]                       ||  HandType.STRAIGHT_FLUSH           |  Rank.SEVEN                   |     null
    [SPADE_ACE, SPADE_2, SPADE_3, SPADE_4, SPADE_5]                     ||  HandType.STRAIGHT_FLUSH           |  Rank.FIVE                    |     null
    [SPADE_10, SPADE_JACK, SPADE_QUEEN, SPADE_KING, SPADE_ACE]          ||  HandType.ROYAL_FLUSH              |  Rank.ACE                     |     null
    [HEART_10, HEART_JACK, HEART_QUEEN, HEART_KING, HEART_ACE]          ||  HandType.ROYAL_FLUSH              |  Rank.ACE                     |     null
  }

  @Unroll
  def "givenPokerCards_whenBestHandWithCardsToTake_thenShouldFindBestHand"() {

    when:
    Hand hand = Poker.bestHand(cards,5);

    then:
    expectedCards.containsAll(hand.getCards())

    where:
    cards                                                                                  || expectedCards
    [HEART_2, HEART_3, HEART_4, HEART_5,SPADE_8 ,HEART_6, HEART_7]                         || [HEART_3, HEART_4, HEART_5, HEART_6, HEART_7]
    [HEART_2, HEART_3, HEART_4, SPADE_2,DIAMOND_2 ,DIAMOND_3, HEART_7]                     || [HEART_2, HEART_3, SPADE_2, DIAMOND_2, DIAMOND_3]
    [HEART_2, HEART_ACE, HEART_6,HEART_5, HEART_3 ,DIAMOND_4, HEART_7]                     || [HEART_ACE, HEART_7, HEART_6, HEART_5, HEART_3]
  }


}