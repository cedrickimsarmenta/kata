package com.cedz.kata.args;

import java.util.Arrays;
import java.util.List;

public class StringListFlagValue extends AbstractFlagValue<List<String>> {

  public static final String COMMA = ",";

  protected StringListFlagValue() {
    super(FlagType.STRING_LIST);
  }

  @Override
  public void parseArgument(String argument) {
    this.setValue(Arrays.asList(argument.split(COMMA)));
  }
}
