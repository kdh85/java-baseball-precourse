package baseball.controller;

import java.util.LinkedHashMap;

import baseball.model.ball.BallType;
import baseball.model.game.Game;
import baseball.service.BallCreateService;

public class BaseballController {

	private final BallCreateService ballCreateService;

	public BaseballController() {
		this.ballCreateService = new BallCreateService();
	}

	public LinkedHashMap<BallType, Integer> play(final String numbers, final Game game) {
		return ballCreateService.playResult(numbers, game);
	}
}
