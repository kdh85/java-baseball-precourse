package baseball.model.game;

import java.util.LinkedHashMap;

import baseball.model.ball.BallType;
import baseball.model.ball.Balls;
import baseball.util.NumberGenerator;

public class Game {

	private static final int RESTART_MODE = 1;

	private final Balls computerBalls;

	private final GameResult gameResult;

	public Game() {
		this.computerBalls = new Balls(NumberGenerator.autoNumberGenerator());
		this.gameResult = new GameResult();
	}

	private boolean isGameRestart(final String modeNumber) {
		return RESTART_MODE == toInt(modeNumber);
	}

	private int toInt(String modeNumber) {
		return Integer.parseInt(modeNumber);
	}

	public boolean isContinueGame(final String modeNumber) {
		if (isGameRestart(modeNumber)) {
			clearGameResult();
			return true;
		}
		return false;
	}

	public void clearGameResult() {
		gameResult.clearBallCount();
	}

	public boolean isGameEnd() {
		return gameResult.isGameEnd();
	}

	public LinkedHashMap<BallType, Integer> playResult() {
		return gameResult.pitchResult();
	}

	public void play(String numbers) {
		gameResult.calculateScore(computerBalls.matchThreeBalls(createUserBalls(numbers)));
	}

	private Balls createUserBalls(String numbers) {
		return new Balls(NumberGenerator.manualNumberGenerator(numbers));
	}
}