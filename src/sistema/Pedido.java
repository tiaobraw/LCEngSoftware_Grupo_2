package sistema;

import java.util.ArrayList;
import java.util.Calendar;

public class Pedido {
	private int IdPedido;
	private Calendar data;
	private String versao;
	private String status;
	private double comissao;
	private double valorTotal;
	private ArrayList <Produto> Itens = new ArrayList();
	
	public Pedido() {
		
	}
	
	public Pedido(int id, Calendar data, String versao, String Status, double comissao) {
		this.IdPedido = id;
		this.data = data;
		this.versao = versao;
		this.status = Status;
		this.comissao = comissao;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
}