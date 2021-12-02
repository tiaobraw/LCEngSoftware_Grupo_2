package sistema;

import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class ClientesController {

	private RepositorioGenerico<Cliente> repositorioClientes;

	public ClientesController() {
		this.repositorioClientes = new RepositorioGenerico<Cliente>();
	}

	public boolean inserirCliente(Cliente newObj) {
		try {
			this.repositorioClientes.inserir(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoJaExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Cliente> listarClientes() {
		return repositorioClientes.listar();
	}

	public boolean removerCliente(Cliente newObj) {
		try {
			this.repositorioClientes.remover(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean atualizarCliente(Cliente newObj) {
		try {
			this.repositorioClientes.atualizar(newObj);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		} catch (ElementoNaoExisteException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
