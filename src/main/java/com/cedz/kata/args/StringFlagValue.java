package com.cedz.kata.args;

public class StringFlagValue extends  AbstractFlagValue<String>{

  protected StringFlagValue() {
    super(FlagType.STRING);
  }

  @Override
  public void parseArgument(String argument) {
    this.setValue(argument);
  }
}
