package sistema;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.StringVaziaException;

public class UsuarioController {
	
	private RepositorioGenerico<Usuario> repositorioUsuario;
	
	public UsuarioController(){
		repositorioUsuario = new RepositorioGenerico<Usuario>();
	}
	
	public boolean CadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException {
			
			if(nome.length() != 0 && senha.length() != 0 && email.length() != 0 && numero > 0 && CPF > 0) {
				Usuario usuario = new Usuario(nome, senha, email, numero, CPF);
				try {
					repositorioUsuario.inserir(usuario);
				//adicionar usuario no repositorio
				return true; //vai
				} catch (ElementoJaExisteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
			else if(senha.length() <= 0) throw new StringVaziaException("a senha");
			else if(email.length() <= 0) throw new StringVaziaException("o email");
			else if(numero <= 0) throw new StringVaziaException("o número");
			else if(CPF <= 0) throw new StringVaziaException("o CPF");
			return false;
	}
	
	

}
