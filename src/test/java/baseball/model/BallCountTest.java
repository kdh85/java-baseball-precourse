package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCountTest {

	private BallCount ballCount;

	@BeforeEach
	void setUp() {
		ballCount = new BallCount(0);
	}

	@DisplayName("볼 카운트 객체를 생성한다.")
	@Test
	void createBallTest() {
		assertThat(ballCount).isEqualTo(new BallCount(0));
	}

	@DisplayName("볼 카운트값을 1증가하는지 확인한다.")
	@Test
	void increaseBallCountTest() {
		ballCount.increaseCount();
		assertThat(ballCount).isEqualTo(new BallCount(1));
	}
}