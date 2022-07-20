package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;

import java.util.List;

public class QuickSort2 implements Sort {

    @Override
    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Integer> list, int low, int high) {
        if(low > high) {
            return;
        }
        int pivot = partition(list, low, high);

        this.quickSort(list, low, pivot -1);
        this.quickSort(list, pivot + 1, high);

    }

    private Integer partition(List<Integer> list, int low, int high) {
        int pivot = low;

        int pivotElement = list.get(pivot);
        int highIndex = high;
        for (int i = high; i > low; i--) {
            if(list.get(i) > pivotElement) {
                swap(i, highIndex, list);
                highIndex --;
            }
        }

        swap(pivot, highIndex, list);
        return highIndex;
    }

    private void swap(int x, int y, List<Integer> list) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }
}
