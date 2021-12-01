package sistema;

import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class CadastrosController {

	private RepositorioGenerico<Produto> repositorioProdutos;
	private RepositorioGenerico<Cliente> repositorioClientes;

	public CadastrosController() {
		this.repositorioProdutos = new RepositorioGenerico<Produto>();
		this.repositorioClientes = new RepositorioGenerico<Cliente>();
	}

	public void inserirProduto(Produto newObj) {
		try {
			this.repositorioProdutos.inserir(newObj);
		} catch (ElementoJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Produto> listarProduto() {
		return repositorioProdutos.listar();
	}

	public void removerProduto(Produto newObj) {
		try {
			this.repositorioProdutos.remover(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarProduto(Produto newObj) {
		try {
			this.repositorioProdutos.atualizar(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirCliente(Cliente newObj) {
		try {
			this.repositorioClientes.inserir(newObj);
		} catch (ElementoJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Cliente> listarClientes() {
		return repositorioClientes.listar();
	}

	public void removerCliente(Cliente newObj) {
		try {
			this.repositorioClientes.remover(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarCliente(Cliente newObj) {
		try {
			this.repositorioClientes.atualizar(newObj);
		} catch (ElementoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
