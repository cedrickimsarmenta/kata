package com.cedz.kata.amountreader;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class AmountReader {


    private static final Map<Long, String> DIGITS_DICTIONARY = new HashMap<>();
    private static final Map<Long, String> TENS_DIGITS_DICTIONARY = new HashMap<>();
    private static final Map<Integer, String> POWER_DICTIONARY = new HashMap<>();


    public static final String SPACE = " ";
    public static final String AND = "and";
    public static final String CENTS = "cents";
    public static final String CENT = "cent";
    public static final String TEEN = "teen";
    public static final String HUNDRED = "hundred";

    static  {
        DIGITS_DICTIONARY.put(1l, "one");
        DIGITS_DICTIONARY.put(2l, "two");
        DIGITS_DICTIONARY.put(3l, "three");
        DIGITS_DICTIONARY.put(4l, "four");
        DIGITS_DICTIONARY.put(5l, "five");
        DIGITS_DICTIONARY.put(6l, "six");
        DIGITS_DICTIONARY.put(7l, "seven");
        DIGITS_DICTIONARY.put(8l, "eight");
        DIGITS_DICTIONARY.put(9l, "nine");
        DIGITS_DICTIONARY.put(10l, "ten");
        DIGITS_DICTIONARY.put(11l, "eleven");
        DIGITS_DICTIONARY.put(12l, "twelve");
        DIGITS_DICTIONARY.put(13l, "thirteen");

        TENS_DIGITS_DICTIONARY.put(2l, "twenty");
        TENS_DIGITS_DICTIONARY.put(3l, "thirty");
        TENS_DIGITS_DICTIONARY.put(4l, "forty");
        TENS_DIGITS_DICTIONARY.put(5l, "fifty");
        TENS_DIGITS_DICTIONARY.put(6l, "sixty");
        TENS_DIGITS_DICTIONARY.put(7l, "seventy");
        TENS_DIGITS_DICTIONARY.put(8l, "eighty");
        TENS_DIGITS_DICTIONARY.put(9l, "ninety");

        POWER_DICTIONARY.put(2, "thousand");
        POWER_DICTIONARY.put(3, "million");
        POWER_DICTIONARY.put(4, "billion");
        POWER_DICTIONARY.put(5, "trillion");

    }




    public  String toWords(String input) {
        MetaData metaData = MetaData.fromInput(input);

        if(metaData.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Need amount greater than 0");
        }

        StringBuilder response = new StringBuilder();

        if(metaData.getWholeNumber() > 0) {
            response.append(wholeAmountToWords(metaData.wholeNumber));
            response.append(SPACE);
            response.append(metaData.wholeNumber > 1 ? metaData.getCurrency().getDisplayNamePlural() : metaData.currency.getDisplayName());
        }

        if(metaData.getFraction() > 0) {

            if(metaData.getWholeNumber() > 0) {
                response.append(SPACE);
                response.append(AND);
                response.append(SPACE);
            }

            response.append(wholeAmountToWords(metaData.getFraction()));
            response.append(SPACE);
            response.append(metaData.getFraction() > 1 ? CENTS : CENT);
        }


        return response.toString();
    }


    private String wholeAmountToWords(Long wholeAmount) {



        List<String>  wordsForPowers = new ArrayList<>();

        long amount = wholeAmount;
        long remainder =0;
        while(amount > 0) {
            remainder = amount % 1000;
            wordsForPowers.add(wholeAmountToWardsForHundred(remainder));
            amount = amount/1000;
        }

        StringBuilder response  = new StringBuilder();
        Collections.reverse(wordsForPowers);
        Iterator<String> wordsIter = wordsForPowers.iterator();

        int power = wordsForPowers.size();

        while(wordsIter.hasNext()) {
            String wordForPower = wordsIter.next();

            if(wordForPower != null) {

                if(response.length() > 0) {
                    response.append(SPACE);
                }
                response.append(wordForPower);

                if(POWER_DICTIONARY.containsKey(power)) {
                    response.append(SPACE);
                    response.append(POWER_DICTIONARY.get(power--));
                }

            }
        }

        return response.toString();
    }

    private String wholeAmountToWardsForHundred(long wholeAmount) {

        if(wholeAmount == 0) {
            return null;
        }

        Long hundreds = (wholeAmount % 1000)/100;
        Long tens = (wholeAmount % 100)/10;
        Long ones = (wholeAmount % 10)/1;

        List<String> words = new ArrayList<>();

        if(hundreds > 0) {
            words.add(DIGITS_DICTIONARY.get(hundreds) + SPACE + HUNDRED);
        }


        if (tens > 1)  {

            words.add(TENS_DIGITS_DICTIONARY.get(tens));

            if(ones > 0) {
                words.add(DIGITS_DICTIONARY.get(ones));
            }

        } else if(ones > 3 && tens == 1) {

            words.add(DIGITS_DICTIONARY.get(ones) + TEEN);

        } else  {

            long remainingAmount = (tens * 10) + ones;

            if(remainingAmount> 0) {
                words.add(DIGITS_DICTIONARY.get(remainingAmount));
            }
        }

        return joinCollection(words);
    }


    private String joinCollection(List<String> words) {

        if(words.isEmpty()) {
            return  null;
        }

        StringBuilder response = new StringBuilder();

        Iterator<String> wordsIter = words.iterator();
        while(wordsIter.hasNext()) {
            String word = wordsIter.next();


            response.append(word);

            if(wordsIter.hasNext()) {
                response.append(SPACE);
            }
        }


        return response.toString();

    }



    static class MetaData {
        Currency currency;
        BigDecimal amount;
        Long fraction;
        Long wholeNumber;


        public static MetaData fromInput(String input) {
            String[] splitInput = input.split(SPACE);
            MetaData metaData = new MetaData();

            metaData.currency = Currency.getBySymbol(splitInput[1]);

            String amountString = splitInput[0];
            extractAmounts(metaData,amountString);

            return  metaData;
        }

        private static enum Currency {

            USD ("$", "dollar", "dollars"), YEN ("\u00A5", "yen", "yen") ;
            String symbol;
            String displayName;
            String displayNamePlural;

            Currency(String symbol, String displayName, String displayNamePlural) {
                this.symbol = symbol;
                this.displayName = displayName;
                this.displayNamePlural = displayNamePlural;
            }

            public String getSymbol() {
                return symbol;
            }

            public String getDisplayName() {
                return displayName;
            }

            public String getDisplayNamePlural() {
                return displayNamePlural;
            }

            static Currency  getBySymbol(String symbol) {

                for(Currency currency : Currency.values()) {
                    if(currency.getSymbol().equals(symbol)) {
                        return currency;
                    }
                }

                throw new IllegalArgumentException("Cannot find currency for symbol: "  + symbol);
            }

        }

        private static void extractAmounts(MetaData metaData, String amountString) {
            metaData.amount = new BigDecimal(amountString).setScale(2, RoundingMode.HALF_UP);

            // [2] Fraction part (0.30)
            BigDecimal fraction = metaData.amount.remainder(BigDecimal.ONE);

            // [3] Fraction as integer - move the decimal.
            BigDecimal fraction2 = fraction.movePointRight(metaData.amount .scale());

            metaData.fraction =fraction2.longValue();

            // [4] And the Integer part can result of:
            BigDecimal natural = metaData.amount.subtract(fraction);

            // [5] Since the fraction part of 'natural' is just Zeros, you can setScale(0) without worry about rounding
            natural = natural.setScale(0);

            metaData.wholeNumber = natural.longValue();
        }


        private MetaData() {
        }

        public Currency getCurrency() {
            return currency;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public Long getFraction() {
            return fraction;
        }

        public Long getWholeNumber() {
            return wholeNumber;
        }
    }
}
