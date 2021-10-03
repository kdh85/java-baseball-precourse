package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTypeTest {

	@DisplayName("볼타입을 주입하여 해당 타입이 스트라이크인지를 반환한다.")
	@Test
	void isStrike() {
		assertThat(BallType.STRIKE.isStrike()).isTrue();
	}

	@DisplayName("볼타입을 주입하여 해당 타입이 볼인지를 반환한다.")
	@Test
	void isBall() {
		assertThat(BallType.BALL.isBall()).isTrue();
	}

	@DisplayName("볼타입을 주입하여 해당 타입이 낫싱인지를 반환한다.")
	@Test
	void isNothing() {
		assertThat(BallType.NOTHING.isNothing()).isTrue();
	}

	@DisplayName("같은 볼 두개를 주입하여 스트라이크가 반환된다.")
	@Test
	void ballDistinction_strikeTest() {

		BallType ballType = BallType.ballDistinction(new Ball(1, 0), new Ball(1, 0));

		assertThat(ballType).isEqualTo(BallType.STRIKE);
	}

	@DisplayName("같은 볼 두개를 주입하여 볼이 반환된다.")
	@Test
	void ballDistinction_ballTest() {

		BallType ballType = BallType.ballDistinction(new Ball(1, 0), new Ball(1, 1));

		assertThat(ballType).isEqualTo(BallType.BALL);
	}

	@DisplayName("같은 볼 두개를 주입하여 낫싱이 반환된다.")
	@Test
	void ballDistinction_nothingTest() {

		BallType ballType = BallType.ballDistinction(new Ball(1, 0), new Ball(3, 0));

		assertThat(ballType).isEqualTo(BallType.NOTHING);
	}

	@DisplayName("볼콜랙션과 볼을 받아서 볼타입 스트라이크를 반환한다.")
	@Test
	void ballsDistinction_StrikeTest() {
		BallType ballType = BallType.ballsDistinction(
			Arrays.asList(
				new Ball(1, 0),
				new Ball(2, 1),
				new Ball(3, 2)
			), new Ball(2, 1));
		assertThat(ballType).isEqualTo(BallType.STRIKE);
	}

	@DisplayName("볼콜랙션과 볼을 받아서 볼타입 볼을 반환한다.")
	@Test
	void ballsDistinction_BallTest() {
		BallType ballType = BallType.ballsDistinction(
			Arrays.asList(
				new Ball(1, 0),
				new Ball(2, 1),
				new Ball(3, 2)
			), new Ball(2, 2));
		assertThat(ballType).isEqualTo(BallType.BALL);
	}

	@DisplayName("볼콜랙션과 볼을 받아서 볼타입 낫싱을 반환한다.")
	@Test
	void ballsDistinction_nothingTest() {
		BallType ballType = BallType.ballsDistinction(
			Arrays.asList(
				new Ball(1, 0),
				new Ball(2, 1),
				new Ball(3, 2)
			), new Ball(4, 1));
		assertThat(ballType).isEqualTo(BallType.NOTHING);
	}
}