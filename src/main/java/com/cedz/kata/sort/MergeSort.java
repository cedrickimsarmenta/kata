package com.cedz.kata.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static void sort(List<Integer> list) {
		mergeSort(list, 0, list.size()-1);	
	}
	
	private static void mergeSort(List<Integer> list, int low, int high) {
		
		if(high <= low) {
			return;
		}
		
		int middle = (low + high) / 2;
		mergeSort(list, low, middle);
		mergeSort(list, middle+1, high);
			
		merge(list, low, middle, high);
		
	}
	
	private static void merge(List<Integer> list, int low, int middle, int high) {
		
		int lowCtr = low;
		int highCtr = middle+1;
		int k = low;
		
		List<Integer> duplicate = new ArrayList<Integer>(list);
		
		while (k <= high) {
			if(highCtr > high) {
				list.set(k++, duplicate.get(lowCtr++));
			} else if (lowCtr > middle) {
				list.set(k++, duplicate.get(highCtr++));
			} else {
				int lowElement = duplicate.get(lowCtr);
				int highElement = duplicate.get(highCtr);
				if(lowElement < highElement) {
					list.set(k++, duplicate.get(lowCtr++));
				} else {
					list.set(k++, duplicate.get(highCtr++));
				}
			}
		}
	}
}
