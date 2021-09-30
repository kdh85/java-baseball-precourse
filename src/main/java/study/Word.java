package study;

import java.util.Arrays;
import java.util.List;

public class Word {

	private final String word;

	public Word(String word) {
		this.word = word;
	}

	public List<String> splitWord(final String splitMark){
		return Arrays.asList(word.split(splitMark));
	}
}
