package sistema;

import java.util.Objects;

public class Usuario {
	private String nome;
	private String senha;
	private String email;
	private long CPF;
	private long numero;
	
	public Usuario (String nome, String senha, String email, long numero, long CPF) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.numero = numero;
	}
	
	public Usuario () {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCPF() {
		return CPF;
	}

	public void setCPF(long cPF) {
		CPF = cPF;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CPF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return CPF == other.CPF;
	}
	
	
	
}