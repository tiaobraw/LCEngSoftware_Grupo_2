package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;

public class RepositorioGenerico<T> {

	protected List<T> elementos;

	public RepositorioGenerico() {
		this.elementos = new ArrayList<>();
	}

	public void inserir(T novoObj) throws ElementoJaExisteException {
		if (!this.elementos.contains(novoObj)) {
			this.elementos.add(novoObj);
		} else {
			throw new ElementoJaExisteException(novoObj);
		}
	}

	public List<T> listar() {
		return Collections.unmodifiableList(this.elementos);
	}

	public void remover(T obj) throws ElementoNaoExisteException {
		if (this.elementos.contains(obj)) {
			this.elementos.remove(this.elementos.indexOf(obj));
		} else {
			throw new ElementoNaoExisteException(obj);
		}
	}

	public void atualizar(T newObj) throws ElementoNaoExisteException {
		if (this.elementos.contains(newObj)) {
			int indice = this.elementos.indexOf(newObj);
			this.elementos.set(indice, newObj);
		} else {
			throw new ElementoNaoExisteException(newObj);
		}
	}
}
