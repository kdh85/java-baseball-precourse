package baseball;

import static baseball.validation.BaseballMainValidation.*;
import static baseball.view.RunningView.*;

import baseball.controller.BaseballController;
import baseball.model.game.Game;
import baseball.validation.BallNumberValidationStrategy;
import baseball.validation.RestartNumberValidationStrategy;
import baseball.validation.ValidationStrategy;
import baseball.view.ResultView;

public class Application {

	public static void main(String[] args) {

		Game baseballGame;
		ValidationStrategy ballNumberValidationStrategy = new BallNumberValidationStrategy();
		ValidationStrategy restartNumberValidationStrategy = new RestartNumberValidationStrategy();

		do {
			baseballGame = new Game();
			continuePlaying(baseballGame, ballNumberValidationStrategy);

		} while (baseballGame.isContinueGame(
			validationNumber(insertNumber(restartNumberValidationStrategy.messageComment()),
				restartNumberValidationStrategy)));
	}

	private static void continuePlaying(Game baseballGame,
		ValidationStrategy ballNumberValidationStrategy) {

		BaseballController baseballController = new BaseballController();
		while (!baseballGame.isGameEnd()) {
			ResultView.printPitchResult(baseballController.play(
				validationNumber(insertNumber(ballNumberValidationStrategy.messageComment()),
					ballNumberValidationStrategy),
				baseballGame));
		}
	}
}
