package baseball.model.game;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.game.Game;

class GameTest {

	@DisplayName("입력값 1,2를 받아서 재시작 여부를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|true", "2|false"}, delimiter = '|')
	void isContinueGameTest(String mode, boolean isRestart) {
		Game game = new Game();
		assertThat(game.isContinueGame(mode)).isEqualTo(isRestart);
	}

	@DisplayName("경기 종료 여부를 반환한다..")
	@Test
	void clearGameTest() {
		Game game = new Game();
		assertThat(game.isGameEnd()).isEqualTo(false);
	}
}