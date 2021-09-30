package baseball.model;

import java.util.Objects;

public class BallNumber {

	private static final String MSG_ERROR_BALL_NUMBER = "1~9사이의 자연수를 입력해 주세요.";
	private static final int MIN_BALL_NUMBER = 1;
	private static final int MAX_BALL_NUMBER = 9;

	private final int ballNumber;

	public BallNumber(final int ballNumber) {
		if (ballNumber > MAX_BALL_NUMBER || ballNumber < MIN_BALL_NUMBER) {
			throw new IllegalArgumentException(MSG_ERROR_BALL_NUMBER);
		}
		this.ballNumber = ballNumber;
	}

	public boolean isSameBallNumber(BallNumber targetBallNumber) {
		return this.equals(targetBallNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallNumber that = (BallNumber)o;
		return ballNumber == that.ballNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ballNumber);
	}

	@Override
	public String toString() {
		return "BallNumber{" +
			"ballNumber=" + ballNumber +
			'}';
	}
}
