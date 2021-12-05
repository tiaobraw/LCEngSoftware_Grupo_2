package sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class PedidoAlt {

	private static double comissao = 0.1;

	private int IdPedido;
	private Cliente cliente;
	private LocalDateTime data;
	private int versao;
	private Status status;
	private String descricao;

	private ArrayList<Produto> itensPedido = new ArrayList<>();

	public PedidoAlt() {
	}

	public PedidoAlt(int idPedido, Cliente cliente, int versao, Status status, String descricao) {
		IdPedido = idPedido;
		this.cliente = cliente;
		this.data = LocalDateTime.now();
		this.versao = versao;
		this.status = status;
		this.descricao = descricao;
	}

	public double getValorTotal() {
		double total = 0;
		for (Produto p : itensPedido) {
			total += p.getPreco();
		}
		return total;
	}

	public double getTotalComissao() {
		return getValorTotal() * getComissao();
	}

	public static double getComissao() {
		return comissao;
	}

	public static void setComissao(double comissao) {
		PedidoAlt.comissao = comissao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public ArrayList<Produto> getItensPedido() {
		return itensPedido;
	}

	public void addProduto(Produto produto) {
		itensPedido.add(produto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(IdPedido, cliente, data, descricao, itensPedido, status, versao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoAlt other = (PedidoAlt) obj;
		return IdPedido == other.IdPedido && Objects.equals(cliente, other.cliente) && Objects.equals(data, other.data)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(itensPedido, other.itensPedido)
				&& status == other.status && versao == other.versao;
	}

	@Override
	public String toString() {
		return "PedidoAlt [IdPedido=" + IdPedido + ", cliente=" + cliente + ", data=" + data + ", versao=" + versao
				+ ", status=" + status + ", descricao=" + descricao + ", itensPedido=" + itensPedido + "]";
	}

}
