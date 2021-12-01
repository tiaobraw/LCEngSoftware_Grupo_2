package exceptions;

public class SenhaPequenaException extends Exception {
	public SenhaPequenaException() {
		super("A senha informada deve ter mais que 8 caracteres!");
	}

}
