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
	
	public boolean inserirPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.inserir(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoJaExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<Pedido> listarPedidos(){
		return repositorioPedidos.listar();
	}
	
	public boolean removerPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.remover(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean atualizarPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.atualizar(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
