package com.cedz.kata.args

import com.cedz.kata.wordwrap.WordWrap
import spock.lang.Specification
import spock.lang.Unroll

class ArgsSpec extends  Specification{
  @Unroll
  def "test parse" () {
    given:

    Args args = new Args(schemaList);
    expect:
    result == args.parse(input)

    where:
    input               | schemaList                       ||  result
    "-s"                | [saltFlag()]                     ||  [(saltFlag()) : createBooleanFlagValue(true)]
    "-s false"          | [saltFlag()]                     ||  [(saltFlag()) : createBooleanFlagValue(false)]
    "-s true"           | [saltFlag()]                     ||  [(saltFlag()) : createBooleanFlagValue(true)]
    ""                  | [saltFlag()]                     ||  [(saltFlag()) : createBooleanFlagValue(false)]
    "-x /api -s"        | [saltFlag(), serverPrefix()]     ||  [(saltFlag()) : createBooleanFlagValue(true), (serverPrefix()) : createStringFlagValue("/api")]
    ""                  | [saltFlag(), serverPrefix()]     ||  [(saltFlag()) : createBooleanFlagValue(false), (serverPrefix()) : createStringFlagValue(null)]
    "-p 8000"           | [portFlag()]                     ||  [(portFlag()) : createIntegerFlagValue(8000)]




  }
  def createBooleanFlagValue(boolean value) {
    BooleanFlagValue booleanValue =  new BooleanFlagValue()
    booleanValue.setValue(value)

    booleanValue
  }

  def createStringFlagValue(String value) {
    StringFlagValue flagValue =  new StringFlagValue()
    flagValue.setValue(value)

    flagValue
  }

  def createIntegerFlagValue(Integer value) {
    IntegerFlagValue flagValue =  new IntegerFlagValue()
    flagValue.setValue(value)

    flagValue
  }

  private FlagSchema saltFlag() {
    return new FlagSchema(FlagType.BOOLEAN, "useSalt" , "s")
  }


  private FlagSchema serverPrefix() {
    return new FlagSchema(FlagType.STRING, "serverPrefix" , "x")
  }

  private FlagSchema portFlag() {
    return new FlagSchema(FlagType.INTEGER, "port" , "p")
  }
}
