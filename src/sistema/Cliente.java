package sistema;

import java.util.Objects;

public class Cliente {
	private String Nome;
	private String endereco;
	private int telefone;
	private String email;
	private String Descricao;
	private String Observacao;
	private String responsavel;
	private String emailResponsavel;
	private long CPF;
	
	public Cliente (String nome, long CPF, String endereco, int telefone, String email, String descricao, String observacao) {
		this.Nome = nome;
		this.CPF = CPF;   
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.Descricao = descricao;
		this.Observacao = observacao;
	}
	
	public Cliente () {
		
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public long getCPF() {
		return CPF;
	}

	public void setCPF(long cPF) {
		CPF = cPF;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
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
		Cliente other = (Cliente) obj;
		return CPF == other.CPF;
	}
	
	
}