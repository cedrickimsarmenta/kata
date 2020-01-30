package com.cedz.kata.args;

import java.util.Objects;

public abstract  class AbstractFlagValue <T>  implements  FlagValue<T> {
  private T value;
  private  FlagType flagType;

  protected AbstractFlagValue(FlagType flagType) {
    this.flagType = flagType;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public FlagType getFlagType() {
    return flagType;
  }


  @Override
  public String toString() {
    return "AbstractFlagValue{" +
        "value=" + value +
        ", schema=" + flagType +
        '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractFlagValue<?> that = (AbstractFlagValue<?>) o;
    return Objects.equals(value, that.value) &&
        flagType == that.flagType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, flagType);
  }
}
