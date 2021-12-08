package view;

import java.awt.EventQueue;
import view.CadastroView;
import sistema.Cliente;
import sistema.Fachada;
import sistema.Pedido;
import sistema.Produto;
import sistema.Usuario;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Boolean existe = false; //Se já há um cadastro, ir direito pra tela de login. CRIAR MÉTODO PARA VERIFICAR ISSO
				Cliente cliente = new Cliente();
				Produto produto = new Produto();
				Pedido pedido = new Pedido();
				Usuario usuario = new Usuario();
				Fachada fachada = new Fachada();
				try {
					CadastroView cadastro = new CadastroView(fachada);
					LoginView login = new LoginView(fachada);
					if(!existe) {
						cadastro.setVisible(true);	
						login.setVisible(false);	
					}else
					{
						cadastro.setVisible(false);	
						login.setVisible(true);	
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
