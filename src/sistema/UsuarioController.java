package sistema;

import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.StringVaziaException;

public class UsuarioController {
	
	private RepositorioGenerico<Usuario> repositorioUsuario;
	
	public UsuarioController(){
		repositorioUsuario = new RepositorioGenerico<Usuario>();
	}
	
	public boolean CadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException, ElementoJaExisteException {
		if(nome.length() != 0 && senha.length() != 0 && email.length() != 0 && numero > 0 && CPF > 0) {
			Usuario usuario = new Usuario(nome, senha, email, numero, CPF);
			return repositorioUsuario.inserir(usuario); 
		}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		else if(senha.length() <= 0) throw new StringVaziaException("a senha");
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		else if(numero <= 0) throw new StringVaziaException("o n�mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		return false;
	}
	
	public boolean AlterarSenha(String senhaInformada, String NovaSenha, long CPF) throws StringVaziaException, SenhaPequenaException, SenhaIncorretaException, ElementoNaoExisteException {
		Usuario usuario = new Usuario();
		usuario.setCPF(CPF);
		usuario = this.repositorioUsuario.getObj(usuario);
		if(senhaInformada.length()!= 0 && NovaSenha.length() >= 8 && senhaInformada == usuario.getSenha()) {
			usuario.setSenha(NovaSenha);
			return this.repositorioUsuario.atualizar(usuario);
		}else if(senhaInformada.length() <= 0) throw new StringVaziaException("a senha");
		else if(NovaSenha.length() < 8) throw new SenhaPequenaException();
		else if(senhaInformada != usuario.getSenha()) throw new SenhaIncorretaException();
		return false;
	}
	
	public boolean Alterar(String nome, String email, long CPF, long numero) throws StringVaziaException, ElementoNaoExisteException {
		Usuario usuario = new Usuario();
		usuario.setCPF(CPF);
		usuario = this.repositorioUsuario.getObj(usuario);
		if(usuario != null && nome.length() != 0 && email.length() != 0 && CPF != 0 && numero != 0) {
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setCPF(CPF);
			usuario.setNumero(numero);
			return this.repositorioUsuario.atualizar(usuario);
		}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		else if(numero <= 0) throw new StringVaziaException("o n�mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		else if(usuario == null) throw new ElementoNaoExisteException(usuario);
	
	return false;
}
	public boolean Remover(long CPF, String senha) throws ElementoNaoExisteException, StringVaziaException, SenhaIncorretaException {
		Usuario usuario = new Usuario();
		usuario.setCPF(CPF);
		usuario = this.repositorioUsuario.getObj(usuario);
		if(usuario != null && CPF != 0 && senha.length() != 0 && usuario.getSenha().equals(senha)) {
			return this.repositorioUsuario.remover(usuario);
		}else if(usuario == null) throw new ElementoNaoExisteException(usuario);
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		else if(senha.length() <= 0) throw new StringVaziaException("a senha");
		else if(!usuario.getSenha().equals(senha)) throw new SenhaIncorretaException();
		return false;
	}
	
	public Usuario getUsuario(long CPF) {
		Usuario usuario = new Usuario();
		usuario.setCPF(CPF);
		return this.repositorioUsuario.getObj(usuario);
	}
	
	public boolean login(long CPF, String senha) throws ElementoNaoExisteException, SenhaIncorretaException {
		Usuario usuario = new Usuario();
		usuario.setCPF(CPF);
		usuario = this.repositorioUsuario.getObj(usuario);
		if(usuario != null && usuario.getCPF() == CPF && usuario.getSenha().equals(senha)) {
			return true;
		}else if(usuario == null || usuario.getCPF() != CPF) throw new ElementoNaoExisteException(usuario);
		else if(usuario.getSenha().equals(senha)) throw new SenhaIncorretaException(); 
		return false;
	}
}
