package baseball.model.ball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

	private Balls balls;

	@BeforeEach
	void setUp() {
		balls = new Balls(new LinkedList<>(Arrays.asList(1, 2, 3)));
	}

	@DisplayName("볼들을 넣어서 볼즈를 생성한다.")
	@Test
	void createBallsTest() {
		assertThat(balls).isEqualTo(new Balls(new LinkedList<>(Arrays.asList(1, 2, 3))));
	}

	@DisplayName("공의수가 3개가 충족되지 않으면 에러를 반환한다.")
	@Test
	void validationBallsTest() {
		assertAll(
			() -> assertThatThrownBy(() -> new Balls(new LinkedList<>(Arrays.asList(1, 2))))
				.isInstanceOf(IllegalArgumentException.class),

			() -> assertThatThrownBy(() -> new Balls(new LinkedList<>(Arrays.asList(1, 2, 3, 4))))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@DisplayName("생성된 공들을 상대로 공3개를 비교해서 전체 볼 판정을 반환받는다.")
	@Test
	void matchThreeBalls() {
		List<BallType> ballTypes = balls.matchThreeBalls(new Balls(new LinkedList<>(Arrays.asList(1, 3, 4))));

		assertThat(ballTypes).containsExactly(BallType.STRIKE, BallType.BALL, BallType.NOTHING);
	}
}