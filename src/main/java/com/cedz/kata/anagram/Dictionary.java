package com.cedz.kata.anagram;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
	public static Dictionary  _INSTANCE;
	private Set<String> words = new HashSet<>();
	
	public static Dictionary getInstance() {
		if(_INSTANCE == null) {
			_INSTANCE = new Dictionary();
		}
		
		return _INSTANCE;
	}
	
	private Dictionary() {
		File  wordList = FileUtil.getInstance().getFileFromResources("words.txt");
		try {
			words.addAll(FileUtil.getInstance().readFile(wordList));
		} catch (IOException e) {
			throw new RuntimeException("Cannot instantiate dictionary");
		}
	}
	
	public Set<String> allWords() {
		return Collections.unmodifiableSet(words);
	}
	public boolean contains(String word) {
		return words.contains(word.toLowerCase());
	}
}
