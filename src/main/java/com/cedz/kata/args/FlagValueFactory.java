package com.cedz.kata.args;

import java.util.List;

public class FlagValueFactory {
  public static FlagValue createDefaultValueForType(FlagType type) {
    if(type == FlagType.STRING) {
        return new StringFlagValue();
    } else if (type == FlagType.BOOLEAN) {
      BooleanFlagValue value  = new BooleanFlagValue();
      value.setValue(false);
      return value;
    } else if (type == FlagType.INTEGER) {
      IntegerFlagValue value = new IntegerFlagValue();
      value.setValue(8080);
      return value;
    }
    return null;
  }
}
