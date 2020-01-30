package com.cedz.kata.args;

public class IntegerFlagValue extends  AbstractFlagValue<Integer> {
  protected IntegerFlagValue() {
    super(FlagType.INTEGER);
  }

  @Override
  public void parseArgument(String argument) {
    this.setValue(Integer.parseInt(argument));
  }
}
