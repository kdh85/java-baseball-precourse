package baseball.model.game.dto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import baseball.model.ball.BallType;

public class GameResultDto {

	private final Map<BallType, Integer> gameResultDto;

	private GameResultDto(LinkedHashMap<BallType, Integer> gameResultDto) {
		this.gameResultDto = Collections.unmodifiableMap(gameResultDto);
	}

	public static GameResultDto from(final LinkedHashMap<BallType, Integer> result){
		return new GameResultDto(result);
	}

	public Set<BallType> getGameResultDtoBallType(){
		return gameResultDto.keySet();
	}

	public int getGameResultDtoStrikeCount(){
		return gameResultDto.get(BallType.STRIKE);
	}

	public int getGameResultDtoBallCount() {
		return gameResultDto.get(BallType.BALL);
	}

	public int getGameResultDtoNothingCount() {
		return gameResultDto.get(BallType.NOTHING);
	}
}