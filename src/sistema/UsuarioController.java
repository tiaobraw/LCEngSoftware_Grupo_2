package sistema;

import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
import exceptions.SenhasNaoConferemException;
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
		else if(numero <= 0) throw new StringVaziaException("o nï¿½mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		return false;
	}
	
	
	public boolean Alterar(String nome, String email, long CPF, long numero, String senhaNova, String confirmaSenhaNova, String senhaInformada) throws StringVaziaException, ElementoNaoExisteException, SenhasNaoConferemException, SenhaIncorretaException, SenhaPequenaException {
		Usuario usuario = new Usuario();
		if(nome.length() == 0) nome = this.getUsuario().getNome();
		if(email.length() == 0) email = this.getUsuario().getEmail();
		if(numero == 0) numero = this.getUsuario().getNumero();
		if(CPF == 0) CPF  = this.getUsuario().getCPF();
		if(senhaNova.length() == 0 && confirmaSenhaNova.length() == 0) senhaNova = confirmaSenhaNova = this.getUsuario().getSenha();
		
		if(this.getUsuario() != null && 
				nome.length() != 0 && 
				email.length() != 0 && 
				CPF != 0 && numero != 0 && 
				senhaNova.length() >= 8 &&
				confirmaSenhaNova.length() >= 8 &&
				senhaInformada.length() != 0 &&
				senhaNova.equals(confirmaSenhaNova) &&
				senhaInformada.equals(this.getUsuario().getSenha())) {
			
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setCPF(CPF);
			usuario.setNumero(numero);
			usuario.setSenha(senhaNova);
			return this.repositorioUsuario.atualizar(usuario);
		}
		else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		
		else if(numero <= 0) throw new StringVaziaException("o nï¿½mero");
		
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		
		else if(this.getUsuario() == null) throw new ElementoNaoExisteException(usuario);
		
		else if(!senhaNova.equals(confirmaSenhaNova)) throw new SenhasNaoConferemException();
		
		else if(!senhaInformada.equals(this.getUsuario().getSenha())) throw new SenhaIncorretaException();
		
		else if(senhaNova.length() < 8) throw new SenhaPequenaException();
		
		
	
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
	
	public Usuario getUsuario() {
		Usuario usuario = new Usuario("Nome aleatorio", "Senha aleatoria", "samknjdv", 283,8734783); //como só há um usuario, nao precisa passar parametro, ja pega direto do banco de dados
		return usuario;
		//return this.repositorioUsuario.getObj(usuario);
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
