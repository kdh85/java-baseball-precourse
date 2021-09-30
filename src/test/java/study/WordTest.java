package study;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordTest {

	@DisplayName("1,2 라는 문자열을 , 기준으로 split 했을때 1과 2로 분리되는지 확인한다.")
	@Test
	void splitTest() {
		assertAll(
			() -> assertThat(new Word("1,2").splitWord(",")).containsExactly("1", "2"),
			() -> assertThat(new Word("1").splitWord(",")).containsExactly("1")
		);
	}

	@DisplayName("(1,2) 문자열 정보에서 (, ) 를 제거하고 1,2를 반환받는지 획인한다.")
	@Test
	void substringTest() {
		Word word = new Word("(1,2)");
		assertThat(word.substringWord()).isEqualTo("1,2");
	}

	@DisplayName("abc 문자열에서 특정 위치의 인덱스를 주입하여 해당 인덱스에 해당하는 글자를 반환하는지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"0,'a'", "1,'b'", "2,'c'"})
	void chatAtTest(int index, char word) {
		Word abc = new Word("abc");
		assertThat(abc.getWordByIndex(index)).isEqualTo(word);
	}

	@DisplayName("abc 문자열에서 길이값을 벗어나는 인덱스를 주입하면 에러가 발생하는지 확인한다.")
	@Test
	void validationChatAtTest() {
		assertThatThrownBy(
			() -> new Word("abc").getWordByIndex(4)
		).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}