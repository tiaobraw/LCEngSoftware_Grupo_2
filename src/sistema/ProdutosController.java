package sistema;

import java.util.ArrayList;
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

	public boolean inserir(Produto produto) throws ElementoJaExisteException, JaExisteNoPedidoException, ElementoNaoExisteException {
		if(produto != null && produto.getPedido() == null && !existe(produto)) {
			return this.repositorioProdutos.inserir(produto);
		}else if(existe(produto)) {
			throw new ElementoJaExisteException(produto);
		}
		return false;
		
	}
	
	public boolean atualizar(Produto produto) throws ElementoNaoExisteException {
		if(produto != null && produto.getPedido() == null && this.existe(produto)) {
			return this.repositorioProdutos.atualizar(produto);
		}else if(!this.existe(produto)) {
			throw new ElementoNaoExisteException(produto);
		}
		return false;
	}
	
	public boolean remover(Produto produto) throws ElementoNaoExisteException {
		if(produto != null && produto.getPedido() == null && this.existe(produto)) {
			return this.repositorioProdutos.remover(produto);
		}else if(!this.existe(produto)) {
			throw new ElementoNaoExisteException(produto);
		}
		return false;
	}

	public List<Produto> listarProduto() {
		return repositorioProdutos.listar();
	}
	
	private boolean existe(Produto produto) {
		for(int i = 0; i < this.listarProduto().size(); i++) {
			if(this.listarProduto().get(i).equals(produto)) {
				return true;
			}
		}
		return false;
	}

}
