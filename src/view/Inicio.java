package view;

import java.awt.EventQueue;
import view.CadastroView;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Boolean existe = true; //Se já há um cadastro, ir direito pra tela de login. CRIAR MÉTODO PARA VERIFICAR ISSO
				try {
					CadastroView cadastro = new CadastroView();
					LoginView login = new LoginView();
					if(existe) {
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
