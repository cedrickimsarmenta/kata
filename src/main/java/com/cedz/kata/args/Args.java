package com.cedz.kata.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Args {

  public static final String SPACE = " ";
  public static final String DASH = "-";

  private Map<String, FlagSchema> schema;
  public Args(List<FlagSchema> schemaList) {
    schema = new HashMap<>();
    for(FlagSchema flagSchema : schemaList) {
      schema.put(flagSchema.getPrefix(), flagSchema);
    }
  }

  public List<FlagValue> parse(String input) {
    Map<String, FlagValue> resultMap = new HashMap<>();

    List<String> tokens = Arrays.asList(input.split(SPACE));
    FlagSchema capturedFlag = null;
    for(String token : tokens) {
      if(token.startsWith(DASH)) {
        String prefix = token.substring(1);
        FlagSchema schemaItem = schema.get(prefix);

        if(schemaItem.getFlagType() == FlagType.BOOLEAN) {
          BooleanFlagValue flagValue = new BooleanFlagValue(schemaItem);
          flagValue.setValue(true);
          resultMap.put(schemaItem.getPrefix(), flagValue);
        } else if (schemaItem.getFlagType() == FlagType.STRING)  {
          capturedFlag = schemaItem;
        }
      } else {
        if (capturedFlag != null && capturedFlag.getFlagType() == FlagType.STRING) {
          StringFlagValue flagValue = new StringFlagValue(capturedFlag);
          flagValue.setValue(token);
          resultMap.put(capturedFlag.getPrefix(), flagValue);
          capturedFlag = null;
        }
      }
    }

    //Default values
    for(FlagSchema schemaItem : schema.values()) {
      if(!resultMap.containsKey(schemaItem.getPrefix())) {
        if(schemaItem.getFlagType() == FlagType.BOOLEAN) {
          BooleanFlagValue flagValue = new BooleanFlagValue(schemaItem);
          flagValue.setValue(false);
          resultMap.put(schemaItem.getPrefix(), flagValue);
        }else if (schemaItem.getFlagType() == FlagType.STRING)  {
          StringFlagValue flagValue = new StringFlagValue(schemaItem);
          resultMap.put(schemaItem.getPrefix(), flagValue);
        }
      }
    }

    return new ArrayList<>(resultMap.values());
  }
}
