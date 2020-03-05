package com.cedz.kata.poker

import com.cedz.kata.poker.factory.HandComparator
import spock.lang.Specification
import spock.lang.Unroll

import static com.cedz.kata.poker.Card.CLUBS_2
import static com.cedz.kata.poker.Card.CLUBS_3
import static com.cedz.kata.poker.Card.CLUBS_3
import static com.cedz.kata.poker.Card.CLUBS_3
import static com.cedz.kata.poker.Card.CLUBS_4
import static com.cedz.kata.poker.Card.CLUBS_4
import static com.cedz.kata.poker.Card.CLUBS_5
import static com.cedz.kata.poker.Card.CLUBS_6
import static com.cedz.kata.poker.Card.CLUBS_6
import static com.cedz.kata.poker.Card.CLUBS_7
import static com.cedz.kata.poker.Card.CLUBS_8
import static com.cedz.kata.poker.Card.CLUBS_ACE
import static com.cedz.kata.poker.Card.CLUBS_ACE
import static com.cedz.kata.poker.Card.CLUBS_ACE
import static com.cedz.kata.poker.Card.CLUBS_ACE
import static com.cedz.kata.poker.Card.CLUBS_KING
import static com.cedz.kata.poker.Card.CLUBS_KING
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.CLUBS_QUEEN
import static com.cedz.kata.poker.Card.DIAMOND_10
import static com.cedz.kata.poker.Card.DIAMOND_2
import static com.cedz.kata.poker.Card.DIAMOND_3
import static com.cedz.kata.poker.Card.DIAMOND_3
import static com.cedz.kata.poker.Card.DIAMOND_4
import static com.cedz.kata.poker.Card.DIAMOND_5
import static com.cedz.kata.poker.Card.DIAMOND_6
import static com.cedz.kata.poker.Card.DIAMOND_7
import static com.cedz.kata.poker.Card.DIAMOND_8
import static com.cedz.kata.poker.Card.DIAMOND_ACE
import static com.cedz.kata.poker.Card.DIAMOND_JACK
import static com.cedz.kata.poker.Card.DIAMOND_KING
import static com.cedz.kata.poker.Card.DIAMOND_QUEEN
import static com.cedz.kata.poker.Card.DIAMOND_QUEEN
import static com.cedz.kata.poker.Card.HEART_10
import static com.cedz.kata.poker.Card.HEART_10
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_2
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_3
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_4
import static com.cedz.kata.poker.Card.HEART_5
import static com.cedz.kata.poker.Card.HEART_5
import static com.cedz.kata.poker.Card.HEART_5
import static com.cedz.kata.poker.Card.HEART_5
import static com.cedz.kata.poker.Card.HEART_5
import static com.cedz.kata.poker.Card.HEART_6
import static com.cedz.kata.poker.Card.HEART_6
import static com.cedz.kata.poker.Card.HEART_6
import static com.cedz.kata.poker.Card.HEART_7
import static com.cedz.kata.poker.Card.HEART_8
import static com.cedz.kata.poker.Card.HEART_9
import static com.cedz.kata.poker.Card.HEART_ACE
import static com.cedz.kata.poker.Card.HEART_ACE
import static com.cedz.kata.poker.Card.HEART_ACE
import static com.cedz.kata.poker.Card.HEART_JACK
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_KING
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.HEART_QUEEN
import static com.cedz.kata.poker.Card.SPADE_10
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_2
import static com.cedz.kata.poker.Card.SPADE_3
import static com.cedz.kata.poker.Card.SPADE_3
import static com.cedz.kata.poker.Card.SPADE_3
import static com.cedz.kata.poker.Card.SPADE_3
import static com.cedz.kata.poker.Card.SPADE_3
import static com.cedz.kata.poker.Card.SPADE_4
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_5
import static com.cedz.kata.poker.Card.SPADE_6
import static com.cedz.kata.poker.Card.SPADE_6
import static com.cedz.kata.poker.Card.SPADE_7
import static com.cedz.kata.poker.Card.SPADE_8
import static com.cedz.kata.poker.Card.SPADE_9
import static com.cedz.kata.poker.Card.SPADE_ACE
import static com.cedz.kata.poker.Card.SPADE_ACE
import static com.cedz.kata.poker.Card.SPADE_ACE
import static com.cedz.kata.poker.Card.SPADE_ACE
import static com.cedz.kata.poker.Card.SPADE_ACE
import static com.cedz.kata.poker.Card.SPADE_JACK
import static com.cedz.kata.poker.Card.SPADE_JACK
import static com.cedz.kata.poker.Card.SPADE_JACK
import static com.cedz.kata.poker.Card.SPADE_JACK
import static com.cedz.kata.poker.Card.SPADE_KING
import static com.cedz.kata.poker.Card.SPADE_QUEEN
import static com.cedz.kata.poker.Card.SPADE_QUEEN
import static com.cedz.kata.poker.Card.SPADE_QUEEN
import static com.cedz.kata.poker.Card.SPADE_QUEEN

