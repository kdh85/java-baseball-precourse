package baseball.util;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int LIMIT_NUMBER_SIZE = 3;
	private static final String SPLIT_CONDITION = "";
	private static final String MSG_ERROR_NOT_ENOUGH_NUMBER = "입력값이 충분치 않습니다. 중복없는 3개의 수를입력해주세요.";

	public static LinkedList<Integer> autoNumberGenerator() {

		LinkedList<Integer> numbers = new LinkedList<>();
		while (numbers.size() != LIMIT_NUMBER_SIZE) {
			addNumber(numbers, Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
		return numbers;
	}

	private static void addNumber(List<Integer> numbers, int number) {
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
	}

	public static LinkedList<Integer> manualNumberGenerator(String numberValues) {
		return new LinkedList<>(splitNumbers(numberValues));
	}

	private static LinkedHashSet<Integer> splitNumbers(String numberValues) {
		LinkedHashSet<Integer> splitNumbers = new LinkedHashSet<>();

		for (String numberValue : numberValues.split(SPLIT_CONDITION)) {
			splitNumbers.add(Integer.valueOf(numberValue));
		}

		validationManualNumbers(splitNumbers);

		return splitNumbers;
	}

	private static void validationManualNumbers(Set<Integer> numberSet) {
		if (numberSet.size() != LIMIT_NUMBER_SIZE) {
			throw new IllegalArgumentException(MSG_ERROR_NOT_ENOUGH_NUMBER);
		}
	}

}
