package com.cedz.kata.lcd

import com.cedz.kata.potter.Potter
import spock.lang.Specification
import spock.lang.Unroll

class LCDSpec extends  Specification{
  @Unroll
  def "givenNumber_whenPrintLCD_thenShouldPrintCorrectly" () {

    expect:
    expectedResult == LCD.toLCD(number,width, height);

    where:
    number | width   |  height || expectedResult
    1      | 1       |  1      || one()
    11     | 1       |  1      || eleven()
    2      | 1       |  1      || two()
    12     | 1       |  1      || twelve()
    3      | 1       |  1      || three()
    4      | 1       |  1      || four()
    5      | 1       |  1      || five()
    6      | 1       |  1      || six()
    7      | 1       |  1      || seven()
    8      | 1       |  1      || eight()
    9      | 1       |  1      || nine()
    0      | 1       |  1      || zero()
    7      | 2       |  1      || sevenWide()
    8      | 3       |  1      || eightVeryWide()
    1      | 3       |  1      || oneVeryWide()
    7      | 1       |  2      || sevenHigh()
    8      | 1       |  2      || eightHigh()
    8      | 1       |  3      || eightVeryHigh()
    2      | 1       |  2      || twoHigh()
    22     | 1       |  2      || twentyTwoHigh()

  }

  private static final String one() {
    return "   \n|  \n|  "
  }
  private static final String eleven() {
    return "       \n|   |  \n|   |  "
  }
  private static final String two() {
    return " _ \n _|\n|_ "
  }

  private static final String twelve() {
    return "     _ \n|    _|\n|   |_ "
  }
  private static final String three() {
    return " _ \n _|\n _|"
  }
  private static final String four() {
    return "   \n|_|\n  |"
  }
  private static final String five() {
    return " _ \n|_ \n _|"
  }
  private static final String six() {
    return " _ \n|_ \n|_|"
  }

  private static final String seven() {
    return " _ \n  |\n  |"
  }

  private static final String sevenWide() {
    return " __ \n   |\n   |"
  }


  private static final String eight() {
    return " _ \n|_|\n|_|"
  }
  private static final String eightHigh() {
    return " _ \n| |\n" +
            "|_|\n" +
            "| |\n|_|"
  }

  private static final String eightVeryHigh() {
    return " _ \n| |\n" +
            "| |\n" +
            "|_|\n" +
            "| |\n" +
            "| |\n|_|"
  }
  private static final String nine() {
    return " _ \n|_|\n _|"
  }

  private static final String zero() {
    return " _ \n| |\n|_|"
  }

  private static final String eightVeryWide() {
    return " ___ \n|___|\n|___|"
  }

  private static final String oneVeryWide() {
    return "     \n|    \n|    "
  }

  private static final String sevenHigh() {
    return " _ \n  |\n" +
            "  |\n" +
            "  |\n  |"
  }
  private static final String twoHigh() {
    return " _ \n" +
            "  |\n _|\n" +
            "|  \n|_ "
  }

  private static final String twentyTwoHigh() {
    return " _   _ \n" +
            "  |   |\n _|  _|\n" +
            "|   |  \n|_  |_ "
  }

}
