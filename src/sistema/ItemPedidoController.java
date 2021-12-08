package sistema;

import java.util.ArrayList;
import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class ItemPedidoController {
	
	private RepositorioGenerico<Produto> repositorioProdutos;

	public ItemPedidoController() {
		this.repositorioProdutos = new RepositorioGenerico<Produto>();
	}
	
	public boolean adicionar(Produto produto) throws ElementoNaoExisteException, ElementoJaExisteException { //Adiciona produto a pedido
		if(produto.getPedido() != null) {
			return this.repositorioProdutos.inserir(produto);
		}else {
			throw new ElementoNaoExisteException(produto);
		}
	}
	
	public boolean remover(Produto produto) throws ElementoNaoExisteException { //remove um produto de um carrinho
		if(produto != null && produto.getPedido() != null) {
			return this.remover(produto);
		}else {
			throw new ElementoNaoExisteException(produto);
		}
	}
	
	public ArrayList<Produto> listarMesmoProduto(Produto produto) { //lista todos os produtos iguais (que estao em pedidos diferentes)
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < this.listarTodos().size(); i++) {
			if(this.listarTodos().get(i).getIdProduto() == produto.getIdProduto()) {
				produtos.add(this.listarTodos().get(i));
			}
		}
		return produtos;
	}
	
	public void removerMesmoProduto(Produto produto) throws ElementoNaoExisteException { //remove todos os produtos iguais (que estao em pedidos diferentes)
		ArrayList<Produto> produtos = this.listarMesmoProduto(produto);
		for(int i = 0; i < produtos.size(); i++) {
			this.repositorioProdutos.remover(produtos.get(i));
		}
	}
	
	public boolean removerPedido(Pedido pedido) throws ElementoNaoExisteException { //remove todos os produtos de um pedido
		for(int i = 0; i< this.listarMesmoPedido(pedido).size(); i++) {
			if(this.listarMesmoPedido(pedido).get(i).getPedido().equals(pedido))
			{
				return this.remover(this.listarMesmoPedido(pedido).get(i));
			}
		}
		return false;
	}
	
	public boolean atualizar(Produto produto) throws ElementoNaoExisteException { //atualiza a quantidade em um pedido
		if(produto != null && produto.getPedido() != null)
		{
			return this.atualizar(produto); //só pode mudar a quantidade
		}else {
			throw new ElementoNaoExisteException(produto);
		}
	}
	
	private List<Produto> listarTodos() { //lista todos os produtos que estao em qualquer carrinho
		return this.repositorioProdutos.listar();
	}
	
	public List<Produto> listarMesmoPedido(Pedido pedido) { //lista todos os produtos em um mesmo carrinho
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < this.listarTodos().size(); i++) {
			if(this.listarTodos().get(i).getPedido().equals(pedido))
			{
				produtos.add(this.listarTodos().get(i));
			}
		}
		return produtos;
	}
	
	public Produto getProduto(Produto produto) { //pega um produto 
		for(int i = 0; i < this.listarMesmoPedido(produto.getPedido()).size(); i++) {
			if(produto.equals(this.listarMesmoPedido(produto.getPedido()).get(i))) return this.listarMesmoPedido(produto.getPedido()).get(i);
		}
		return null;
	}

}
