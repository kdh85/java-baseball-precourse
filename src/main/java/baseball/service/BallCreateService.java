package baseball.service;

import java.util.LinkedHashMap;

import baseball.model.ball.BallType;
import baseball.model.game.Game;

public class BallCreateService {

	public LinkedHashMap<BallType, Integer> playResult(String numbers, Game game) {
		game.clearGameResult();
		game.play(numbers);
		return game.playResult();
	}
}
