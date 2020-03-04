package com.cedz.kata.minesweeper

import spock.lang.Specification
import spock.lang.Unroll;

class MinesweeperSpec extends Specification {
  @Unroll
  def "givenInput_whenInitMinesweeper_thenShouldDisplayState" () {

    expect:
    expectedResult == new Minesweeper(input).boardState();

    where:
    input                         || expectedResult
    "1 1\n*"                      || "*"
    "1 5\n*****"                  || "*****"
    "5 1\n*\n*\n*\n*\n*"          || "*\n*\n*\n*\n*"
    "1 1\n."                      || "0"
    "1 2\n.*"                     || "1*"
    "1 3\n.*."                    || "1*1"
    "3 3\n.*.\n*.*\n**."          || "2*2\n*5*\n**2"
    "4 4\n*...\n....\n.*..\n...." || "*100\n2210\n1*10\n1110"
    "3 5\n**...\n.....\n.*..."    || "**100\n33200\n1*100"

  }


  def "givenInput_whenInitAndLeftClickACtions_losingScenario_thenShouldDisplayBoard" () {
    given:
    Minesweeper minesweeper = new Minesweeper("4 4\n*...\n....\n.*..\n....");

    when:
    String userBoard = minesweeper.userBoard()

    then:
    "@@@@\n@@@@\n@@@@\n@@@@" == userBoard

    when:
    minesweeper.leftClick(0,0)
    userBoard = minesweeper.userBoard()

    then:
    "*@@@\n@@@@\n@*@@\n@@@@" == userBoard
    minesweeper.getState() == GameState.LOSE
  }

  def "givenInput_whenInitAndLeftClickACtions_winningScenario_thenShouldDisplayBoard" () {
    given:
    Minesweeper minesweeper = new Minesweeper("4 4\n*...\n....\n.*..\n....");

    when:
    String userBoard = minesweeper.userBoard()

    then:
    "@@@@\n@@@@\n@@@@\n@@@@" == userBoard


    when:
    minesweeper.leftClick(0,1)
    userBoard = minesweeper.userBoard()

    then:
    "@1@@\n@@@@\n@@@@\n@@@@" == userBoard
    minesweeper.getState() == GameState.PENDING

    when:
    minesweeper.leftClick(0,2)
    userBoard = minesweeper.userBoard()

    then:
    "@100\n@210\n@@10\n@@10" == userBoard
    minesweeper.getState() == GameState.PENDING


    when:
    minesweeper.leftClick(1,0)
    userBoard = minesweeper.userBoard()


    then:
    "@100\n2210\n@@10\n@@10" == userBoard
    minesweeper.getState() == GameState.PENDING

    when:
    //Click the remaining tiles
    minesweeper.leftClick(2,0)
    minesweeper.leftClick(2,2)
    minesweeper.leftClick(3,0)
    minesweeper.leftClick(3,1)

    userBoard = minesweeper.userBoard()

    then:
    "*100\n2210\n1*10\n1110" == userBoard
    minesweeper.getState() == GameState.WIN
  }


  def "givenInput_whenFlag_thenShouldDisplayFlag" () {
    given:
    Minesweeper minesweeper = new Minesweeper("4 4\n*...\n....\n.*..\n....");

    when:
    String userBoard = minesweeper.userBoard()

    then:
    "@@@@\n@@@@\n@@@@\n@@@@" == userBoard

    when:
    minesweeper.flag(0,0, FlagType.BOMB)
    userBoard = minesweeper.userBoard()

    then:
    "F@@@\n@@@@\n@@@@\n@@@@" == userBoard
    when:
    minesweeper.flag(0,0, FlagType.NONE)
    userBoard = minesweeper.userBoard()

    then:
    "@@@@\n@@@@\n@@@@\n@@@@" == userBoard

    when:
    minesweeper.flag(0,0, FlagType.UNCERTAIN)
    userBoard = minesweeper.userBoard()

    then:
    "?@@@\n@@@@\n@@@@\n@@@@" == userBoard

    when:
    minesweeper.flag(0,1, FlagType.UNCERTAIN)
    minesweeper.leftClick(0, 1)
    userBoard = minesweeper.userBoard()

    then:
    "?1@@\n@@@@\n@@@@\n@@@@" == userBoard
  }


  def "givenBoard_whenGetRemainingBombs_thenShouldReturnCorrectCount" () {
    given:
    Minesweeper minesweeper = new Minesweeper("4 4\n*...\n....\n.*..\n....");

    when:
    String userBoard = minesweeper.userBoard()

    then:
    2 == minesweeper.getBombsRemaining()

    when:
    minesweeper.flag(0,0, FlagType.BOMB)

    then:
    1 == minesweeper.getBombsRemaining()

    when:
    minesweeper.flag(0,0, FlagType.NONE)

    then:
    2 == minesweeper.getBombsRemaining()

    when:
    minesweeper.flag(0,0, FlagType.BOMB)
    minesweeper.flag(0,1, FlagType.BOMB)
    minesweeper.flag(0,2, FlagType.BOMB)

    then:
    -1 == minesweeper.getBombsRemaining()
  }
}
