package sistema;

import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.JaExisteNoPedidoException;

public class ProdutosController {

	private RepositorioGenerico<Produto> repositorioProdutos;

	public ProdutosController() {
		this.repositorioProdutos = new RepositorioGenerico<Produto>();
	}

	public boolean inserirProduto(Produto produto) throws ElementoJaExisteException, JaExisteNoPedidoException {
		Produto temporario = produto;
		temporario = this.repositorioProdutos.getObj(temporario);
		if(temporario == null) return this.repositorioProdutos.inserir(produto);
		else if(temporario.isInsidePedido()) throw new JaExisteNoPedidoException();
		else throw new ElementoJaExisteException(produto);
	}

	public List<Produto> listarProduto() {
		return repositorioProdutos.listar();
	}
	
	public List<Produto> listarProduto(Pedido pedido) //ESSE MÉTODO É PARA LISTAR OS PRODUTOS DE UM MESMO PEDIDO, ou seja, produto que insidePedido == true && pedido(parametro) == produto.pedido
	{
		return this.repositorioProdutos.listar(pedido);
		//se for do msm pedido, faz a list
	}

	public boolean removerProduto(Produto newObj) {
		try {
			this.repositorioProdutos.remover(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean atualizarProduto(Produto newObj) {
		try {
			this.repositorioProdutos.atualizar(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
