package com.cedz.kata.lcd

import com.cedz.kata.potter.Potter
import spock.lang.Specification
import spock.lang.Unroll

class LCDSpec extends  Specification{
  @Unroll
  def "givenNumber_whenPrintLCD_thenShouldPrintCorrectly" () {

    expect:
    expectedResult == LCD.toLCD(number);

    where:
    number || expectedResult
    1      || one()
    11     || eleven()
    2      || two()
    12     || twelve()
    3      || three()
    4      || four()
    5      || five()
    6      || six()
    7      || seven()
    8      || eight()
    9      || nine()
    0      || zero()
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
  private static final String eight() {
    return " _ \n|_|\n|_|"
  }

  private static final String nine() {
    return " _ \n|_|\n _|"
  }

  private static final String zero() {
    return " _ \n| |\n|_|"
  }
}
