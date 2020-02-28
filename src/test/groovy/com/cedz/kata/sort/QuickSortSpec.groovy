package com.cedz.kata.sort

import spock.lang.Specification
import spock.lang.Unroll

class QuickSortSpec extends Specification {
  @Unroll
  def "givenList_whenQuickSort_thenShouldSort" () {

    when:
    QuickSort.sort(list, 0, list.size() -1)

    then:
    expectedResult == list

    where:
    list 													||						expectedResult
    []														||						[]
    [1]														||						[1]
    [2,1]													||						[1,2]
    [2,1,3,4,5]										||						[1,2,3,4,5]
    [1,2,3,4,5,1,2,3,4,5]					||						[1,1,2,2,3,3,4,4,5,5]
    [10,9,8,7,6,5,4,3,2,1]				||						[1,2,3,4,5,6,7,8,9,10]
    [1,2,3,4,5,6,7,8,9,10]				||						[1,2,3,4,5,6,7,8,9,10]
  }


  @Unroll
  def "givenList_whenPartition_thenShouldSort" () {

    when:
    int index = QuickSort.partition(list, low, high)

    then:
    expectedResult == list
    index == expectedIndex

    where:
    list 									|    low      |   high				||						expectedResult        ||     expectedIndex
    [1,2,3,4]							|    0				|   3           ||						[1,2,3,4]             ||     3
    [2,4,6,3]							|    0				|   3           ||						[2,3,6,4]             ||     1
    [2,6,4,3]							|    0				|   3           ||						[2,3,4,6]             ||     1
    [10,12,5,6]						|    0				|   3           ||						[5,6,10,12]           ||     1
    [10,12,5,6]						|    0				|   2           ||						[5,12,10,6]           ||     0


  }
}
