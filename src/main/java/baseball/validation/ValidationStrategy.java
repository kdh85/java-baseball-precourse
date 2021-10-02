package baseball.validation;

public interface ValidationStrategy {

	boolean isWrongValue(String number);

	String messageComment();
}