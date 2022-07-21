package com.cedz.kata.sort.v2

import com.cedz.kata.sort.Sort
import spock.lang.Specification
import spock.lang.Unroll

class MergeSort2Spec extends Specification{
    private Sort sort = new MergeSort2();

    @Unroll
    def "GivenArray_WhenSort_ThenShouldSort" () {
        when:
        sort.sort(array);

        then:
        array == result

        where:
        array                 ||              result
        []                    ||              []
        [2,1]                 ||              [1,2]
        [2,1,3,5,4]           ||              [1,2,3,4,5]
        [1,2,3,4,5,1,2,3,4,5]					||						[1,1,2,2,3,3,4,4,5,5]
        [10,9,8,7,6,5,4,3,2,1]				||						[1,2,3,4,5,6,7,8,9,10]
        [1,2,3,4,5,6,7,8,9,10]				||						[1,2,3,4,5,6,7,8,9,10]
    }
}
