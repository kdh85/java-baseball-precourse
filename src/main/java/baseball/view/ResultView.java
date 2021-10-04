package baseball.view;

import baseball.model.ball.BallType;
import baseball.model.game.dto.GameResultDto;

public class ResultView {

	private static final String MSG_STRIKE = "스트라이크 ";
	private static final String MSG_BALL = "볼 ";
	private static final String MSG_NOTHING = "낫싱 ";

	public static void printPitchResult(GameResultDto gameResultDto) {
		StringBuilder message = new StringBuilder();

		for (BallType ballType : gameResultDto.getGameResultDtoBallType()) {
			addStrikeMessage(gameResultDto, message, ballType);
			addBallMessage(gameResultDto, message, ballType);
			addNothingMessage(gameResultDto, message, ballType);
		}

		System.out.println(message);
	}

	private static void addNothingMessage(GameResultDto gameResultDto, StringBuilder message, BallType ballType) {
		if (ballType.isNothing()) {
			message.append(gameResultDto.getGameResultDtoNothingCount()).append(MSG_NOTHING);
		}
	}

	private static void addBallMessage(GameResultDto gameResultDto, StringBuilder message, BallType ballType) {
		if (ballType.isBall()) {
			message.append(gameResultDto.getGameResultDtoBallCount()).append(MSG_BALL);
		}
	}

	private static void addStrikeMessage(GameResultDto gameResultDto, StringBuilder message, BallType ballType) {
		if (ballType.isStrike()) {
			message.append(gameResultDto.getGameResultDtoStrikeCount()).append(MSG_STRIKE);
		}
	}
}