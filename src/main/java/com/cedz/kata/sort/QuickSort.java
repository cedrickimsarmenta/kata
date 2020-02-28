package com.cedz.kata.sort;

import java.util.List;

public class QuickSort {
    public static void sort(List<Integer> p, int low, int high) {
      if(low > high) {
        return;
      }
      int pivot = partition(p, low, high);

      sort(p, low, pivot-1 );
      sort(p, pivot + 1, high );

  }

  public static int partition(List<Integer> list, int low, int high) {


    int nextLowIndex = low;
    int pivot = high;
    int pivotElement = list.get(pivot);
    for(int j = low; j < pivot ; j ++) {
      int currentElement = list.get(j);
      if(currentElement < pivotElement) {
        list.set(j, list.get(nextLowIndex));
        list.set(nextLowIndex, currentElement);
        nextLowIndex ++;
      }
    }
    list.set(pivot, list.get(nextLowIndex));
    list.set(nextLowIndex, pivotElement);

    return nextLowIndex;
  }
}
