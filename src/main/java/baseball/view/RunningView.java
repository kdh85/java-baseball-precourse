package baseball.view;

import nextstep.utils.Console;

public class RunningView {

	private static final String MSG_ERROR_WRONG_VALUE = "[ERROR] 정상적인 범위의 숫자를 입력해 주세요.";

	public static String insertNumber(String message) {
		System.out.print(message);
		return Console.readLine();
	}

	public static void printWrongValue() {
		System.err.println(MSG_ERROR_WRONG_VALUE);
		System.out.println();
	}
}
