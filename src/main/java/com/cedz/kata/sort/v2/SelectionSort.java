package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.List;

public class SelectionSort implements Sort {
    @Override
    public void sort(List<Integer> list) {
     if(CollectionUtils.isNullOrEmpty(list) || list.size() == 1) {
         return;
     }

     for(int i = 0; i < list.size()-1; i++) {
         Integer min = list.get(i);
         Integer minIndex = i;

         for(int j = i + 1; j< list.size(); j++) {
             if(list.get(j) < min) {
                 min = list.get(j);
                 minIndex = j;
             }
         }


         CollectionUtils.swap(minIndex, i, list);


     }
    }
}
