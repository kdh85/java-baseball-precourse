package study;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}