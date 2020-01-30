package com.cedz.kata.args;

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

  public Map<FlagSchema, FlagValue> parse(String input) {
    Map<FlagSchema, FlagValue> resultMap = new HashMap<>();
    setDefaults(resultMap);

    List<String> tokens = Arrays.asList(input.split(SPACE));
    FlagSchema previous = null;
    for(String token : tokens) {
      if(token.startsWith(DASH)) {
        previous = handleFlag(resultMap, token);
      } else {
        handleValue(resultMap, previous, token);
        previous = null;
      }
    }
    return resultMap;
  }

  private void handleValue(Map<FlagSchema, FlagValue> resultMap, FlagSchema previous, String token) {
    if (previous != null) {
      resultMap.get(previous).parseArgument(token);
      previous = null;
    }
  }

  private FlagSchema handleFlag(Map<FlagSchema, FlagValue> resultMap, String token) {
    String prefix = token.substring(1);
    FlagSchema schemaItem = schema.get(prefix);
    FlagValue flagValue = resultMap.get(schemaItem);

    if(flagValue.getFlagType() == FlagType.BOOLEAN) {
      //TODO: Only special handling is boolean. Dont add interface method for now
      flagValue.setValue(true);
    }
    //Remember the item
    return schemaItem;
  }

  private void setDefaults(Map<FlagSchema, FlagValue> resultMap) {
    for(FlagSchema schemaItem : schema.values()) {
      if(!resultMap.containsKey(schemaItem.getPrefix())) {
        FlagValue flagValue = FlagValueFactory.createDefaultValueForType(schemaItem.getFlagType());
        resultMap.put(schemaItem, flagValue);
      }
    }
  }
}
