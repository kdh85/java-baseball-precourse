package baseball;

import baseball.controller.BaseballController;
import baseball.model.Game;
import baseball.validation.BaseballMainValidation;
import baseball.view.ResultView;

public class Application {

	public static void main(String[] args) {

		Game baseballGame;

		do {
			baseballGame = new Game();
			continuePlaying(baseballGame);

		} while (baseballGame.isContinueGame(BaseballMainValidation.inputRestartNumber()));
	}

	private static void continuePlaying(Game baseballGame) {

		BaseballController baseballController = new BaseballController();
		while (!baseballGame.isGameEnd()) {
			ResultView.printPitchResult(baseballController.play(BaseballMainValidation.inputNumber(), baseballGame));
		}
	}
}
