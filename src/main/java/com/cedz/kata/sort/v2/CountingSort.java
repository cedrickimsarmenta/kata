package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort implements Sort {
    private final Integer MAX = 10;
    @Override
    public void sort(List<Integer> list) {

        if(CollectionUtils.isNullOrEmpty(list)) {
            return;
        }
        int[] countArray = new int[MAX+1];

        for(int i = 0 ; i <list.size() ; i++) {
            int element = list.get(i);
            countArray[element] = countArray[element] + 1;
        }


        for(int i = 1 ; i <= MAX ; i++) {
            countArray[i] = countArray[i] + countArray[i-1] ;
        }

        int[] result = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++) {
            int element = list.get(i);
            int index = countArray[element];

            result[index-1] = element;

            countArray[element] = index-1;
        }
        for(int i = 0 ; i < result.length ; i++) {
            list.set(i, result[i]);
        }
    }
}
