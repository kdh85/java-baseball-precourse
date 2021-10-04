package baseball.model.ball;

import java.util.Objects;

public class Ball {

	private final BallNumber ballNumber;

	private final BallPosition ballPosition;

	public Ball(int ballNumber, int ballPosition) {
		this(new BallNumber(ballNumber), new BallPosition(ballPosition));
	}

	public Ball(BallNumber ballNumber, BallPosition ballPosition) {
		this.ballNumber = ballNumber;
		this.ballPosition = ballPosition;
	}

	public BallType pitchResult(Ball targetBall) {
		return BallType.ballDistinction(this, targetBall);
	}

	public boolean isSameNumber(Ball userBall) {
		return this.ballNumber.isSameBallNumber(userBall.ballNumber);
	}

	public boolean isSameBall(Ball userBall) {
		return this.equals(userBall);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return Objects.equals(ballNumber, ball.ballNumber) && Objects.equals(ballPosition,
			ball.ballPosition);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ballNumber, ballPosition);
	}

	@Override
	public String toString() {
		return "Ball{" +
			"ballNumber=" + ballNumber +
			", ballPosition=" + ballPosition +
			'}';
	}
}