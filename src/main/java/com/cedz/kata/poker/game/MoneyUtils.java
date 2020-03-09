package com.cedz.kata.poker.game;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtils {

  public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
    return b1.add(b2).setScale(2, RoundingMode.HALF_UP);
  }

  public static BigDecimal substract(BigDecimal b1, BigDecimal b2) {
    return b1.subtract(b2).setScale(2, RoundingMode.HALF_UP);
  }
}
