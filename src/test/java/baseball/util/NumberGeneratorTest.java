package baseball.util;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.NumberGenerator;

class NumberGeneratorTest {

	@DisplayName("랜덤으로 생성한 중복없는 숫자 3개를 반환한다.")
	@Test
	void autoNumberCreateTest() {
		List<Integer> autoValues = NumberGenerator.autoNumberGenerator();
		assertThat(autoValues.size()).isEqualTo(3);
	}

	@DisplayName("직접입려한 3자리수를 각각 나눠서 숫자 3개를 반환한다.")
	@Test
	void manualNumberCreateTest() {
		List<Integer> manualValues = NumberGenerator.manualNumberGenerator("123");
		assertThat(manualValues.size()).isEqualTo(3);
	}

	@DisplayName("직접입력시 중복되는 번호가 들어가면 에러가 발생한다.")
	@Test
	void duplicateTest() {
		assertThatThrownBy(
			() -> NumberGenerator.manualNumberGenerator("113")
		).isInstanceOf(IllegalArgumentException.class);
	}
}