package exceptions;

public class SenhaIncorretaException extends Exception{
	public SenhaIncorretaException() {
		super("A senha informada est� incorreta!");
	}
}
