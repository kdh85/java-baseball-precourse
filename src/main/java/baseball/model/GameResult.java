package baseball.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameResult {

	private static final int MAX_BALL_COUNT = 3;
	private static final int DEFAULT_COUNT = 0;

	private final StrikeCount strikeCount;

	private final BallCount ballCount;

	public GameResult() {
		this.strikeCount = new StrikeCount(DEFAULT_COUNT);
		this.ballCount = new BallCount(DEFAULT_COUNT);
	}

	public void calculateScore(final List<BallType> ballTypes) {

		for (BallType ballType : ballTypes) {
			increaseStrike(ballType);
			increaseBall(ballType);
		}
	}

	private void increaseBall(BallType ballType) {
		if (ballType.isBall()) {
			ballCount.increaseCount();
		}
	}

	private void increaseStrike(BallType ballType) {
		if (ballType.isStrike()) {
			strikeCount.increaseCount();
		}
	}

	public LinkedHashMap<BallType, Integer> pitchResult() {

		LinkedHashMap<BallType, Integer> result = new LinkedHashMap<>();

		for (BallType value : BallType.values()) {
			addStrike(result, value);
			addBall(result, value);
			addNothing(result, value);
		}
		return result;
	}

	private void addNothing(Map<BallType, Integer> result, BallType value) {
		if (value.isNothing()) {
			result.put(value, calculateNothing());
		}
	}

	private void addBall(Map<BallType, Integer> result, BallType value) {
		if (value.isBall()) {
			result.put(value, ballCount.count());
		}
	}

	private void addStrike(Map<BallType, Integer> result, BallType value) {
		if (value.isStrike()) {
			result.put(value, strikeCount.count());
		}
	}

	private int calculateNothing() {
		return MAX_BALL_COUNT - strikeCount.count() - ballCount.count();
	}

	public boolean isGameEnd() {
		return strikeCount.isThreeStrikeOut();
	}

	public void clearBallCount() {
		strikeCount.resetCount();
		ballCount.resetCount();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return strikeCount == that.strikeCount && ballCount == that.ballCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strikeCount, ballCount);
	}

	@Override
	public String toString() {
		return "GameResult{" +
			"strike=" + strikeCount +
			", ball=" + ballCount +
			'}';
	}

}
