package baseball;

import baseball.model.Balls;
import baseball.model.GameResult;
import baseball.util.NumberGenerator;
import baseball.view.ResultView;
import baseball.view.RunningView;

public class Application {

	private static final int RESTART_MODE = 1;
	private static final int LIMIT_INSERT_NUMBER_SIZE = 3;
	private static final String NUMBER_PATTERN = "^[0-9]*$";

	public static void main(String[] args) {
		do {
			gameRunning();
		}
		while(isGameRestart(RunningView.restartGame()));
	}

	private static boolean isGameRestart(String restartGame) {
		return RESTART_MODE == Integer.parseInt(restartGame);
	}

	private static void gameRunning() {
		Balls computerBalls = new Balls(NumberGenerator.autoNumberGenerator());

		play(computerBalls);
	}

	private static void play(Balls computerBalls) {
		GameResult gameResult = new GameResult();
		while (!gameResult.isGameEnd()) {
			gameResult = new GameResult();
			String numbers = RunningView.insertNumber();
			tryPlayAgain(computerBalls, numbers);

			Balls userBalls = new Balls(NumberGenerator.manualNumberGenerator(numbers));

			gameResult.calculateScore(computerBalls.matchThreeBalls(userBalls));

			ResultView.printPitchResult(gameResult.pitchResult());
		}
	}

	private static void tryPlayAgain(Balls computerBalls, String numbers) {
		if(isWrongValue(numbers)){
			RunningView.printWrongValue();
			play(computerBalls);
		}
	}

	private static boolean isWrongValue(String numbers) {
		return numbers.length() != LIMIT_INSERT_NUMBER_SIZE || !numbers.matches(NUMBER_PATTERN);
	}
}
