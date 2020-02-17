package com.cedz.kata.lcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCD {

  private static final List<NumberDrawer> DRAWER_REGISTRY = Arrays.asList(
      new OneDrawer(), new TwoDrawer(), new ThreeDrawer(), new FourDrawer(), new FiveDrawer(), new SixDrawer(), new SevenDrawer(), new EightDrawer(), new NineDrawer(), new ZeroDrawer()
  );
  private static final Map<Integer, NumberDrawer> DRAWER_MAP = new HashMap<>();
  public static final String NEW_LINE = "\n";
  public static final String SPACE = " ";

  static {
    for (NumberDrawer drawer : DRAWER_REGISTRY) {
      DRAWER_MAP.put(drawer.number(), drawer);
    }
  }

  public static String toLCD(int number, int width, int height) {
    StringBuilder ret = new StringBuilder();

    List<NumberDrawer> drawers = collectDigitDrawers(number);

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
      ret.append(drawer.drawBottom());

      if (i != drawers.size() - 1) {
        ret.append(SPACE);
      }
    }
  }

  private static void drawMiddle(StringBuilder ret, List<NumberDrawer> drawers) {
    for (int i = 0; i < drawers.size(); i++) {
      NumberDrawer drawer = drawers.get(i);
      ret.append(drawer.drawMiddle());

      if (i != drawers.size() - 1) {
        ret.append(SPACE);
      }
    }
  }

  private static void drawTop(StringBuilder ret, List<NumberDrawer> drawers) {
    for (int i = 0; i < drawers.size(); i++) {
      NumberDrawer drawer = drawers.get(i);
      ret.append(drawer.drawTop());

      if (i != drawers.size() - 1) {
        ret.append(SPACE);
      }
    }
  }

  private static List<NumberDrawer> collectDigitDrawers(int number) {
    List<NumberDrawer> drawers = new ArrayList<>();

    String numberStr = ("" + number);
    for (String digit : numberStr.split("")) {
      drawers.add(DRAWER_MAP.get(Integer.parseInt(digit)));
    }

    return drawers;
  }

  private static interface NumberDrawer {
    public String drawTop();

    public String drawMiddle();

    public String drawBottom();

    public int number();
  }

  public static abstract class AbtractDrawer implements NumberDrawer {
    private LineDrawer.Request topDescriptor;
    private LineDrawer.Request midDescriptor;
    private LineDrawer.Request bottomDescriptor;

    private int supportedNumber;

    public AbtractDrawer(LineDrawer.Request topDescriptor, LineDrawer.Request midDescriptor, LineDrawer.Request bottomDescriptor, int supportedNumber) {
      this.topDescriptor = topDescriptor;
      this.midDescriptor = midDescriptor;
      this.bottomDescriptor = bottomDescriptor;
      this.supportedNumber = supportedNumber;
    }

    @Override
    public String drawTop() {
      return LineDrawer.draw(topDescriptor);
    }

    @Override
    public String drawMiddle() {
      return  LineDrawer.draw(midDescriptor);
    }

    @Override
    public String drawBottom() {
      return LineDrawer.draw(bottomDescriptor);
    }
    @Override
    public int number() {
      return supportedNumber;
    }
  }

  private static class OneDrawer extends AbtractDrawer  {
    public OneDrawer() {
      super(LineDrawer.Request.BLANK, LineDrawer.Request.LEFT_ONLY, LineDrawer.Request.LEFT_ONLY, 1);
    }
  }

  private static class TwoDrawer extends AbtractDrawer  {
    public TwoDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.MIDDLE_AND_RIGHT, LineDrawer.Request.LEFT_AND_MIDDLE, 2);
    }
  }

  private static class ThreeDrawer extends AbtractDrawer  {
    public ThreeDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.MIDDLE_AND_RIGHT, LineDrawer.Request.MIDDLE_AND_RIGHT, 3);
    }
  }

  private static class FourDrawer extends AbtractDrawer  {
    public FourDrawer() {
      super(LineDrawer.Request.BLANK, LineDrawer.Request.FULL, LineDrawer.Request.RIGHT_ONLY, 4);
    }
  }

  private static class FiveDrawer extends AbtractDrawer  {
    public FiveDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_MIDDLE, LineDrawer.Request.MIDDLE_AND_RIGHT, 5);
    }
  }
  private static class SixDrawer extends AbtractDrawer  {
    public SixDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_MIDDLE, LineDrawer.Request.FULL, 6);
    }
  }

  private static class SevenDrawer extends AbtractDrawer  {
    public SevenDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.RIGHT_ONLY, LineDrawer.Request.RIGHT_ONLY, 7);
    }
  }

  private static class EightDrawer extends AbtractDrawer {
    public EightDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.FULL, LineDrawer.Request.FULL, 8);
    }
  }

  private static class NineDrawer extends AbtractDrawer {
    public NineDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.FULL, LineDrawer.Request.MIDDLE_AND_RIGHT, 9);
    }
  }

  private static class ZeroDrawer extends AbtractDrawer {
    public ZeroDrawer() {
      super(LineDrawer.Request.MIDDLE_ONLY, LineDrawer.Request.LEFT_AND_RIGHT, LineDrawer.Request.FULL, 0);
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

    public static String draw(Request request) {
      StringBuilder line = new StringBuilder();

      line.append(request.left ? "|" : " ");
      line.append(request.middle ? "_" : " ");
      line.append(request.right ? "|" : " ");

      return line.toString();
    }
  }


}
