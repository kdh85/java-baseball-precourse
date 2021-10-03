package baseball.model.count;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.count.StrikeCount;

class StrikeCountTest {

	private StrikeCount strikeCount;

	@BeforeEach
	void setUp() {
		strikeCount = new StrikeCount(0);
	}

	@DisplayName("스트라이크 카운트 객체를 생성한다.")
	@Test
	void createStrikeTest() {
		assertThat(strikeCount).isEqualTo(new StrikeCount(0));
	}

	@DisplayName("스트라이크 카운트값을 1증가하는지 확인한다.")
	@Test
	void increaseStrikeCountTest() {
		strikeCount.increaseCount();
		assertThat(strikeCount).isEqualTo(new StrikeCount(1));
	}

	@DisplayName("3스크라이크로 아웃인지를 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"3|true", "2|false"}, delimiter = '|')
	void threeStrikeOUtTest(int count, boolean isOut) {
		for (int index = 0; index < count; index++) {
			strikeCount.increaseCount();
		}
		assertThat(strikeCount.isThreeStrikeOut()).isEqualTo(isOut);
	}

	@DisplayName("스트라이크 카운트가 초기화된다.")
	@Test
	void resetCount() {
		strikeCount.increaseCount();
		strikeCount.resetCount();
		assertThat(strikeCount).isEqualTo(new StrikeCount(0));
	}
}