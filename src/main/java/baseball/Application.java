package baseball;

import static baseball.validation.BallNumberValidationStrategy.*;
import static baseball.validation.BaseballMainValidation.*;
import static baseball.validation.RestartNumberValidationStrategy.*;
import static baseball.view.RunningView.*;

import baseball.controller.BaseballController;
import baseball.model.game.Game;
import baseball.validation.BallNumberValidationStrategy;
import baseball.validation.RestartNumberValidationStrategy;
import baseball.view.ResultView;

public class Application {

	public static void main(String[] args) {

		Game baseballGame;

		do {
			baseballGame = new Game();
			continuePlaying(baseballGame);

		} while (baseballGame.isContinueGame(
			validationNumber(insertNumber(MSG_END_OF_GAME), new RestartNumberValidationStrategy())));
	}

	private static void continuePlaying(Game baseballGame) {

		BaseballController baseballController = new BaseballController();
		while (!baseballGame.isGameEnd()) {
			ResultView.printPitchResult(baseballController.play(
				validationNumber(insertNumber(MSG_INSERT_NUMBER), new BallNumberValidationStrategy()),
				baseballGame));
		}
	}
}
