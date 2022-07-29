package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.List;

public class BubbleSort implements Sort {
    @Override
    public void sort(List<Integer> list) {
        if(list != null && list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i ++) {
                for(int j = i + 1; j < list.size() ; j++) {
                    if(list.get(j) < list.get(i)) {
                        CollectionUtils.swap(i,j,list);
                    }
                }
            }
        }
    }
}
