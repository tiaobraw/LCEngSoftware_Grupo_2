package sistema;

import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class PedidosController {

	private RepositorioGenerico<Pedido> repositorioPedidos;
	
	public PedidosController() {
		this.repositorioPedidos = new RepositorioGenerico<Pedido>();
	}
	
	public void inserirPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.inserir(newObj);
		} catch (ElementoJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Pedido> listarPedidos(){
		return repositorioPedidos.listar();
	}
	
	public void removerPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.remover(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizarPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.atualizar(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
