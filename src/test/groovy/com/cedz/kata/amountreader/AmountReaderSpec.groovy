package com.cedz.kata.amountreader;

import spock.lang.Specification
import spock.lang.Unroll

class AmountReaderSpec  extends  Specification{
    AmountReader amountReader = new AmountReader()


    @Unroll
    def "test numbers to words" () {

        expect:
        output  == amountReader.toWords(input)

        where:
        input                           ||              output
        "1.00 ¥"                        ||              "one yen"
        "1.00 \$"                       ||              "one dollar"
        "2.00 \$"                       ||              "two dollars"
        "3.00 \$"                       ||              "three dollars"
        "12.00 \$"                      ||              "twelve dollars"
        "10.00 \$"                      ||              "ten dollars"
        "13.00 \$"                      ||              "thirteen dollars"
        "13.13 \$"                      ||              "thirteen dollars and thirteen cents"
        "13.01 \$"                      ||              "thirteen dollars and one cent"
        "0.13 \$"                       ||              "thirteen cents"
        "0.01 \$"                       ||              "one cent"
        "14.00 \$"                      ||              "fourteen dollars"
        "19.00 \$"                      ||              "nineteen dollars"
        "20.00 \$"                      ||              "twenty dollars"
        "22.00 \$"                      ||              "twenty two dollars"
        "22.22 \$"                      ||              "twenty two dollars and twenty two cents"
        "122.22 \$"                     ||              "one hundred twenty two dollars and twenty two cents"
        "322.22 \$"                     ||              "three hundred twenty two dollars and twenty two cents"
        "317.12 \$"                     ||              "three hundred seventeen dollars and twelve cents"
        "1000.00 \$"                    ||              "one thousand dollars"
        "1000.24 \$"                    ||              "one thousand dollars and twenty four cents"
        "1200.24 \$"                    ||              "one thousand two hundred dollars and twenty four cents"
        "1010.24 \$"                    ||              "one thousand ten dollars and twenty four cents"
        "1117.24 \$"                    ||              "one thousand one hundred seventeen dollars and twenty four cents"
        "2690124.24 \$"                 ||              "two million six hundred ninety thousand one hundred twenty four dollars and twenty four cents"
        "123002690124.24 \$"            ||              "one hundred twenty three billion two million six hundred ninety thousand one hundred twenty four dollars and twenty four cents"
        "200123002690124.24 \$"         ||              "two hundred trillion one hundred twenty three billion two million six hundred ninety thousand one hundred twenty four dollars and twenty four cents"

    }



}
