package baseball.model;

import java.util.LinkedHashMap;

import baseball.util.NumberGenerator;
import baseball.view.RunningView;

public class Game {

	private static final int RESTART_MODE = 1;
	private static final int LIMIT_INSERT_NUMBER_SIZE = 1;
	private static final String NUMBER_PATTERN = "^[1-2]*$";

	private final Balls comBalls;

	private final GameResult gameResult;

	public Game() {
		this.comBalls = new Balls(NumberGenerator.autoNumberGenerator());
		this.gameResult = new GameResult();
	}

	private boolean isGameRestart(final String modeNumber){
		if(modeNumber.length() != LIMIT_INSERT_NUMBER_SIZE || !modeNumber.matches(NUMBER_PATTERN)){
			RunningView.printWrongValue();
			return true;
		}
		return RESTART_MODE == Integer.parseInt(modeNumber);
	}

	public boolean restartGame(final String modeNumber){
		if(isGameRestart(modeNumber)){
			clearGameResult();
			return true;
		}
		return false;
	}

	private void clearGameResult() {
		gameResult.clearBallCount();
	}

	public boolean isGameEnd(){
		return gameResult.isGameEnd();
	}

	public LinkedHashMap<BallType, Integer> play(final String numbers){
		clearGameResult();
		Balls userBalls = new Balls(NumberGenerator.manualNumberGenerator(numbers));
		gameResult.calculateScore(comBalls.matchThreeBalls(userBalls));
		return gameResult.pitchResult();
	}
}