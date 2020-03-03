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
    input                                                                 || expectedResult
    "1 1\n*"                                                              || "*"
    "1 5\n*****"                                                          || "*****"
    "5 1\n*\n*\n*\n*\n*"                                                  || "*\n*\n*\n*\n*"
    "1 1\n."                                                              || "0"
    "1 2\n.*"                                                             || "1*"
    "1 3\n.*."                                                            || "1*1"
    "3 3\n.*.\n*.*\n**."                                                  || "2*2\n*4*\n**2"
  }
}
