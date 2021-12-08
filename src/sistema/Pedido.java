package sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Pedido {
	private int IdPedido;
	private LocalDateTime data;
	private double versao;
	private Status status;
	private double comissao;
	private double valorTotal;
	private String descricao;
	private Cliente cliente;
	
	
	public Pedido() {
		
	}
	
	public Pedido(int id, LocalDateTime data, double versao, Status Status, double comissao, String descricao, Cliente cliente) {
		this.IdPedido = id;
		this.data = data;
		this.versao = versao;
		this.status = Status;
		this.comissao = comissao;
		this.descricao = descricao;
		double valor = 0;
		this.valorTotal = valor * this.comissao;
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public double getVersao() {
		return versao;
	}

	public void setVersao(double versao) {
		this.versao = versao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [IdPedido=" + IdPedido + ", versao=" + versao + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(IdPedido, cliente, versao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return IdPedido == other.IdPedido && Objects.equals(cliente, other.cliente)
				&& Objects.equals(versao, other.versao);
	}
	
	
	
	
	
}