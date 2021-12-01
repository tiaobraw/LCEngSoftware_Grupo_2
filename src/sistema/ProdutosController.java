package sistema;

import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class ProdutosController {

	private RepositorioGenerico<Produto> repositorioProdutos;

	public ProdutosController() {
		this.repositorioProdutos = new RepositorioGenerico<Produto>();
	}

	public boolean inserirProduto(Produto newObj) {
		try {
			this.repositorioProdutos.inserir(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoJaExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Produto> listarProduto() {
		return repositorioProdutos.listar();
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
