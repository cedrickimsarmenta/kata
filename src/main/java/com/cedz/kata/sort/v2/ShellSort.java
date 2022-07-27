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
                this.insertionSort(list, interval, index);
            }

            interval = interval / 2;
        }
    }
    public void insertionSort(List<Integer> list , int interval, int begin) {
        int k = begin - interval;
        int temp  = list.get(begin);

        while(k >= 0 && list.get(k) > temp) {
            list.set(k+interval, list.get(k));
            k-= interval;
        }

        list.set(k + interval , temp);

    }

}
