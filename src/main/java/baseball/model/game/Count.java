package baseball.model.game;

public interface Count {

	void increaseCount();

	void resetCount();

	boolean isThreeStrikeOut();

	int count();
}