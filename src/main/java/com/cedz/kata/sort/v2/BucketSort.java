package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;

import java.util.*;

public class BucketSort implements Sort {
    private final Integer BUCKETS = 3;
    private InsertionSort insertionSort = new InsertionSort();
    @Override
    public void sort(List<Integer> list) {
        if(list == null || list.size() < 1) {
            return;
        }
        Integer range = (Collections.max(list) - Collections.min(list)) / BUCKETS;
        range = range > 0 ? range : 1;
        Map<Integer, List<Integer>> bucketList = new TreeMap<>();

        for(int i : list) {
            int index = i / range;

            if(!bucketList.containsKey(index)) {
                bucketList.put(index, new ArrayList<>());
            }
            bucketList.get(index).add(i);
        }


        for(List<Integer> bucket : bucketList.values()) {
            insertionSort.sort(bucket);
        }

        int k = 0;

        for(List<Integer> bucket : bucketList.values()) {
            for(int i : bucket) {
                list.set(k++, i);
            }
        }

    }
}
