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

	public boolean inserirCliente(String nome, long CPF, String endereco, int telefone, String email, String descricao, String observacao) throws ElementoJaExisteException {
		Cliente cliente = new Cliente(nome, CPF, endereco, telefone, email, descricao, observacao);
		Cliente temporario = cliente;
		temporario = this.repositorioClientes.getObj(temporario);
		if(temporario == null) return this.repositorioClientes.inserir(cliente);
		else throw new ElementoJaExisteException(cliente);
	}

	public List<Cliente> listarClientes() {
		return repositorioClientes.listar();
	}

	public boolean removerCliente(Cliente cliente) throws ElementoNaoExisteException {
		Cliente temporario = cliente;
		temporario = this.repositorioClientes.getObj(temporario);
		if(temporario != null) return this.repositorioClientes.remover(cliente);
		else throw new ElementoNaoExisteException(cliente);
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
