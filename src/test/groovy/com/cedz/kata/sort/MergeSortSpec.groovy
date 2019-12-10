package com.cedz.kata.sort;

import spock.lang.Specification;
import spock.lang.Unroll;

public class MergeSortSpec  extends Specification{
		
	
	 @Unroll
	 def "givenList_whenMergeSort_thenShouldSort" () {
	
		when:
		MergeSort.sort(list)
		
	 	then:
		expectedResult == list
	
	 	where:
		list 													||						expectedResult
		[]														||						[]
		[1]														||						[1]
		[2,1]													||						[1,2]
		[2,1,3,4,5]											    ||						[1,2,3,4,5]
		[1,2,3,4,5,1,2,3,4,5]									||						[1,1,2,2,3,3,4,4,5,5]
		[10,9,8,7,6,5,4,3,2,1]								||						[1,2,3,4,5,6,7,8,9,10]
		
	 }

}
