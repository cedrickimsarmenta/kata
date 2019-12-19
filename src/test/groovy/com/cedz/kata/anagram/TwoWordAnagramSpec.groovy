package com.cedz.kata.anagram;

import com.cedz.kata.calculator.Calculator

import spock.lang.Specification
import spock.lang.Unroll

public class TwoWordAnagramSpec extends Specification{
	TwoWordAnagram twoWordAnagram = new TwoWordAnagram();
	@Unroll
	def "test anagram" () {
		expect:
		twoWordAnagram.anagrams(input).containsAll(result);
//		result == twoWordAnagram.anagrams(input).containsAll(result);
		
		where:
		input                           ||  result
		"documenting"                   ||  ["encoding mut"]

	}

}
