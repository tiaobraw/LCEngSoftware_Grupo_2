package exceptions;

public class ElementoNaoExisteException extends Exception{

	private static final long serialVersionUID = 6274369295099268208L;
	
	private Object elemento;
    
    public ElementoNaoExisteException(Object obj) {
        super("Objeto já está cadastrado no repositório e não pode ser "
                + "adicionado novamente");
        this.elemento = obj;        
    }
    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
}
