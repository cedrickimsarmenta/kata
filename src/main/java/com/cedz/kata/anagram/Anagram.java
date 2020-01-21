package com.cedz.kata.anagram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Anagram {

	public static void anagrams(String word, int length, Set<String> anagrams) {
			permute(word, 0, word.length()-1, anagrams, length);
	}



	/**
	 * permutation function
	 * @param str string to calculate permutation for
	 * @param l starting index
	 * @param r end index
	 */
	private static void permute(String str, int l, int r, Set<String> container, int length) {

		if (l == r) {
			container.add(str.substring(0, length));
		} else {
			for (int i = l; i <= r; i++) {


				str = swap(str,l,i);
				permute(str, l+1, r, container, length);
				str = swap(str,l,i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	private static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
