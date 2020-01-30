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
    }
    return null;
  }
}
