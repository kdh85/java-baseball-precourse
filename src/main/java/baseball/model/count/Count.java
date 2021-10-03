package baseball.model.count;

public interface Count {

	void increaseCount();

	void resetCount();

	boolean isThreeStrikeOut();

	int count();
}