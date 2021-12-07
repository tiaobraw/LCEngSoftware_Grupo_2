package exceptions;

public class SenhasNaoConferemException extends Exception{
	public SenhasNaoConferemException() {
		super("O campo 'senha' deve ser igual ao campo 'Confirme sua senha'");
	}

}
