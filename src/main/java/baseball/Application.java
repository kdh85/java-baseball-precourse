package baseball;

import baseball.model.Game;
import baseball.validation.BaseballMainValidation;
import baseball.view.ResultView;

public class Application {

	public static void main(String[] args) {

		Game baseball;

		do {
			baseball = new Game();
			continuePlaying(baseball);

		} while (baseball.isContinueGame(BaseballMainValidation.inputRestartNumber()));
	}

	private static void continuePlaying(Game baseball) {
		while (!baseball.isGameEnd()) {
			ResultView.printPitchResult(baseball.play(BaseballMainValidation.inputNumber()));
		}
	}
}
