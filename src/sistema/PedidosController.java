package sistema;

import java.util.Calendar;
import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class PedidosController {

	private RepositorioGenerico<Pedido> repositorioPedidos;
	
	public PedidosController() {
		this.repositorioPedidos = new RepositorioGenerico<Pedido>();
	}
	
<<<<<<< HEAD
	public void inserir()
	{
		
=======
	public boolean inserirPedido(Pedido newObj) {
		try {
			this.repositorioPedidos.inserir(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoJaExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
>>>>>>> 0281e8511afa5ec8a497ea079c679033ad0a21e4
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
