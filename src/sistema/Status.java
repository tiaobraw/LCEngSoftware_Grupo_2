package sistema;

public enum Status {
	ABERTO("Aberto"),
	FECHADO("Fechado"),
	AGUARDANDO_APROVACAO("Aguardando aprovação"),
	REPROVADO("Reprovado"),
	APROVADO("Aprovado");
	
	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
