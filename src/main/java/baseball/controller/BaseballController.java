package baseball.controller;

import baseball.model.game.Game;
import baseball.model.game.dto.GameResultDto;
import baseball.service.BallCreateService;

public class BaseballController {

	private final BallCreateService ballCreateService;

	public BaseballController() {
		this.ballCreateService = new BallCreateService();
	}

	public GameResultDto play(final String numbers, final Game game) {
		return ballCreateService.playResult(numbers, game);
	}
}
