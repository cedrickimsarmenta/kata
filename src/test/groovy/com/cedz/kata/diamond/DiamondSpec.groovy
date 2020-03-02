package com.cedz.kata.diamond

import com.cedz.kata.leapyear.LeapYear
import spock.lang.Specification
import spock.lang.Unroll

class DiamondSpec extends Specification{
  @Unroll
  def "givenLetter_whenDiamond_thenShouldReturnDiamond" () {

    expect:
    Character charInput = input.charAt(0)
    expectedResult == Diamond.diamond(charInput, size)

    where:
    input       |    size             || expectedResult
    'A'         |    1                || "A"
    'B'         |    1                || " A\nB B\n A"
    'C'         |    1                || "  A\n B B\nC   C\n B B\n  A"
    'D'         |    1                || "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A"
    'E'         |    1                || "    A\n   B B\n  C   C\n D     D\nE       E\n D     D\n  C   C\n   B B\n    A"
    'A'         |    2                || "A"
    'B'         |    2                || "  A\nB   B\n  A"
    'C'         |    2                || "    A\n  B   B\nC       C\n  B   B\n    A"
    'B'         |    3                || "   A\nB     B\n   A"
    'C'         |    3                || "      A\n   B     B\nC           C\n   B     B\n      A"
  }
}
