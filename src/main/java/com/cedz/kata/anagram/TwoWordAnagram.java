package com.cedz.kata.anagram;

import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoWordAnagram {
	private static final Integer MIN_LENGTH = 3;
	static {
		Dictionary.getInstance();
	}
	
	public Set<String> anagrams(String word) {
		Dictionary dictionary = Dictionary.getInstance();
		Set<String> result = new HashSet<>();

		int i = MIN_LENGTH;

		while (i <= (word.length() / 2)) {
			System.out.println("Checking anagrams");
			Set<String> iLengthAnagrams = new HashSet<String>();
			Anagram.anagrams(word, word.length()-i, iLengthAnagrams);
			
			for(String firstWord : iLengthAnagrams) {
				if(dictionary.contains(firstWord)) {
					//First word is a dictionary word. Need to find a partner, that is also a dicationary word
					String remainingWord = removeSequence(word, firstWord);
					
					Set<String> jLengthAnagrams = new HashSet<String>();


					Anagram.anagrams(remainingWord, remainingWord.length(), jLengthAnagrams);

					for(String secondWord : jLengthAnagrams) {
						if(dictionary.contains(secondWord)) {
							result.add(formatWords(firstWord, secondWord));
						}
					}
				}
			}
			
			i++;
			
		}
		
		
		
		return result;
	}
	
	private String removeSequence(String originalWord, String sequence) {
		String remainingWord = originalWord;
		
		for(int i = 0; i  < sequence.length(); i ++ ) {
			remainingWord = remainingWord.replaceFirst(sequence.charAt(i)+"", "");
		}
		
		return remainingWord;
				
	}







	private String formatWords(String word1, String word2) {
		
		if(word1.compareTo(word2) < 0) {
			 return word1 + " " + word2;
		} 
		
		return word2 + " " + word1;
		
		
	}
	
	private String sortWord(String word) {
		char[] wordChar =  word.toCharArray();
		Arrays.sort(wordChar);
		return new String(wordChar);
	}
}
