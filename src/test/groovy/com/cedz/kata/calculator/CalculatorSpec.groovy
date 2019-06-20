package com.cedz.kata.calculator;

import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification{
//    private Calculator calculator = new Calculator();


    Calculator calculator = new Calculator();
    @Unroll
    def "test compute" () {
        expect:
        result == calculator.compute(input);

        where:
        input                           ||  result
        "0"                             || 0
        "0 + 1"                         || 1
        "0 + 1 + 2"                     || 3
        "0 - 1"                         || -1
        "0 - 1 - 2"                     || -3
        "0 - 1 - 2 + 4 - 5 + 6"         || 2
        "6 * 1"                         || 6
        "6 * 1 * 2"                     || 12
        "5 / 1"                         || 5
        "4 / 1 / 2"                     || 2
        "4 / 1 / 2 * 8 / 4"             || 4
        "4 + 2 * 8 - 4 / 2"             || 18

    }

}