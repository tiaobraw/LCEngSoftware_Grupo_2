package sistema;

import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
import exceptions.SenhasNaoConferemException;
import exceptions.StringVaziaException;

public class Fachada {
	private static Fachada instancia;
	private PedidosController pedidos;
	private UsuarioController usuario;
	
	public Fachada()
	{
		pedidos = new PedidosController();
		usuario = new UsuarioController();
	}
	
	public static Fachada getInstance() {
		if(instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public boolean cadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException, ElementoJaExisteException {
		return this.usuario.CadastrarUsuario(nome, senha, email, numero, CPF);
	}
	
	public boolean login(long CPF, String senha) throws ElementoNaoExisteException, SenhaIncorretaException {
		return this.usuario.login(CPF, senha);
	}
	
	public Usuario getUsuario() {
		return this.usuario.getUsuario();
	}
	
	public boolean atualizarUsuario(String nome, String email, long CPF, long numero, String senhaNova, String confirmaSenhaNova, String senhaInformada) throws StringVaziaException, ElementoNaoExisteException, SenhasNaoConferemException, SenhaIncorretaException, SenhaPequenaException {
		return this.usuario.Alterar(nome, email, CPF, numero, senhaNova, confirmaSenhaNova, senhaInformada);
	}
}
