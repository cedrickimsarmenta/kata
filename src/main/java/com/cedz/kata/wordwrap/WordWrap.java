package com.cedz.kata.wordwrap;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {

  public static final char SPACE = ' ';
  public static final String LINE_BREAK = "\n";
  public static final String HYPHEN = "-";
  public static final String EMPTY = "";

  public static String wrap(String original, int columns) {
    if(original.length() > columns) {
      int end = columns;
      boolean hyphenated = false;
      while(end >=0 && original.charAt(end) != SPACE ) {
        end --;
      }

      if(end < 0) {
        //No space found. time to hyphenate
        end = columns-1;
        hyphenated = true;
      }
      String part = original.substring(0, end) + (hyphenated ? HYPHEN : EMPTY) + LINE_BREAK;
      String remaining = original.substring( end + (hyphenated ? 0 : 1));
      return part + wrap(remaining, columns);

    }
    return original;
  }
}
