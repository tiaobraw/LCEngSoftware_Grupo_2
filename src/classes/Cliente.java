package classes;

public class Cliente {
	private String Nome;
	private String endereco;
	private int telefone;
	private String email;
	private String Descricao;
	private String Observacao;
	private int CPF;
	private int IdCliente;
	
	public Cliente (int id, String nome, int CPF, String endereco, int telefone, String email, String descricao, String observacao) {
		this.IdCliente = id;
		this.Nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.Descricao = descricao;
		this.Observacao = observacao;
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

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

}
