package baseball.model.ball;

import java.util.List;

public enum BallType {
	STRIKE, BALL, NOTHING;

	public boolean isStrike() {
		return this.equals(STRIKE);
	}

	public boolean isBall() {
		return this.equals(BALL);
	}

	public boolean isNothing() {
		return this.equals(NOTHING);
	}

	public static BallType ballDistinction(final Ball computerBall, final Ball userBall) {

		if (computerBall.isSameBall(userBall)) {
			return STRIKE;
		}

		if (computerBall.isSameNumber(userBall)) {
			return BALL;
		}

		return NOTHING;
	}

	public static BallType ballsDistinction(final List<Ball> computerBalls, final Ball userBall){

		BallType type = NOTHING;

		for (Ball computerBall : computerBalls) {
			type = getStrikeOrBall(userBall, type, computerBall);
		}

		return type;
	}

	private static BallType getStrikeOrBall(Ball userBall, BallType type, Ball computerBall) {
		BallType ballType = ballDistinction(computerBall, userBall);
		if(!ballType.isNothing()){
			type = ballType;
		}
		return type;
	}
}
