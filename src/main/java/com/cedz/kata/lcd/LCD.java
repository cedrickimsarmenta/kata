package com.cedz.kata.lcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCD {

  public static final String NEW_LINE = "\n";
  public static final String SPACE = " ";

  private static Map<Integer, NumberDrawer> buildMapForDimensions(int width, int height) {
    List<NumberDrawer> drawers = Arrays.asList(
        new OneDrawer(width,height), new TwoDrawer(width,height), new ThreeDrawer(width,height), new FourDrawer(width,height), new FiveDrawer(width,height), new SixDrawer(width,height), new SevenDrawer(width,height), new EightDrawer(width,height), new NineDrawer(width,height), new ZeroDrawer(width,height)
    );
    Map<Integer, NumberDrawer> drawerMap = new HashMap<>();

    for (NumberDrawer drawer : drawers) {
      drawerMap.put(drawer.number(), drawer);
    }

    return drawerMap;
  }


  public static String toLCD(int number, int width, int height) {

    Map<Integer, NumberDrawer> numberDrawerMap = buildMapForDimensions(width,height);


    StringBuilder ret = new StringBuilder();

    List<NumberDrawer> drawers = collectDigitDrawers(number, numberDrawerMap);

    drawTop(ret, drawers);
    ret.append(NEW_LINE);
    drawMiddle(ret, drawers);
    ret.append(NEW_LINE);
    drawBottom(ret, drawers);

    System.out.println(ret);

    return ret.toString();
  }

  private static void drawBottom(StringBuilder ret, List<NumberDrawer> drawers) {
    for (int i = 0; i < drawers.size(); i++) {
      NumberDrawer drawer = drawers.get(i);
      List<String> drawerLines = drawer.drawBottom();
      appendDrawerLines(drawerLines, i != drawers.size() - 1, ret);
    }
  }

  private static void appendDrawerLines(List<String> drawerLines, boolean appendSpace, StringBuilder ret) {
    for (int i = 0; i < drawerLines.size(); i++) {
      String drawerLine = drawerLines.get(i);
      ret.append(drawerLine);

      if (appendSpace) {
        ret.append(SPACE);
      }

      if(i != drawerLines.size() - 1) {
        ret.append(NEW_LINE);
      }
    }
}

  private static void drawMiddle(StringBuilder ret, List<NumberDrawer> drawers) {
    for (int i = 0; i < drawers.size(); i++) {
      NumberDrawer drawer = drawers.get(i);
      List<String> drawerLines = drawer.drawMiddle();
      appendDrawerLines(drawerLines, i != drawers.size() - 1, ret);
    }
  }

  private static void drawTop(StringBuilder ret, List<NumberDrawer> drawers) {
    for (int i = 0; i < drawers.size(); i++) {
      NumberDrawer drawer = drawers.get(i);
      List<String> drawerLines = drawer.drawTop();
      appendDrawerLines(drawerLines, i != drawers.size() - 1, ret);
    }
  }

  private static List<NumberDrawer> collectDigitDrawers(int number, Map<Integer, NumberDrawer> numberDrawerMap) {
    List<NumberDrawer> drawers = new ArrayList<>();

    String numberStr = ("" + number);
    for (String digit : numberStr.split("")) {
      drawers.add(numberDrawerMap.get(Integer.parseInt(digit)));
    }

    return drawers;
  }

  private static interface NumberDrawer {
    public List<String> drawTop();

    public List<String> drawMiddle();

    public List<String> drawBottom();

    public int number();
  }

  public static abstract class AbtractDrawer implements NumberDrawer {
    private LineDrawer.Request topDescriptor;
    private LineDrawer.Request midDescriptor;
    private LineDrawer.Request bottomDescriptor;

    private int supportedNumber;
    private int width;
    private int height;

    public AbtractDrawer(LineDrawer.Request topDescriptor, LineDrawer.Request midDescriptor, LineDrawer.Request bottomDescriptor, int supportedNumber, int width, int height) {
      this.topDescriptor = topDescriptor;
      this.midDescriptor = midDescriptor;
      this.bottomDescriptor = bottomDescriptor;
      this.supportedNumber = supportedNumber;
      this.width = width;
      this.height = height;
    }

    @Override
    public List<String> drawTop() {
      //top always single line
      return LineDrawer.draw(topDescriptor, width, 1);
    }

    @Override
    public List<String> drawMiddle() {
      return  LineDrawer.draw(midDescriptor, width, height);
    }

    @Override
    public List<String> drawBottom() {
      return LineDrawer.draw(bottomDescriptor, width, height);
    }

    @Override
    public int number() {
      return supportedNumber;
    }
  }

  private static class OneDrawer extends AbtractDrawer  {
    public OneDrawer(int width, int height) {
      super(LineDrawer.Request.BLANK, LineDrawer.Request.LEFT_ONLY, LineDrawer.Request.LEFT_ONLY, 1, width, height);
    }
  }

  private static class TwoDrawer extends AbtractDrawer  {
    public TwoDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.MIDDLE_AND_RIGHT, LineDrawer.Request.LEFT_AND_MIDDLE, 2, width, height);
    }
  }

  private static class ThreeDrawer extends AbtractDrawer  {
    public ThreeDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.MIDDLE_AND_RIGHT, LineDrawer.Request.MIDDLE_AND_RIGHT, 3, width, height);
    }
  }

  private static class FourDrawer extends AbtractDrawer  {
    public FourDrawer(int width, int height) {
      super(LineDrawer.Request.BLANK, LineDrawer.Request.FULL, LineDrawer.Request.RIGHT_ONLY, 4, width, height);
    }
  }

  private static class FiveDrawer extends AbtractDrawer  {
    public FiveDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_MIDDLE, LineDrawer.Request.MIDDLE_AND_RIGHT, 5, width, height);
    }
  }
  private static class SixDrawer extends AbtractDrawer  {
    public SixDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_MIDDLE, LineDrawer.Request.FULL, 6, width, height);
    }
  }

  private static class SevenDrawer extends AbtractDrawer  {
    public SevenDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.RIGHT_ONLY, LineDrawer.Request.RIGHT_ONLY, 7, width, height);
    }
  }

  private static class EightDrawer extends AbtractDrawer {
    public EightDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.FULL, LineDrawer.Request.FULL, 8, width, height);
    }
  }

  private static class NineDrawer extends AbtractDrawer {
    public NineDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.FULL, LineDrawer.Request.MIDDLE_AND_RIGHT, 9, width, height);
    }
  }

  private static class ZeroDrawer extends AbtractDrawer {
    public ZeroDrawer(int width, int height) {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_RIGHT, LineDrawer.Request.FULL, 0, width, height);
    }
  }
  private static class LineDrawer {

    private static enum Request {

      BLANK(false, false, false),
      LEFT_ONLY(true, false, false),
      MIDDLE_ONLY(false, false, true),
      RIGHT_ONLY(false, true, false),
      LEFT_AND_MIDDLE(true, false, true),
      MIDDLE_AND_RIGHT(false, true, true),
      LEFT_AND_RIGHT(true, true, false),
      FULL(true, true, true);


      private boolean left;
      private boolean right;
      private boolean middle;

      private Request(boolean left, boolean right, boolean middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
      }
    }

    public static List<String> draw(Request request, int width, int height) {
      List<String> lines = new ArrayList<>();

      for (int i = 0; i < height; i ++) {
        drawSingleLine(request, width, lines, i == height -1);
      }

      return lines;
    }

    private static void drawSingleLine(Request request, int width, List<String> lines, boolean isLastLine) {
      StringBuilder line = new StringBuilder();

      line.append(request.left ? "|" : " ");
      for(int i = 0; i < width; i++ ) {
        line.append((request.middle && isLastLine) ? "_" : " ");
      }
      line.append(request.right ? "|" : " ");

      lines.add(line.toString());
    }
  }


}
