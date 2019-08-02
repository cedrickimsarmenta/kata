package com.cedz.kata.converter

import org.junit.Before
import spock.lang.Specification
import spock.lang.Unroll

class ForexSpec extends  Specification {

  @Unroll
  def "givenValidPeso_whenConvert_thenShouldReturnCorrectValue" () {

    given:
    Map<Forex.ConversionId, BigDecimal> conversationRates = new HashMap<>()

    conversationRates.put(new Forex.ConversionId("PESO", "DOLLAR"), new BigDecimal("0.5"))

    Forex forex = new Forex(conversationRates)
    when:
    String result = forex.convert(fromAmount, toCurrency)

    then:
    result == expectedResult

    where:
    fromAmount | toCurrency || expectedResult
    "PESO 1"   | "PESO"     || "PESO 1.00"
    "PESO 2"   | "PESO"     || "PESO 2.00"
    "PESO 2"   | "DOLLAR"   || "DOLLAR 1.00"

  }
}
