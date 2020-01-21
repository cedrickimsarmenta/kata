package com.cedz.kata.anagram;

import com.cedz.kata.calculator.Calculator
import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll

public class TwoWordAnagramSpec extends Specification{
	TwoWordAnagram twoWordAnagram = new TwoWordAnagram();
	@Unroll
	def "test anagram" () {
		expect:
		def actual = twoWordAnagram.anagrams(input)
		actual.containsAll(result);

		where:
		input                           ||  result
		"catdog"                        ||  ["cat dog"]

	}

}
