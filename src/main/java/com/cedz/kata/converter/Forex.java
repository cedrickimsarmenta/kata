package com.cedz.kata.converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Forex {

  public static final String DELIMITER = " ";

  private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#.00");

  private Map<ConversionId, BigDecimal> conversionRates = new HashMap<>();

  public Forex(Map<ConversionId, BigDecimal> conversionRates) {
    this.conversionRates = conversionRates;
  }


  public static class ConversionId {
    private String fromCurrency;
    private String toCurrency;

    public ConversionId(String fromCurrency, String toCurrency) {
      this.fromCurrency = fromCurrency;
      this.toCurrency = toCurrency;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ConversionId that = (ConversionId) o;
      return Objects.equals(fromCurrency, that.fromCurrency) &&
          Objects.equals(toCurrency, that.toCurrency);
    }

    @Override
    public int hashCode() {
      return Objects.hash(fromCurrency, toCurrency);
    }
  }

  public static class CurrencyValue {
    String currencyName;
    Integer amount;

    public CurrencyValue(String currencyName, Integer amount) {
      this.currencyName = currencyName;
      this.amount = amount;
    }

    public String getCurrencyName() {
      return currencyName;
    }

    public Integer getAmount() {
      return amount;
    }
  }
  public String convert(String fromCurrency, String toCurrency) {

    String[] fromDetails = fromCurrency.split(DELIMITER);
    String currency = fromDetails[0];

    int amount = Integer.parseInt(fromDetails[1]);
    CurrencyValue currencyValue = new CurrencyValue(currency, amount);
    BigDecimal newAmount = null;
    if(currencyValue.getCurrencyName().equals(toCurrency)) {
      newAmount = new BigDecimal(currencyValue.getAmount());
    }


    ConversionId targetConversionRate = new ConversionId(currencyValue.getCurrencyName(), toCurrency);

    if(conversionRates.containsKey(targetConversionRate)) {
      newAmount =  conversionRates.get(targetConversionRate).multiply(new BigDecimal(currencyValue.getAmount()));
    }

    return toCurrency + DELIMITER + NUMBER_FORMAT.format(newAmount.setScale(2, BigDecimal.ROUND_HALF_DOWN));
  }

}
