package sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Pedido {
	private int IdPedido;
	private Calendar data;
	private String versao;
	private Status status;
	private double comissao;
	private double valorTotal;
	private String descricao;
	private ArrayList <Produto> Itens = new ArrayList();
	
	public Pedido() {
		
	}
	
	public Pedido(int id, Calendar data, String versao, Status Status, double comissao, String descricao) {
		this.IdPedido = id;
		this.data = data;
		this.versao = versao;
		this.status = Status;
		this.comissao = comissao;
		this.descricao = descricao;
		double valor = 0;
		for (int i = 0; i < Itens.size(); i++) {
			valor = valor + Itens.get(i).getPreco();
		}
		this.valorTotal = valor * this.comissao;
	}
	
	public boolean addItem(Produto p) {
		for(int i = 0; i < Itens.size(); i++) {
			if(Itens.get(i).equals(p)) {
				return false;
			} else {
				Itens.add(p);
				this.valorTotal = calcularTotal();
				return true;
			}
		}
		return false;
	}
	
	public double calcularTotal() {
		double valor = 0;
		double vTotal = 0;
		for (int i = 0; i < Itens.size(); i++) {
			valor = valor + Itens.get(i).getPreco();
		}
		vTotal = valor * this.comissao;
		return vTotal;
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
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

	public ArrayList<Produto> getItens() {
		return Itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		Itens = itens;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Pedido [IdPedido=" + IdPedido + ", versao=" + versao + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(IdPedido, versao);
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
		return IdPedido == other.IdPedido && Objects.equals(versao, other.versao);
	}
	
	
}