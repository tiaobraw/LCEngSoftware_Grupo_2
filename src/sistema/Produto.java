package sistema;

public class Produto {
	private int IdProduto;
	private String Tag;
	private String Descricao;
	private String Observacao;
	private double preco;
	private String nome;
	private Pedido pedido;
	private int quantidade; //é nula se pedido for null
	
	public Produto (int id, String tag, String descricao, String observacao, double preco, String nome, Pedido pedido) {
		this.IdProduto = id;
		this.Tag = tag;
		this.Descricao = descricao;
		this.Observacao = observacao;
		this.preco = preco;
		this.nome = nome;
		this.pedido = pedido;
		this.quantidade = 0;
	}
	public Produto (int id, String tag, String descricao, String observacao, double preco, String nome, Pedido pedido, int quantidade) {
		this.IdProduto = id;
		this.Tag = tag;
		this.Descricao = descricao;
		this.Observacao = observacao;
		this.preco = preco;
		this.nome = nome;
		this.pedido = pedido;
		this.quantidade = quantidade;
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
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean equals(Produto produto) {
		if(this != null && produto != null) { //produtos nao sao nulos
			if(this.pedido != null && produto.pedido != null &&  //se produto está em um pedido (!=null)
					this.IdProduto == produto.IdProduto && //se eles tem o mesmo id
					this.pedido.equals(produto.pedido)) { //se eles estao no msm pedido
				return true; //então sao iguais
			}else if(this.pedido == null && produto.pedido == null //se ambos nao estao em um pedido
					&& this.IdProduto == produto.IdProduto) { //se tiverem o msm id sao iguais
				return true;
			}
		}
		return false;
	}
}