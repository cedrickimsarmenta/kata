package com.cedz.kata.wordwrap

import com.cedz.kata.calculator.Calculator
import spock.lang.Specification
import spock.lang.Unroll

class WordWrapSpec extends Specification {
  @Unroll
  def "test compute" () {
    expect:
    result == WordWrap.wrap(input, colSize);

    where:
    input                         | colSize || result
    ""                            | 100     || ""
    "hello"                       | 100     || "hello"
    "hello there"                 | 5       || "hello\nthere"
    "hello there child"           | 5       || "hello\nthere\nchild"
    "hello there child"           | 5       || "hello\nthere\nchild"
    "hello there child"           | 7       || "hello\nthere\nchild"
    "hello romina my child"       | 7       || "hello\nromina\nmy\nchild"
    "extravagant"                 | 7       || "extrav-\nagant"
    "extravagant nature"          | 7       || "extrav-\nagant\nnature"
    "extravagant nature of a man" |  7       || "extrav-\nagant\nnature\nof a\nman"
    "extravagant nature of a yu"  |  7       || "extrav-\nagant\nnature\nof a yu"


  }
}
