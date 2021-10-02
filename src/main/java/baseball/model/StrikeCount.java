package baseball.model;

import java.util.Objects;

public class StrikeCount {

	private static final int INCREASE_COUNT = 1;
	private static final int OUT_COUNT = 3;
	private static final int DEFAULT_COUNT = 0;

	private int strikeCount;

	public StrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	public void increaseCount() {
		this.strikeCount += INCREASE_COUNT;
	}

	public Integer count() {
		return strikeCount;
	}

	public boolean isThreeStrikeOut() {
		return strikeCount == OUT_COUNT;
	}

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
