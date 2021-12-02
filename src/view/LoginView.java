package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import sistema.Fachada;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JPasswordField textSenha;
	Fachada fachada = new Fachada();
	private LogadoView logado = new LogadoView(fachada);
	private MeuPerfilView meuPerfil = new MeuPerfilView(fachada);
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public LoginView(Fachada fachada) throws ParseException {
		this.fachada = fachada;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBase = new JPanel();
		panelBase.setBackground(new Color(255, 255, 255));
		panelBase.setBounds(0, 0, 584, 561);
		contentPane.add(panelBase);
		panelBase.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(245, 255, 250));
		panelLogin.setBounds(0, 0, 772, 70);
		panelBase.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login\r\n");
		lblLogin.setBounds(10, 32, 359, 38);
		panelLogin.add(lblLogin);
		lblLogin.setFont(new Font("Candara Light", Font.BOLD, 40));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(135, 206, 235));
		panelTop.setBounds(0, 0, 772, 10);
		panelLogin.add(panelTop);
		panelTop.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblCPF.setBounds(40, 96, 81, 40);
		panelBase.add(lblCPF);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblSenha.setBounds(40, 199, 185, 40);
		panelBase.add(lblSenha);
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Candara Light", Font.PLAIN, 15));
		textSenha.setColumns(10);
		textSenha.setBackground(new Color(224, 255, 255));
		textSenha.setBounds(40, 250, 515, 30);
		panelBase.add(textSenha);
		
		textCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textCPF.setBackground(new Color(224, 255, 255));
		textCPF.setBounds(40, 133, 515, 30);
		panelBase.add(textCPF);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CPF = tratarString(textCPF.getText().toString());
				String senha = textSenha.getPassword().toString();
				boolean isLogado = true; //aqui no caso seria a chamada do método para fazer o login e que retorna true se o login foi feito e false se não
				if(isLogado) {
					setVisible(false);
					logado.setVisible(true);
					meuPerfil.setVisible(true);
				}//chamar tela principal
			}
		});
		btnConfirmar.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btnConfirmar.setBackground(new Color(204, 255, 204));
		btnConfirmar.setBounds(424, 320, 131, 23);
		panelBase.add(btnConfirmar);
		
		JLabel lblEsqueceuSenha = new JLabel("Esqueceu sua senha?");
		lblEsqueceuSenha.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 11));
		lblEsqueceuSenha.setBounds(40, 365, 105, 14);
		panelBase.add(lblEsqueceuSenha);
		
	}
	
	public String tratarString(String tratar) {
		tratar = tratar.replace("-", "");
		tratar = tratar.replace(".", "");
		tratar = tratar.replace("(", "");
		tratar = tratar.replace(")", "");
		return tratar;
	}
	
	
}
