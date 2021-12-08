package sistema;

import java.util.ArrayList;
import java.util.List;

import dados.RepositorioGenerico;
import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.JaExisteNoPedidoException;

public class ProdutosController {

	private RepositorioGenerico<Produto> repositorioProdutos;

	public ProdutosController() {
		this.repositorioProdutos = new RepositorioGenerico<Produto>();
	}

	public boolean inserirProduto(Produto produto) throws ElementoJaExisteException, JaExisteNoPedidoException, ElementoNaoExisteException {
		Produto temporario = produto; //produto temporario
		temporario = this.repositorioProdutos.getObj(temporario); //verifica se produto ja existe no repositorio
		if(temporario == null) { //se ele nao existe
			if(produto.getPedido() == null) { //se o o pedido do produto for null, significa que a tentativa é de adicionar ele no sistema, e nao em um pedido
				//inserir normalmente
				return this.repositorioProdutos.inserir(produto);
			}else { //se o pedido do produto não for null, significa que a tentativa foi de adicionar um produto que não existe no sistema ao pedido
				throw new ElementoNaoExisteException(produto);
			}
		}else { //se o produto ja existe no sistema
			if(produto.getPedido() != null) {  //se há um pedido, entao a tentativa foi de adicionar nele
				//inserir produto em um pedido (pedido_item)
				return this.repositorioProdutos.inserir(produto);
			}else {//se o pedido for null, significa a tentativa foi de adicionar um produto que ja existe no sistema
				
				throw new ElementoJaExisteException(produto);
			}
		}
		
		
	}
	


	public List<Produto> listarProduto() {
		return repositorioProdutos.listar();
	}
	
	public List<Produto> listarProduto(Pedido pedido) //ESSE MÉTODO É PARA LISTAR OS PRODUTOS DE UM MESMO PEDIDO, ou seja, produto que insidePedido == true && pedido(parametro) == produto.pedido
	{
		return this.repositorioProdutos.listar(pedido);
		//se for do msm pedido, faz a list
	}

	public boolean remover(Produto produto) throws ElementoNaoExisteException {
		Produto temporario = produto;
		temporario = this.repositorioProdutos.getObj(temporario);
		if(temporario != null) { //se produto existe
			if(produto.getPedido() == null) { //a tentativa foi de deletar o pedido do sistema
				return this.repositorioProdutos.remover(produto);
			}else { //se o produto está em um pedido a tentativa foi de deletar ele do pedido
				//remover o pedido_item
				if(this.repositorioProdutos.remover(produto)) {
					this.removerPedido(produto);
					return true;
				}else return false;
			}
		}else {
			throw new ElementoNaoExisteException(produto);
		}
	}
	
	private void removerPedido(Produto produto) throws ElementoNaoExisteException {
		List<Produto> produtos = this.listarProduto(); 
		for(int i = 0; i < produtos.size(); i++) { //percorrer todos os produtos pedido_item
			if(produtos.get(i).getIdProduto() == produto.getIdProduto()) //se o id do produto que foi atualizado no sistema for o mesmo
			{
				produtos.remove(i);
				this.repositorioProdutos.remover(produtos.get(i)); //remover pedido_item
			}
		}
	}

	public boolean atualizar(Produto oldProduto, Produto newProduto) throws ElementoNaoExisteException {
		Produto temporario = oldProduto;
		temporario = this.repositorioProdutos.getObj(temporario);
		if(temporario != null) {
			if(oldProduto.getPedido() == null) { //se nao está em um pedido
				//Caso as informações do produto sejam atualizado no sistema, deve ser também atualizado nos pedidos
				if(this.repositorioProdutos.atualizar(newProduto)) {
					this.atualizar(newProduto);
					return true;
				}
				
			}else {
				return this.repositorioProdutos.atualizar(newProduto); //aqui atualiza pedido_item
			}
		}else {
			throw new ElementoNaoExisteException(oldProduto);
		}
		return false;
	}
	
	private void atualizar(Produto produto) throws ElementoNaoExisteException {
		List<Produto> produtos = this.listarProduto(); 
		for(int i = 0; i < produtos.size(); i++) { //percorrer todos os produtos pedido_item
			if(produtos.get(i).getIdProduto() == produto.getIdProduto()) //se o id do produto que foi atualizado no sistema for o mesmo
			{
				Produto newProduto = produto; 
				newProduto.setQuantidade(produtos.get(i).getQuantidade());
				newProduto.setPedido(produtos.get(i).getPedido()); //atualiza o produto no pedido, só deixa a quantidade e o pedido o mesmo
				produtos.set(i, newProduto);
				this.repositorioProdutos.atualizar(newProduto); //atualizar pedido_item
			}
		}
	}

}
