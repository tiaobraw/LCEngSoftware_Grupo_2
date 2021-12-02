package sistema;

public class Fachada {
	private static Fachada instancia;
	private PedidosController pedidos;
	
	public Fachada()
	{
		pedidos = new PedidosController();
	}
	
	public static Fachada getInstance() {
		if(instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public void inserirPedido() {
		pedidos.inserir();
	}
}
