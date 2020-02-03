package com.cedz.kata.potter

import spock.lang.Specification
import spock.lang.Unroll

class PotterSpec extends Specification {

  @Unroll
  def "givenOrder_whenCompute_thenShouldApplyDiscounts" () {

    expect:
    expectedResult == Potter.compute(order);

    where:
    order                        || expectedResult
    [:]                          || BigDecimal.ZERO
    [1:1]                        || new BigDecimal("8")
    [1:2]                        || new BigDecimal("16")
    [1:1, 2:1]                   || new BigDecimal("15.2")
    [1:2, 2:1]                   || new BigDecimal("23.2")
    [1:1, 2:1, 3:1]              || new BigDecimal("21.6")
    [1:1, 2:1, 3:1, 4:1]         || new BigDecimal("25.6")
    [1:1, 2:1, 3:1, 4:1, 5:1]    || new BigDecimal("30")
    [1:5, 2:4, 3:3, 4:2, 5:1]    || new BigDecimal("100.4")
    [1:2, 2:1, 3:1]              || new BigDecimal("29.60")
    [1:2, 2:2, 3:1,4:1]          || new BigDecimal("40.8")
    [1:1, 2:2, 3:2, 4:1]         || new BigDecimal("40.8")
    [1:1, 2:2, 3:2, 4:2, 5:1]    || new BigDecimal("51.2")
    [1:1, 2:2, 3:3, 4:2, 5:1]    || new BigDecimal("59.2")
    [1:5, 2:5, 3:4, 4:5, 5:4]    || new BigDecimal("141.20")
    [1:1, 2:1, 3:2, 4:2, 5:2]    || new BigDecimal("51.2")
    [1:4, 2:4, 3:5, 4:5, 5:5]    || new BigDecimal("141.20")
    [1:4, 2:4, 3:2, 4:2]         || new BigDecimal("81.6")
  }
}
