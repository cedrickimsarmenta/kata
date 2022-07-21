package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

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
                CollectionUtils.swap(i, highIndex, list);
                highIndex --;
            }
        }

        CollectionUtils.swap(pivot, highIndex, list);
        return highIndex;
    }


}
