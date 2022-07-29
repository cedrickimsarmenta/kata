package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.List;

public class ShellSort implements Sort {
    @Override
    public void sort(List<Integer> list) {
        if(CollectionUtils.isNullOrEmpty(list) || list.size() == 1) {
            return;
        }

        int interval = list.size() / 2;

        while (interval > 0) {
            for (int index = interval; index < list.size(); index ++) {
                InsertionSort.insertionSort(list, interval, index);
            }

            interval = interval / 2;
        }
    }

}
