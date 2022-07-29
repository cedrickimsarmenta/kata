package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.List;

public class InsertionSort implements Sort {

    @Override
    public void sort(List<Integer> list) {
        if(CollectionUtils.isNullOrEmpty(list) || list.size() == 1) {
            return;
        }
        for (int i = 1; i < list.size(); i ++) {
            this.insertionSort(list, 1, i);
        }
    }

    public static void insertionSort(List<Integer> list , int interval, int begin) {
        int k = begin - interval;
        int temp  = list.get(begin);

        while(k >= 0 && list.get(k) > temp) {
            list.set(k+interval, list.get(k));
            k-= interval;
        }

        list.set(k + interval , temp);

    }

}



