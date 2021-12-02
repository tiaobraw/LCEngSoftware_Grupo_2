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
		
	public boolean inserir(int id, Calendar data, String versao, Status Status, double comissao, String descricao, Cliente cliente) throws ElementoJaExisteException {
		Pedido pedido = new Pedido(id, data, versao, Status, comissao, descricao, cliente);
		Pedido temporario = pedido;
		temporario = this.repositorioPedidos.getObj(temporario);
		if(temporario == null) return this.repositorioPedidos.inserir(pedido);
		else throw new ElementoJaExisteException(pedido);
		
			
	}
	
	public List<Pedido> listar(){
		return repositorioPedidos.listar();
	}
	
	public boolean remover(Pedido pedido) throws ElementoJaExisteException, ElementoNaoExisteException {
		Pedido temporario = pedido;
		temporario = this.repositorioPedidos.getObj(temporario);
		if(temporario != null) return this.repositorioPedidos.inserir(pedido);
		else throw new ElementoNaoExisteException(pedido);
	}
	
	public boolean atualizar(Pedido newPedido, Pedido oldPedido) throws ElementoNaoExisteException {
		oldPedido = this.repositorioPedidos.getObj(oldPedido);
		if(oldPedido != null) return this.repositorioPedidos.atualizar(newPedido);
		else throw new ElementoNaoExisteException(oldPedido);
	}
	
	public Pedido getPedido(Pedido pedido) {
		return this.repositorioPedidos.getObj(pedido);
	}
}
