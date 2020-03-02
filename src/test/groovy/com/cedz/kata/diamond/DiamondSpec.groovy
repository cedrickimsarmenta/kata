package com.cedz.kata.diamond

import com.cedz.kata.leapyear.LeapYear
import spock.lang.Specification
import spock.lang.Unroll

class DiamondSpec extends Specification{
  @Unroll
  def "givenLetter_whenDiamond_thenShouldReturnDiamond" () {

    expect:
    Character charInput = input.charAt(0)
    expectedResult == Diamond.diamond(charInput)

    where:
    input                         || expectedResult
    'A'                           || "A"
    'B'                           || " A\nB B\n A"
    'C'                           || "  A\n B B\nC   C\n B B\n  A"
    'D'                           || "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A"
    'E'                           || "    A\n   B B\n  C   C\n D     D\nE       E\n D     D\n  C   C\n   B B\n    A"

  }
}
