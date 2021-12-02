package exceptions;

public class JaExisteNoPedidoException extends Exception{
	public JaExisteNoPedidoException() {
		super("Produto já foi adicionado ao pedido");
	}
}
