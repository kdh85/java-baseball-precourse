package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
		assertThat(ball.isSameBall(new Ball(number, otherNumber))).isEqualTo(isSame);
	}

	@DisplayName("볼넘버만 같은 지를 확인한다.")
	@Test
	void isSameNumberTest() {
		assertThat(ball.isSameNumber(new Ball(1, 1))).isTrue();
	}

	@DisplayName("볼을 비교하여 같으면 스트라이크를 반환한다.")
	@Test
	void pitchResult_nothing_Test() {
		assertThat(ball.pitchResult(new Ball(2, 0))).isEqualTo(BallType.NOTHING);
	}

	@DisplayName("볼을 비교하여 같으면 스트라이크를 반환한다.")
	@Test
	void pitchResult_ball_Test() {
		assertThat(ball.pitchResult(new Ball(1, 1))).isEqualTo(BallType.BALL);
	}

	@DisplayName("볼을 비교하여 같으면 스트라이크를 반환한다.")
	@Test
	void pitchResult_strike_Test() {
		assertThat(ball.pitchResult(new Ball(1, 0))).isEqualTo(BallType.STRIKE);
	}
}