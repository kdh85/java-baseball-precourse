package baseball.view;

import nextstep.utils.Console;

public class RunningView {

	private static final String MSG_INSERT_NUMBER = "숫자를 입력해주세요 : ";
	private static final String MSG_END_OF_GAME = "3개의숫자를모두맞히셨습니다! 게임 끝";
	private static final String MSG_ASK_RESTART = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";
	private static final String MSG_ERROR_WRONG_VALUE = "[ERROR] 정상적인 범위의 숫자를 입력해 주세요.";

	public static String insertNumber(){
		System.out.print(MSG_INSERT_NUMBER);
		return Console.readLine();
	}

	public static String restartGame(){
		System.out.println(MSG_END_OF_GAME);
		System.out.println(MSG_ASK_RESTART);
		return Console.readLine();
	}

	public static void printWrongValue() {
		System.err.println(MSG_ERROR_WRONG_VALUE);
		System.out.println();
	}
}
