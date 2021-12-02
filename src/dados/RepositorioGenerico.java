package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import sistema.Pedido;
import sistema.Produto;

public class RepositorioGenerico<T> {

	protected List<T> elementos;

	public RepositorioGenerico() {
		this.elementos = new ArrayList<>();
	}

	public boolean inserir(T novoObj) throws ElementoJaExisteException {
		if (!this.elementos.contains(novoObj)) {
			this.elementos.add(novoObj);
			return true;
		} else throw new ElementoJaExisteException(novoObj);

	}

	public List<T> listar() {
		return Collections.unmodifiableList(this.elementos);
	}
	
	//temporario só pra eu poder testar a classe ProdutosController
	public List<Produto> listar(Pedido pedido){
		List<Produto> lista = null;  //lista objetos apenas com algo similar, exemplo: Produtos que estão no msm pedido
		return lista; 
	}

	public boolean remover(T obj) throws ElementoNaoExisteException {
		if (this.elementos.contains(obj)) {
			this.elementos.remove(this.elementos.indexOf(obj));
			return true;
		} else throw new ElementoNaoExisteException(obj);
	}

	public boolean atualizar(T newObj) throws ElementoNaoExisteException {
		if (this.elementos.contains(newObj)) {
			int indice = this.elementos.indexOf(newObj);
			this.elementos.set(indice, newObj);
			return true;
		} else throw new ElementoNaoExisteException(newObj);
	}
	
	public String getSenha() {
		return ""; //esse metodo vai retornar a senha do usuario
	}
	
	public T getObj(T newObj) {
		for(T a : this.elementos) {
			if(newObj.equals(a)) return a;
		}
		return null;
	}
	
	
	

}
