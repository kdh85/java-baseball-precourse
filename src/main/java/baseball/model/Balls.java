package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Balls {

	private static final String MSG_ERROR_BALLS_SIZE = "공의 수가 부족합니다.";
	private static final int LIMIT_BALLS_SIZE = 3;

	private final List<Ball> balls;

	public Balls(List<Integer> numbers) {
		this.balls = Collections.unmodifiableList(createBalls(numbers));
	}

	private List<Ball> createBalls(List<Integer> numbers) {
		AtomicInteger atomicInteger = new AtomicInteger();

		List<Ball> newBalls = new ArrayList<>();
		for (Integer number : numbers) {
			newBalls.add(new Ball(number, atomicInteger.getAndIncrement()));
		}

		validationBalls(newBalls);

		return newBalls;
	}

	private void validationBalls(List<Ball> balls) {
		if (balls.size() != LIMIT_BALLS_SIZE) {
			throw new IllegalArgumentException(MSG_ERROR_BALLS_SIZE);
		}
	}

	public BallType matchOneBall(Ball targetBall) {

		BallType resultBallType = BallType.NOTHING;

		for (Ball ball : balls) {
			resultBallType = strikeOrBall(targetBall, resultBallType, ball);
		}
		return resultBallType;
	}

	private BallType strikeOrBall(Ball targetBall, BallType resultBallType, Ball ball) {
		if(isStrikeOrBall(targetBall, ball)){
			resultBallType = ball.pitchResult(targetBall);
		}
		return resultBallType;
	}

	private boolean isStrikeOrBall(Ball targetBall, Ball ball) {
		return !ball.pitchResult(targetBall).isNothing();
	}

	public List<BallType> matchThreeBalls(Balls targetBalls) {
		List<BallType> results = new ArrayList<>();

		for (Ball targetBall : targetBalls.balls) {
			results.add(this.matchOneBall(targetBall));
		}

		return results;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Balls balls1 = (Balls)o;
		return Objects.equals(balls, balls1.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}

	@Override
	public String toString() {
		return "Balls{" +
			"balls=" + balls +
			'}';
	}
}
