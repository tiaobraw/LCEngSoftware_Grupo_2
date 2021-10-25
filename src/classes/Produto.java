package classes;

public class Produto {
	private int IdProduto;
	private String Tag;
	private String Descricao;
	private String Observacao;
	private double preco;
	
	public Produto (int id, String tag, String descricao, String observacao, double preco) {
		this.IdProduto = id;
		this.Tag = tag;
		this.Descricao = descricao;
		this.Observacao = observacao;
		this.preco = preco;
	}

	public int getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
