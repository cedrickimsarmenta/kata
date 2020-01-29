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
    "-s"                | [saltFlag()]                     ||  [createBooleanFlagValue(saltFlag(), true)]
    ""                  | [saltFlag()]                     ||  [createBooleanFlagValue(saltFlag(), false)]
    "-x /api -s"        | [saltFlag(), serverPrefix()]     ||  [createBooleanFlagValue(saltFlag(), true), createStringFlagValue(serverPrefix(), "/api")]
    ""                  | [saltFlag(), serverPrefix()]     ||  [createBooleanFlagValue(saltFlag(), false), createStringFlagValue(serverPrefix(), null)]


  }
  def createBooleanFlagValue(FlagSchema flagSchema, boolean value) {
    BooleanFlagValue booleanValue =  new BooleanFlagValue(flagSchema)
    booleanValue.setValue(value)

    booleanValue
  }

  def createStringFlagValue(FlagSchema flagSchema, String value) {
    StringFlagValue flagValue =  new StringFlagValue(flagSchema)
    flagValue.setValue(value)

    flagValue
  }
  private FlagSchema saltFlag() {
    return new FlagSchema(FlagType.BOOLEAN, "useSalt" , "s")
  }


  private FlagSchema serverPrefix() {
    return new FlagSchema(FlagType.STRING, "serverPrefix" , "x")
  }

}
