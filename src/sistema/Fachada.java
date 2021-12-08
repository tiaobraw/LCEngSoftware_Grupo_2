package sistema;

import java.util.ArrayList;
import java.util.List;

import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.JaExisteNoPedidoException;
import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
import exceptions.SenhasNaoConferemException;
import exceptions.StringVaziaException;

public class Fachada {
	private static Fachada instancia;
	private PedidosController pedidos;
	private UsuarioController usuario;
	private ProdutosController produtos;
	private ItemPedidoController itens_pedido;
	
	public Fachada()
	{
		pedidos = new PedidosController();
		usuario = new UsuarioController();
		produtos = new ProdutosController();
		itens_pedido = new ItemPedidoController();
	}
	
	public static Fachada getInstance() {
		if(instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public boolean cadastrarUsuario(String nome, String senha, String email, long numero, long CPF) throws StringVaziaException, ElementoJaExisteException {
		return this.usuario.CadastrarUsuario(nome, senha, email, numero, CPF);
	}
	
	public boolean login(long CPF, String senha) throws ElementoNaoExisteException, SenhaIncorretaException {
		return this.usuario.login(CPF, senha);
	}
	
	public Usuario getUsuario() {
		return this.usuario.getUsuario();
	}
	
	public boolean atualizarUsuario(String nome, String email, long CPF, long numero, String senhaNova, String confirmaSenhaNova, String senhaInformada) throws StringVaziaException, ElementoNaoExisteException, SenhasNaoConferemException, SenhaIncorretaException, SenhaPequenaException {
		return this.usuario.Alterar(nome, email, CPF, numero, senhaNova, confirmaSenhaNova, senhaInformada);
	}
	
	public boolean inserirProduto(Produto produto) throws ElementoJaExisteException, JaExisteNoPedidoException, ElementoNaoExisteException {
		return this.produtos.inserir(produto);
	}
	
	public boolean atualizarProduto(Produto produto) throws ElementoNaoExisteException {
		return this.produtos.atualizar(produto);
	}
	
	public boolean removerProduto(Produto produto) throws ElementoNaoExisteException {
		return this.removerProduto(produto);
	}

	public List<Produto> listarProduto() {
		return this.produtos.listarProduto();
	}
	public boolean adicionarItemPedido(Produto produto) throws ElementoNaoExisteException, ElementoJaExisteException { //Adiciona produto a pedido
		return this.itens_pedido.adicionar(produto);
	}
	
	public boolean removerItemPedido(Produto produto) throws ElementoNaoExisteException { //remove um produto de um carrinho
		return this.itens_pedido.remover(produto);
	}
	
	public ArrayList<Produto> listarMesmoProduto(Produto produto) { //lista todos os produtos iguais (que estao em pedidos diferentes)
		return this.itens_pedido.listarMesmoProduto(produto);
	}
	
	public void removerMesmoProduto(Produto produto) throws ElementoNaoExisteException { //remove todos os produtos iguais (que estao em pedidos diferentes)
		this.itens_pedido.removerMesmoProduto(produto);
	}
	
	public boolean removerItensPedido(Pedido pedido) throws ElementoNaoExisteException { //remove todos os produtos de um pedido
		return this.itens_pedido.removerPedido(pedido);
	}
	
	public boolean atualizarItemPedido(Produto produto) throws ElementoNaoExisteException { //atualiza a quantidade em um pedido
		return this.itens_pedido.atualizar(produto);
	}
	
	public List<Produto> listarItensMesmoPedido(Pedido pedido) { //lista todos os produtos em um mesmo carrinho
		return this.itens_pedido.listarMesmoPedido(pedido);
	}
	
	public Produto getItemPedido(Produto produto) { //pega um produto 
		return this.itens_pedido.getProduto(produto);
	}

}
