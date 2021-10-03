package baseball.model.ball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.model.ball.BallNumber;

class BallNumberTest {

	private BallNumber ballNumber;

	@BeforeEach
	void setUp() {
		ballNumber = new BallNumber(1);
	}

	@DisplayName("숫자를 입력하여 각각 동일한 볼넘버 객체를 생성한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|true", "2|false"}, delimiter = '|')
	void createBallNumberTest(int number, boolean isSame) {
		assertThat(ballNumber.equals(new BallNumber(number))).isEqualTo(isSame);
	}

	@DisplayName("1~9를 벗어나는 숫자를 입력하여 볼넘버를 생성시 에러가 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	void validationBallNumberTest(int number) {
		assertThatThrownBy(
			() -> new BallNumber(number)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("볼넘버 객체간에 비교를 통해 동일여부를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|true", "2|false"}, delimiter = '|')
	void matchBallNumberTest(int targetNumber, boolean isSame) {
		assertThat(ballNumber.isSameBallNumber(new BallNumber(targetNumber))).isEqualTo(isSame);
	}
}