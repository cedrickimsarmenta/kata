package com.cedz.kata.anagram


import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll

public class AnagramSpec extends Specification{
	@Unroll
	def "test anagram" () {
		expect:
		Set<String> actual = new HashSet<>();
		Anagram.anagrams(input, size, actual)

		result.size == actual.size()
		result.containsAll(actual)

		where:
		input                  |		size         ||  result
		"a"                    |    1            ||  ["a"]
		"ab"                   |    2            ||  ["ba", "ab"]
    "abc"                  |    3            ||  ["abc", "acb", "bac", "bca","cab", "cba"]
		"ab"                   |    1            ||  ["a", "b"]
		"abc"                  |    1            ||  ["a", "b", "c"]
		"abc"                  |    2            ||  ["ab", "ba", "ac", "bc", "ca", "cb"]
		"abcd"                 |    4            ||  ["abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
																									"bacd", "badc", "bcad", "bcda", "bdac", "bdca",
																									"cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
																									"dabc", "dacb", "dbac", "dbca", "dcab", "dcba"]

		"abcd"                 |    3            ||  ["abc", "abd", "acb", "acd", "adb", "adc",
																									"bac", "bad", "bca", "bcd", "bda", "bdc",
																									"cab", "cad", "cba", "cbd", "cda", "cdb",
																									"dab", "dac", "dba", "dbc", "dca", "dcb"]

		"abcd"                 |    2            ||  ["ab", "ac", "ad",
																									"ba", "bc", "bd",
																									"ca", "cb", "cd",
																									"da", "db", "dc"]


	}
}
