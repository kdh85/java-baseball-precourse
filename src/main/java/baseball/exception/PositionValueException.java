package baseball.exception;

public class PositionValueException extends IllegalArgumentException{
	public PositionValueException(final String message){
		super(message);
	}
}
