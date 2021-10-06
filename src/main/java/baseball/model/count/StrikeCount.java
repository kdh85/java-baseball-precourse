package baseball.model.count;

import java.util.Objects;

import baseball.model.game.Count;

public class StrikeCount implements Count {

	private static final int INCREASE_COUNT = 1;
	private static final int OUT_COUNT = 3;
	private static final int DEFAULT_COUNT = 0;

	private int strikeCount;

	public StrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	@Override
	public void increaseCount() {
		this.strikeCount += INCREASE_COUNT;
	}

	@Override
	public int count() {
		return strikeCount;
	}

	@Override
	public boolean isThreeStrikeOut() {
		return strikeCount == OUT_COUNT;
	}

	@Override
	public void resetCount() {
		strikeCount = DEFAULT_COUNT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StrikeCount that = (StrikeCount)o;
		return strikeCount == that.strikeCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strikeCount);
	}

	@Override
	public String toString() {
		return "StrikeCount{" +
			"strikeCount=" + strikeCount +
			'}';
	}
}
