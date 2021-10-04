package baseball.service;

import baseball.model.game.Game;
import baseball.model.game.dto.GameResultDto;

public class BallCreateService {

	public GameResultDto playResult(String numbers, Game game) {
		game.clearGameResult();
		game.play(numbers);
		return game.playResult();
	}
}
