package baseball.validation;

import baseball.view.RunningView;

public class BaseballMainValidation {

	public static String inputRestartNumber() {
		RestartNumberValidationStrategy restartNumberCondition = new RestartNumberValidationStrategy();
		return validationNumber(RunningView.insertNumber(restartNumberCondition.messageComment()),
			restartNumberCondition);
	}

	private static String validationNumber(String number, ValidationStrategy validationCondition) {
		while (validationCondition.isWrongValue(number)) {
			RunningView.printWrongValue();
			number = RunningView.insertNumber(validationCondition.messageComment());
		}
		return number;
	}

	public static String inputNumber() {
		BallNumberValidationStrategy ballNumberCondition = new BallNumberValidationStrategy();
		return validationNumber(RunningView.insertNumber(ballNumberCondition.messageComment()), ballNumberCondition);
	}

}