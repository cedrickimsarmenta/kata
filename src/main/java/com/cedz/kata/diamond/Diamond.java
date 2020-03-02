package com.cedz.kata.diamond;

public class Diamond {

  public static final String SPACE = " ";
  public static final String NEW_LINE = "\n";

  public static String diamond(char letter) {
    char start = 'A';

    int height = (letter - start) + 1;

    StringBuilder resultTopAndMiddle = new StringBuilder();

    StringBuilder resultBottom = new StringBuilder();

    for(int i = 0 ; i < height ; i ++) {
      String currentLine = generateLine(height, i, start); //since this is a diamond we need to append to the top, and the bottom. except for the middle of the diamond.
      //append to the top and middle
      resultTopAndMiddle.append(currentLine);

      if(i < height - 1) {
        //not the middle of the diamond
        resultBottom.insert(0, currentLine);
      }

      //move to the next char
      start++;
    }

    String allLines = resultTopAndMiddle.append(resultBottom.toString()).toString();

    //Remove the last space at the end
    return removeLastNewLine(allLines);
  }

  private static String removeLastNewLine(String allLines) {
    return allLines.substring(0, allLines.length()-1);
  }

  private static String generateLine(int height, int i, char current) {
    StringBuilder result = new StringBuilder();

    handlePrefixSpaces(height, i, result);

    result.append(current);

    //Except for the first element (tips, all characters appear twice, where the gap between chars increases as you go to the middle)
    if(i > 0) {
      handleMiddleSpaces(i, result);

      result.append(current);
    }

    result.append(NEW_LINE);

    return result.toString();
  }

  private static void handleMiddleSpaces(int i, StringBuilder result) {
    if(i == 0) return;
    for (int j = 0; j < ((i - 1) * 2) + 1 ; j++) {
      result.append(SPACE);
    }
  }

  private static void handlePrefixSpaces(int height, int i, StringBuilder result) {
    for(int j = 0; j < height - i -1; j ++) {
      result.append(SPACE);
   }
  }
}
