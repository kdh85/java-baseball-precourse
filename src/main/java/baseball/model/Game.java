package baseball.model;

import java.util.LinkedHashMap;

import baseball.util.NumberGenerator;

public class Game {

	private static final int RESTART_MODE = 1;

	private final Balls comBalls;

	private final GameResult gameResult;

	public Game() {
		this.comBalls = new Balls(NumberGenerator.autoNumberGenerator());
		this.gameResult = new GameResult();
	}

	private boolean isGameRestart(final String modeNumber){
		return RESTART_MODE == toInt(modeNumber);
	}

	private int toInt(String modeNumber) {
		return Integer.parseInt(modeNumber);
	}

	public boolean isContinueGame(final String modeNumber){
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