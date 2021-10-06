package baseball.model.game;

import baseball.model.ball.Balls;
import baseball.model.game.dto.GameResultDto;
import baseball.util.NumberGenerator;

public class Game {

	private static final int RESTART_MODE = 1;

	private final Balls computerBalls;

	private final GameResult gameResult;

	public Game() {
		this(new Balls(NumberGenerator.autoNumberGenerator()), new GameResult());
	}

	public Game(Balls computerBalls, GameResult gameResult) {
		this.computerBalls = computerBalls;
		this.gameResult = gameResult;
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

	public GameResultDto playResult() {
		return gameResult.pitchResult();
	}

	public void play(String numbers) {
		gameResult.calculateScore(computerBalls.matchThreeBalls(createUserBalls(numbers)));
	}

	private Balls createUserBalls(String numbers) {
		return new Balls(NumberGenerator.manualNumberGenerator(numbers));
	}
}