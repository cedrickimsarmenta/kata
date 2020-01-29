package com.cedz.kata.args;

import java.util.Objects;

public abstract  class AbstractFlagValue <T>  implements  FlagValue<T> {
  private T value;
  private  FlagSchema schema;

  protected AbstractFlagValue(FlagSchema schema) {
    this.schema = schema;
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
  public FlagSchema getFlagSchema() {
    return schema;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractFlagValue<?> that = (AbstractFlagValue<?>) o;
    return Objects.equals(value, that.value) &&
        Objects.equals(schema, that.schema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, schema);
  }

  @Override
  public String toString() {
    return "AbstractFlagValue{" +
        "value=" + value +
        ", schema=" + schema +
        '}';
  }
}
