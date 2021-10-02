package baseball.validation;

public class BallNumberValidationStrategy implements ValidationStrategy {

	private static final int LIMIT_INSERT_NUMBER_SIZE = 3;
	private static final String NUMBER_PATTERN = "^[1-9]*$";
	public static final String MSG_INSERT_NUMBER = "숫자를 입력해주세요 : ";

	@Override
	public boolean isWrongValue(final String number) {
		return number.length() != LIMIT_INSERT_NUMBER_SIZE || !number.matches(NUMBER_PATTERN);
	}

	@Override
	public String messageComment() {
		return MSG_INSERT_NUMBER;
	}
}
