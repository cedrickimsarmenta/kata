package com.cedz.kata.args;

import java.util.Objects;

public class BooleanFlagValue extends  AbstractFlagValue<Boolean> {

  protected BooleanFlagValue() {
    super(FlagType.BOOLEAN);
  }

  @Override
  public void parseArgument(String argument) {
    Boolean b = Boolean.valueOf(argument);
    this.setValue(b);
  }
}
