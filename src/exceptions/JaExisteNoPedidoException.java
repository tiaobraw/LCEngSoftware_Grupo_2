package exceptions;

public class JaExisteNoPedidoException extends Exception{
	public JaExisteNoPedidoException() {
		super("Produto j� foi adicionado ao pedido");
	}
}
