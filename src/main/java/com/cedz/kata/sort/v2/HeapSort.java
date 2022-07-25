package com.cedz.kata.sort.v2;

import com.cedz.kata.sort.Sort;
import com.cedz.kata.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class HeapSort implements Sort {
    @Override
    public void sort(List<Integer> list) {
        if(CollectionUtils.isNullOrEmpty(list)) {
            return;
        }
        sort(list, list.size());
    }

    private void sort (List<Integer> list,  int size) {

        buildMaxHeap(list, size);

        while (size > 1) {
            CollectionUtils.swap(0, --size, list);
            heapify(list,0, size);
        }
    }

    private void buildMaxHeap(List<Integer> list, int size) {
        for (int i = (size / 2) - 1 ; i >= 0 ; i--) {
            heapify(list, i, size);
        }
    }

    private void heapify(List<Integer> list, int rootIndex, int size) {
        if(size <= 1) {
            return;
        }


        int rootStartIndex = 2 * rootIndex;
        int leftIndex =  rootStartIndex + 1;
        int rightIndex = rootStartIndex  + 2;


        int left = leftIndex < size ? list.get(leftIndex) : Integer.MIN_VALUE;
        int right = rightIndex < size ? list.get(rightIndex) : Integer.MIN_VALUE;
        int root = list.get(rootIndex);
        int max = Math.max(root, Math.max(right, left));

        if(max != root) {
            int largestIndex = left == max ? leftIndex : rightIndex;
            CollectionUtils.swap(rootIndex,  largestIndex , list);
            heapify(list, largestIndex, size);
        }
    }
}
