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

            int k = i-1;
            int temp  = list.get(i);

            while(k >= 0 && list.get(k) > temp) {
                list.set(k+1, list.get(k));
                k--;
            }

            list.set(k +1 , temp);
        }
    }

}
