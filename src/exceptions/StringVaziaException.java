package exceptions;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;

public class StringVaziaException extends Exception {
	private String vazia;
	
	public StringVaziaException(String vazia) {
		super("Informe " + vazia + "!");
		this.vazia = vazia;
		
	}

	public String getVazia() {
		return vazia;
	}

	public void setVazia(String vazia) {
		this.vazia = vazia;
	}
	
	

}
