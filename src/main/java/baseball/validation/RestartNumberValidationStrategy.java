package baseball.validation;

public class RestartNumberValidationStrategy implements ValidationStrategy {

	private static final int LIMIT_RESTART_NUMBER_SIZE = 1;
	private static final String RESTART_NUMBER_PATTERN = "^[1-2]*$";
	private static final String MSG_END_OF_GAME =
		"3개의숫자를모두맞히셨습니다! 게임 끝" + System.lineSeparator() + "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요." + System.lineSeparator();

	@Override
	public boolean isWrongValue(String number) {
		return number.length() != LIMIT_RESTART_NUMBER_SIZE || !number.matches(RESTART_NUMBER_PATTERN);
	}

	@Override
	public String messageComment() {
		return MSG_END_OF_GAME;
	}
}
