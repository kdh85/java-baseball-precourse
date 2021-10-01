package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

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
}