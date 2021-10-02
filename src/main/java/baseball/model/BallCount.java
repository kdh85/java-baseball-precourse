package baseball.model;

import java.util.Objects;

public class BallCount {

	private static final int INCREASE_COUNT = 1;
	private static final int DEFAULT_COUNT = 0;

	private int ballCount;

	public BallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public void increaseCount(){
		ballCount += INCREASE_COUNT;
	}

	public Integer count(){
		return ballCount;
	}

	public void resetCount() {
		ballCount = DEFAULT_COUNT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallCount ballCount1 = (BallCount)o;
		return ballCount == ballCount1.ballCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ballCount);
	}

	@Override
	public String toString() {
		return "BallCount{" +
			"ballCount=" + ballCount +
			'}';
	}

}
