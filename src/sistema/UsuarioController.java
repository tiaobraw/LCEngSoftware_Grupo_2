package sistema;

<<<<<<< HEAD
import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
=======
import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
>>>>>>> 627367c34b7492f73e54e44b9b66151981882c04
import exceptions.StringVaziaException;

public class UsuarioController {
	
	private RepositorioGenerico<Usuario> repositorioUsuario;
	
	public UsuarioController(){
		repositorioUsuario = new RepositorioGenerico<Usuario>();
	}
	
	public boolean CadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException {
<<<<<<< HEAD
		if(nome.length() != 0 && senha.length() != 0 && email.length() != 0 && numero > 0 && CPF > 0) {
			Usuario usuario = new Usuario(nome, senha, email, numero, CPF);
			Boolean ok = true;//adicionar usuario no repositorio
			return ok; 
		}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		else if(senha.length() <= 0) throw new StringVaziaException("a senha");
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		else if(numero <= 0) throw new StringVaziaException("o n�mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		return false;
	}
	
	public boolean AlterarSenha(String senhaInformada, String NovaSenha) throws StringVaziaException, SenhaPequenaException, SenhaIncorretaException {
		String senhaAtual = "";//repositorio tem que ter metodo que retorna a senha atual
		if(senhaInformada.length() != 0 && NovaSenha.length() >= 8 && senhaInformada == senhaAtual) {
			Boolean ok = true;//metodo no repositorio pra alterar a senha que retorna true se for alterada e false se n
			
			return ok;
		}else if(senhaInformada.length() <= 0) throw new StringVaziaException("a senha");
		else if(NovaSenha.length() < 8) throw new SenhaPequenaException();
		else if(senhaInformada != senhaAtual) throw new SenhaIncorretaException();
		return false;
	}
	
	public boolean AlterarInformacoes(String nome, String email, long CPF, long numero) throws StringVaziaException {
		if(nome.length() != 0 && email.length() != 0 && CPF != 0 && numero != 0) {
			String senha = ""; //pega senha atual do repositorio
			Usuario usuario = new Usuario(nome,senha, email, CPF, numero);
			boolean ok = true; //aqui vai chamar o repositorio e fazer o update
			return ok;
		}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		else if(numero <= 0) throw new StringVaziaException("o n�mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
	
	return false;
=======
			
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
			else if(numero <= 0) throw new StringVaziaException("o n�mero");
			else if(CPF <= 0) throw new StringVaziaException("o CPF");
			return false;
	}
	
	

>>>>>>> 627367c34b7492f73e54e44b9b66151981882c04
}
}