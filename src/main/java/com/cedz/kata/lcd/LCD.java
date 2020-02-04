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
    for(NumberDrawer drawer : DRAWER_REGISTRY) {
      DRAWER_MAP.put(drawer.number(), drawer);
    }
  }
  public static String toLCD(int number) {
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
    for(int i = 0; i < drawers.size() ; i ++) {
      NumberDrawer drawer = drawers.get(i);
      ret.append(drawer.drawBottom());

      if(i != drawers.size() -1) {
        ret.append(SPACE);
      }
    }
  }

  private static void drawMiddle(StringBuilder ret, List<NumberDrawer> drawers) {
    for(int i = 0; i < drawers.size() ; i ++) {
      NumberDrawer drawer = drawers.get(i);
      ret.append(drawer.drawMiddle());

      if(i != drawers.size() -1) {
        ret.append(SPACE);
      }
    }
  }

  private static void drawTop(StringBuilder ret, List<NumberDrawer> drawers) {
    for(int i = 0; i < drawers.size() ; i ++) {
      NumberDrawer drawer = drawers.get(i);
      ret.append(drawer.drawTop());

      if(i != drawers.size() -1) {
        ret.append(SPACE);
      }
    }
  }

  private static List<NumberDrawer> collectDigitDrawers(int number) {
    List<NumberDrawer> drawers = new ArrayList<>();

    String numberStr = (""+number);
    for(String digit : numberStr.split("")) {
      drawers.add( DRAWER_MAP.get(Integer.parseInt(digit)));
    }

    return drawers;
  }
  private static interface NumberDrawer {
    public String drawTop();
    public String drawMiddle();
    public String drawBottom();
    public int number();
  }


  private static class OneDrawer implements  NumberDrawer {


    @Override
    public String drawTop() {
      return "   ";
    }

    @Override
    public String drawMiddle() {
      return "|  ";
    }

    @Override
    public String drawBottom() {
      return "|  ";
    }

    @Override
    public int number() {
      return 1;
    }
  }
  private static class TwoDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return " _|";
    }

    @Override
    public String drawBottom() {
      return "|_ ";
    }

    @Override
    public int number() {
      return 2;
    }
  }
  private static class ThreeDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return " _|";
    }

    @Override
    public String drawBottom() {
      return " _|";
    }

    @Override
    public int number() {
      return 3;
    }
  }

  private static class FourDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return "   ";
    }

    @Override
    public String drawMiddle() {
      return "|_|";
    }

    @Override
    public String drawBottom() {
      return "  |";
    }

    @Override
    public int number() {
      return 4;
    }
  }


  private static class FiveDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "|_ ";
    }

    @Override
    public String drawBottom() {
      return " _|";
    }

    @Override
    public int number() {
      return 5;
    }
  }
  private static class SixDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "|_ ";
    }

    @Override
    public String drawBottom() {
      return "|_|";
    }

    @Override
    public int number() {
      return 6;
    }
  }

  private static class SevenDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "  |";
    }

    @Override
    public String drawBottom() {
      return "  |";
    }

    @Override
    public int number() {
      return 7;
    }
  }
  private static class EightDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "|_|";
    }

    @Override
    public String drawBottom() {
      return "|_|";
    }

    @Override
    public int number() {
      return 8;
    }
  }
  private static class NineDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "|_|";
    }

    @Override
    public String drawBottom() {
      return " _|";
    }

    @Override
    public int number() {
      return 9;
    }
  }

  private static class ZeroDrawer implements  NumberDrawer {
    @Override
    public String drawTop() {
      return " _ ";
    }

    @Override
    public String drawMiddle() {
      return "| |";
    }

    @Override
    public String drawBottom() {
      return "|_|";
    }

    @Override
    public int number() {
      return 0;
    }
  }
}