class HandComparatorSpec extends  Specification {
  @Unroll
  def "givenTwoHands_whenCompare_thenShouldCalculateCorrectly"() {

    given:
    Comparator<Hand> handComparator = new HandComparator();
    Hand hand1 = Poker.bestHand(cards1);
    Hand hand2 = Poker.bestHand(cards2);

    expect:
    expectedResult == handComparator.compare(hand1,hand2)
    //Always check transitivity
    expectedResult == handComparator.compare(hand2,hand1) * -1

    where:
    cards1                                                               |  cards2                                                                      ||  expectedResult
    //Different hand type calculations
    //High Card vs Pair
    [DIAMOND_2, CLUBS_3, CLUBS_4, CLUBS_5, CLUBS_7]                      |  [HEART_2, SPADE_2,  HEART_4, HEART_5, SPADE_7]                             || -1
    //Pair vs 2 pairs
    [HEART_2, HEART_3, HEART_4, HEART_ACE, SPADE_ACE]                    |  [HEART_2, SPADE_2,  HEART_4, SPADE_4, SPADE_7]                             || -1
    //2 pairs vs trio
    [HEART_2, HEART_3, HEART_4, HEART_ACE, SPADE_ACE]                    |  [HEART_2, SPADE_2,  CLUBS_2, SPADE_4, SPADE_7]                             || -1
    //trio vs straight
    [HEART_2, SPADE_2,  CLUBS_2, SPADE_4, SPADE_7]                       |  [SPADE_ACE, CLUBS_2,  CLUBS_3, CLUBS_4, CLUBS_5]                           || -1
    //straight vs flush
    [SPADE_ACE, CLUBS_2, CLUBS_3, CLUBS_4, CLUBS_5]                       |  [DIAMOND_2, DIAMOND_5,  DIAMOND_6, DIAMOND_7, DIAMOND_8]                  || -1
    //flush versus full house
    [DIAMOND_2, DIAMOND_5,  DIAMOND_6, DIAMOND_7, DIAMOND_8]              |  [SPADE_2, CLUBS_2,  DIAMOND_2, SPADE_3, DIAMOND_3]                        || -1
    //full house vs four of a kind
    [SPADE_5, CLUBS_5,  DIAMOND_5, DIAMOND_JACK, HEART_JACK]              |  [SPADE_2, CLUBS_2,  DIAMOND_2, HEART_2, DIAMOND_10]                       || -1
    //four of a kind vs Straight Flush
    [SPADE_2, CLUBS_2,  DIAMOND_2, HEART_2, DIAMOND_10]                   |  [DIAMOND_3, DIAMOND_4,  DIAMOND_5, DIAMOND_6, DIAMOND_7]                  || -1
    //Straight Flush vs Royal Flush
    [DIAMOND_3, DIAMOND_4,  DIAMOND_5, DIAMOND_6, DIAMOND_7]              |  [DIAMOND_10, DIAMOND_JACK,  DIAMOND_QUEEN, DIAMOND_KING, DIAMOND_ACE]     || -1

    //High card beats
    //High Card vs High Card
    [DIAMOND_2, DIAMOND_3, DIAMOND_4, DIAMOND_5, SPADE_7]                 |   [HEART_2, HEART_3, HEART_4, HEART_5, SPADE_8]                             || -1
    //Pair vs Pair
    [HEART_2, SPADE_2, HEART_4, HEART_ACE, SPADE_QUEEN]                   |   [SPADE_3, HEART_3, HEART_9, HEART_JACK, SPADE_KING]                      || -1
    //Two pair vs Two Pair
    [HEART_2, SPADE_2, HEART_4, SPADE_4, SPADE_QUEEN]                     |   [SPADE_3, HEART_3, HEART_7, SPADE_7, SPADE_KING]                         || -1
     //Trio vs Trio
    [HEART_2, SPADE_2, CLUBS_2, SPADE_4, SPADE_QUEEN]                     |   [SPADE_3, HEART_3, CLUBS_3, SPADE_7, SPADE_KING]                         || -1
    //Straight vs Straight
    [HEART_ACE, SPADE_2, CLUBS_3, SPADE_4, SPADE_5]                       |   [HEART_10, SPADE_JACK, CLUBS_QUEEN, SPADE_KING, SPADE_ACE]                || -1
    //Flush vs Flush
    [HEART_7, HEART_2, HEART_3, HEART_4, HEART_6]                         |   [SPADE_9, SPADE_JACK, SPADE_QUEEN, SPADE_KING, SPADE_ACE]                || -1
    //Full House vs Full House
    [HEART_2, SPADE_2, CLUBS_2, HEART_QUEEN, SPADE_QUEEN]                 |   [SPADE_3, HEART_3, CLUBS_3, HEART_KING, SPADE_KING]                      || -1
    //Four of a Kind vs Four of a Kind
    [HEART_2, SPADE_2, CLUBS_2, DIAMOND_2, SPADE_QUEEN]                   |   [SPADE_3, HEART_3, CLUBS_3, DIAMOND_3, SPADE_KING]                      || -1
    //Straight Flush vs Straight Flush
    [HEART_5, HEART_6, HEART_7, HEART_8, HEART_9]                         |   [SPADE_6, SPADE_7, SPADE_8, SPADE_9, SPADE_10]                           || -1
    //Kicker beats
    //High cards
    [DIAMOND_2, DIAMOND_3, DIAMOND_4, DIAMOND_5, CLUBS_8]                |   [HEART_2, HEART_3, HEART_4, HEART_6, SPADE_8]                             || -1
    [DIAMOND_2, DIAMOND_3, DIAMOND_4, DIAMOND_6, CLUBS_8]                |   [HEART_2, HEART_3, HEART_5, HEART_6, SPADE_8]                             || -1
    [DIAMOND_2, DIAMOND_3, DIAMOND_5, DIAMOND_6, CLUBS_8]                |   [HEART_2, HEART_4, HEART_5, HEART_6, SPADE_8]                             || -1
    [DIAMOND_2, DIAMOND_4, DIAMOND_5, DIAMOND_6, CLUBS_8]                |   [HEART_3, HEART_4, HEART_5, HEART_6, SPADE_8]                             || -1
    //Pair
    [DIAMOND_2, CLUBS_2, DIAMOND_4, DIAMOND_5, CLUBS_8]                |   [HEART_3, CLUBS_3, HEART_4, HEART_5, SPADE_9]                             || -1
    [DIAMOND_2, CLUBS_2, DIAMOND_4, DIAMOND_5, CLUBS_8]                |   [HEART_3, CLUBS_3, HEART_4, HEART_6, SPADE_8]                             || -1
    [DIAMOND_2, CLUBS_2, DIAMOND_4, DIAMOND_6, CLUBS_8]                |   [HEART_3, CLUBS_3, HEART_5, HEART_6, SPADE_8]                             || -1
    //2 Pairs
    [DIAMOND_2, CLUBS_2, DIAMOND_4, CLUBS_4, CLUBS_8]                  |   [HEART_2, SPADE_2, HEART_4, SPADE_4, SPADE_9]                             || -1\
    //2 Pairs
    [DIAMOND_2, CLUBS_2, DIAMOND_4, CLUBS_4, CLUBS_8]                  |   [HEART_2, SPADE_2, HEART_4, SPADE_4, SPADE_9]                             || -1
    //Flush
    [HEART_7, HEART_2, HEART_3, HEART_4, HEART_6]                      |   [SPADE_8, SPADE_2, SPADE_3, SPADE_4, SPADE_6]                             || -1
    [HEART_7, HEART_2, HEART_3, HEART_4, HEART_5]                      |   [SPADE_7, SPADE_2, SPADE_3, SPADE_4, SPADE_6]                             || -1
    [HEART_7, HEART_2, HEART_3, HEART_4, HEART_6]                      |   [SPADE_8, SPADE_2, SPADE_3, SPADE_5, SPADE_6]                             || -1
    [HEART_7, HEART_2, HEART_3, HEART_5, HEART_6]                      |   [SPADE_8, SPADE_2, SPADE_4, SPADE_5, SPADE_6]                             || -1
    [HEART_7, HEART_2, HEART_4, HEART_5, HEART_6]                      |   [SPADE_8, SPADE_3, SPADE_4, SPADE_5, SPADE_6]                             || -1
    //Ties
    //highcard
    [HEART_2, HEART_3, HEART_4, HEART_5, SPADE_7]                       |  [SPADE_2, DIAMOND_3,  DIAMOND_4, DIAMOND_5, DIAMOND_7]                    || 0
    //pair
    [HEART_2, CLUBS_2, HEART_4, HEART_5, SPADE_7]                       |  [SPADE_2, DIAMOND_2,  DIAMOND_4, DIAMOND_5, DIAMOND_7]                    || 0
    //two pairs
    [HEART_2, CLUBS_2, HEART_4, CLUBS_4, SPADE_7]                       |  [SPADE_2, DIAMOND_2,  SPADE_4, DIAMOND_4, DIAMOND_7]                      || 0
    //straight
    [HEART_ACE, SPADE_2, CLUBS_3, SPADE_4, SPADE_5]                     |   [DIAMOND_ACE, CLUBS_2, CLUBS_3, CLUBS_4, CLUBS_5]                        || 0
    //flush
    [HEART_7, HEART_2, HEART_4, HEART_5, HEART_6]                       |   [SPADE_7, SPADE_2, SPADE_4, SPADE_5, SPADE_6]                             || 0
    //straight flush
    [HEART_5, HEART_6, HEART_7, HEART_8, HEART_9]                       |   [SPADE_5, SPADE_6, SPADE_7, SPADE_8, SPADE_9]                            || 0
    //royal flush
    [HEART_10, HEART_JACK,  HEART_QUEEN, HEART_KING, HEART_ACE]          |  [DIAMOND_10, DIAMOND_JACK,  DIAMOND_QUEEN, DIAMOND_KING, DIAMOND_ACE]    || 0

  }
}
