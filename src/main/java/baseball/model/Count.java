package baseball.model;

public interface Count {

	void increaseCount();

	void resetCount();

	boolean isThreeStrikeOut();

	int count();
}