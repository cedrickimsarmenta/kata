package com.cedz.kata.leapyear

import spock.lang.Specification
import spock.lang.Unroll

class LeapYearSpec extends  Specification{
  @Unroll
  def "givenYear_whenIsLeapYear_thenShouldReturnCorrect" () {

    expect:
    expectedResult == LeapYear.isLeapYear(year)

    where:
    year                        || expectedResult
    400                         || true
    800                         || true
    1200                        || true
    1600                        || true
    1                           || false
    2                           || false
    3                           || false
    1700                        || false
    1800                        || false
    1900                        || false
    2100                        || false
    2008                        || true
    2012                        || true
    2016                        || true
    2015                        || false
    2017                        || false
  }
}
