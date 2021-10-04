package baseball.validation;

import baseball.view.RunningView;

public class BaseballMainValidation {

	public static String validationNumber(String number, ValidationStrategy validationCondition) {
		while (validationCondition.isWrongValue(number)) {
			RunningView.printWrongValue();
			number = RunningView.insertNumber(validationCondition.messageComment());
		}
		return number;
	}
}