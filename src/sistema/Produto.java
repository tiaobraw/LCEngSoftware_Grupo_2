package sistema;

public class Produto {
	private int IdProduto;
	private String Tag;
	private String Descricao;
	private String Observacao;
	private double preco;
	private String nome;
	private boolean insidePedido;
	private Pedido pedido;
	
	public Produto (int id, String tag, String descricao, String observacao, double preco, String nome, boolean insidePedido, Pedido pedido) {
		this.IdProduto = id;
		this.Tag = tag;
		this.Descricao = descricao;
		this.Observacao = observacao;
		this.preco = preco;
		this.nome = nome;
		this.insidePedido = insidePedido;
		this.pedido = pedido;
	}
	
	public Produto ()
	{
		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isInsidePedido() {
		return insidePedido;
	}

	public void setInsidePedido(boolean insidePedido) {
		this.insidePedido = insidePedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public boolean equals(Produto produto) {
		if(insidePedido && produto.insidePedido) {
			if(this.IdProduto == produto.IdProduto && this.pedido.equals(produto.pedido)) return true;
		}else if(!insidePedido && !produto.insidePedido) {
			if(this.IdProduto == produto.IdProduto) return true;
		}else return false;
		return false;
	}
	
}