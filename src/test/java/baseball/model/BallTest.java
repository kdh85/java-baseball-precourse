package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

	private Ball ball;

	@BeforeEach
	void setUp() {
		ball = new Ball(1, 0);
	}

	@DisplayName("볼넘버와 위치를 주입하여 볼 객체를 생성한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|0|true", "2|0|false", "1|1|false"}, delimiter = '|')
	void createBallTest(int number, int otherNumber, boolean isSame) {
		assertThat(ball.equals(new Ball(number, otherNumber))).isEqualTo(isSame);
	}
}