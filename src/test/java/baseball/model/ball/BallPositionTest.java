package baseball.model.ball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.PositionValueException;

class BallPositionTest {

	private BallPosition ballPosition;

	@BeforeEach
	void setUp() {
		ballPosition = new BallPosition(0);
	}

	@DisplayName("볼위치값을 주입하여 동일한 볼위치 객체를 생성한다.")
	@ParameterizedTest
	@CsvSource(value = {"0|true", "1|false"}, delimiter = '|')
	void createBallPositionTest(int position, boolean isSame) {
		assertThat(ballPosition.equals(new BallPosition(position))).isEqualTo(isSame);
	}

	@DisplayName("0~2를 벗어나는 위치값을 주입받으면 생성시 에러가 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	void validationPositionTest(int number) {
		assertThatThrownBy(
			() -> new BallPosition(number)
		).isInstanceOf(PositionValueException.class);
	}
}