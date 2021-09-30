package study;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set 콜랙션의 사이즈값을 확인한다.")
	@Test
	void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|true","2|true","3|true","4|false","5|false"}, delimiter = '|')
	void contains(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}
}
