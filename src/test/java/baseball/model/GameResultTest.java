package baseball.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

	@DisplayName("게임결과를 계산한다.")
	@Test
	void calculateScoreTest() {
		List<BallType> ballTypes = Arrays.asList(BallType.STRIKE, BallType.BALL, BallType.NOTHING);
		GameResult gameResult = new GameResult();
		gameResult.calculateScore(ballTypes);

		Map<BallType, Integer> ballTypeIntegerMap = gameResult.pitchResult();
		assertAll(
			() -> assertThat(ballTypeIntegerMap.get(BallType.STRIKE)).isEqualTo(1),
			() -> assertThat(ballTypeIntegerMap.get(BallType.BALL)).isEqualTo(1),
			() -> assertThat(ballTypeIntegerMap.get(BallType.NOTHING)).isEqualTo(1)
		);
	}

	@DisplayName("3스트라이크일때 게임종료값을 반환한다.")
	@Test
	void isGameEndTest() {

		GameResult finish = new GameResult();
		finish.calculateScore(Arrays.asList(BallType.STRIKE, BallType.STRIKE, BallType.STRIKE));

		GameResult notFinish = new GameResult();
		notFinish.calculateScore(Arrays.asList(BallType.STRIKE, BallType.BALL, BallType.STRIKE));

		assertAll(
			()->assertThat(finish.isGameEnd()).isTrue(),
			()->assertThat(notFinish.isGameEnd()).isFalse()
		);
	}
}