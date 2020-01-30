package com.cedz.kata.args;

import java.util.Objects;

public class FlagSchema {
  private FlagType flagType;
  private String name;
  private String prefix;

  public FlagSchema(FlagType flagType, String name, String prefix) {
    this.flagType = flagType;
    this.name = name;
    this.prefix = prefix;
  }

  public FlagType getFlagType() {
    return flagType;
  }

  public String getName() {
    return name;
  }

  public String getPrefix() {
    return prefix;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FlagSchema that = (FlagSchema) o;
    return flagType == that.flagType &&
        Objects.equals(name, that.name) &&
        Objects.equals(prefix, that.prefix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flagType, name, prefix);
  }

  @Override
  public String toString() {
    return "FlagSchema{" +
        "flagType=" + flagType +
        ", name='" + name + '\'' +
        ", prefix='" + prefix + '\'' +
        '}';
  }
}
