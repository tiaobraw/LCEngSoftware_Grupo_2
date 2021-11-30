package sistema;

import exceptions.StringVaziaException;

public class UsuarioController {
	
	public UsuarioController(){
		
	}
	
	public boolean CadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException {
		if(nome.length() != 0 && senha.length() != 0 && email.length() != 0 && numero > 0 && CPF > 0) {
			Usuario usuario = new Usuario(nome, senha, email, numero, CPF);
			//adicionar usuario no repositorio
			return true; //vai 
		}else if(nome.length() <= 0) throw new StringVaziaException("o nome");
		else if(senha.length() <= 0) throw new StringVaziaException("a senha");
		else if(email.length() <= 0) throw new StringVaziaException("o email");
		else if(numero <= 0) throw new StringVaziaException("o n�mero");
		else if(CPF <= 0) throw new StringVaziaException("o CPF");
		return false;
	}

}