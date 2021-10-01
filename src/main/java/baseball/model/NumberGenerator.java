package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int START_NUMBER_SIZE = 0;
	private static final int END_NUMBER_SIZE = 2;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int LIMIT_NUMBER_SIZE = 3;
	private static final String SPLIT_CONDITION = "";
	private static final String MSG_ERROR_NOT_ENOUGH_NUMBER = "입력값이 충분치 않습니다. 중복없는 3개의 수를입력해주세요.";

	public static List<Integer> autoNumberGenerator() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = START_NUMBER_SIZE; i <= END_NUMBER_SIZE; i++) {
			addNumber(numbers, Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
		return numbers;
	}

	private static void addNumber(List<Integer> numbers, int number) {
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
	}

	public static List<Integer> manualNumberGenerator(String numberValues) {
		return new ArrayList<>(splitNumbers(numberValues));
	}

	private static Set<Integer> splitNumbers(String numberValues) {
		Set<Integer> splitNumbers = new HashSet<>();

		for (String numberValue : numberValues.split(SPLIT_CONDITION)) {
			splitNumbers.add(Integer.valueOf(numberValue));
		}

		validationManualNumbers(splitNumbers);

		return splitNumbers;
	}

	private static void validationManualNumbers(Set<Integer> numberSet) {
		if(numberSet.size() != LIMIT_NUMBER_SIZE){
			throw new IllegalArgumentException(MSG_ERROR_NOT_ENOUGH_NUMBER);
		}
	}

}
