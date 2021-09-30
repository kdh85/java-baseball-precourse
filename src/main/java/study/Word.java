package study;

import java.util.Arrays;
import java.util.List;

public class Word {

	private static final int START_INDEX = 1;
	private static final int END_INDEX = 4;

	private final String word;

	public Word(String word) {
		this.word = word;
	}

	public List<String> splitWord(final String splitMark) {
		return Arrays.asList(word.split(splitMark));
	}

	public String substringWord() {
		return word.substring(START_INDEX, END_INDEX);
	}

	public char getWordByIndex(int index) {
		return word.charAt(index);
	}
}
