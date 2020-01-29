package com.cedz.kata.args;

public interface FlagValue <T> {
  T getValue();
  void setValue(T value);
  FlagSchema getFlagSchema();
}
