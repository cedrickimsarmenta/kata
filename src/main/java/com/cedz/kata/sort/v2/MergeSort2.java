package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MergeSort2 implements Sort {
    @Override
    public void sort(List<Integer> list) {
        if(!CollectionUtils.isNullOrEmpty(list)) {
            this.mergeSort(list, 0, list.size() - 1);
        }
    }

    private void mergeSort(List<Integer> list, int low, int high ) {
        if(low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        this.mergeSort(list, low, middle);
        this.mergeSort(list, middle+1 , high);
        this.merge(list, low, high, middle);
    }

    private void merge (List<Integer> list, int low, int high, int middle ) {
        int i = low;
        int j = middle+1;
        int size = (high - low) + 1;
        List<Integer> sorted = new ArrayList<>(size);


        while (sorted.size() < size) {
            if (j <= high && (i > middle || list.get(j) < list.get(i))) {
                sorted.add(list.get(j++));
            } else {
                sorted.add(list.get(i++));
            }
        }

        int k = 0;
        for(int z = low; z <= high ; z++) {
            list.set(z, sorted.get(k++));
        }
    }
}
