package baseball.view;

import java.util.Map;

import baseball.model.ball.BallType;

public class ResultView {

	private static final String MSG_STRIKE = "스트라이크 ";
	private static final String MSG_BALL = "볼 ";
	private static final String MSG_NOTHING = "낫싱 ";

	public static void printPitchResult(Map<BallType, Integer> result) {
		StringBuilder message = new StringBuilder();

		for (BallType ballType : result.keySet()) {
			addStrikeMessage(result, message, ballType);
			addBallMessage(result, message, ballType);
			addNothingMessage(result, message, ballType);
		}

		System.out.println(message);
	}

	private static void addNothingMessage(Map<BallType, Integer> result, StringBuilder message, BallType ballType) {
		if (ballType.isNothing()) {
			message.append(result.get(ballType)).append(MSG_NOTHING);
		}
	}

	private static void addBallMessage(Map<BallType, Integer> result, StringBuilder message, BallType ballType) {
		if (ballType.isBall()) {
			message.append(result.get(ballType)).append(MSG_BALL);
		}
	}

	private static void addStrikeMessage(Map<BallType, Integer> result, StringBuilder message, BallType ballType) {
		if (ballType.isStrike()) {
			message.append(result.get(ballType)).append(MSG_STRIKE);
		}
	}
}