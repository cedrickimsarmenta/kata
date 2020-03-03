package com.cedz.kata.minesweeper

import spock.lang.Specification
import com.cedz.kata.minesweeper.Minesweeper
import spock.lang.Unroll;

class MinesweeperSpec extends Specification {
  @Unroll
  def "givenInput_whenInitMinesweeper_thenShouldDisplayBoard" () {

    expect:
    expectedResult == new Minesweeper(input).board();

    where:
    input    || expectedResult
    "1 1\n*" || "*"
  }
}
