package baseball.model.ball;

import java.util.Objects;

import baseball.exception.PositionValueException;

public class BallPosition {

	private static final String MSG_ERROR_BALL_POSITION = "0~2사이의 정수를 사용해 주세요.";
	private static final int MIN_BALL_POSITION = 0;
	private static final int MAX_BALL_POSITION = 2;

	private final int position;

	public BallPosition(final int position) {
		if (position > MAX_BALL_POSITION || position < MIN_BALL_POSITION) {
			throw new PositionValueException(MSG_ERROR_BALL_POSITION);
		}
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallPosition that = (BallPosition)o;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public String toString() {
		return "BallPosition{" +
			"position=" + position +
			'}';
	}
}
