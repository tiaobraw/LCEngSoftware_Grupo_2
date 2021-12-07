package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import exceptions.ElementoJaExisteException;
import exceptions.StringVaziaException;
import sistema.Fachada;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Inicio;
import javax.swing.JPasswordField;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JPanel panelBase;
	private JFrame frame;
	private JTextField textNome;
	private JPasswordField textSenha;
	private JFormattedTextField textCPF;
	private JFormattedTextField textEmail;
	private JFormattedTextField textNumero;
	Fachada fachada = new Fachada();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroView(Fachada fachada) throws ParseException {
		this.fachada = fachada;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(245, 255, 250));
		panelCadastro.setBounds(0, 0, 772, 70);
		getContentPane().add(panelCadastro);
		panelCadastro.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro\r\n");
		lblCadastro.setBounds(10, 32, 359, 38);
		panelCadastro.add(lblCadastro);
		lblCadastro.setFont(new Font("Candara Light", Font.BOLD, 40));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(135, 206, 235));
		panelTop.setBounds(0, 0, 772, 10);
		panelCadastro.add(panelTop);
		panelTop.setLayout(null);
		
		
		
		panelBase = new JPanel();
		panelBase.setBackground(Color.WHITE);
		panelBase.setBounds(0, 0, 584, 561);
		contentPane.add(panelBase);
		panelBase.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome*\r\n");
		lblNome.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblNome.setBounds(40, 100, 81, 40);
		panelBase.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF*\r\n");
		lblCPF.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblCPF.setBounds(40, 174, 81, 40);
		panelBase.add(lblCPF);
		
		JLabel lblNumero = new JLabel("N\u00FAmero*\r\n");
		lblNumero.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblNumero.setBounds(40, 244, 185, 40);
		panelBase.add(lblNumero);
		
		JLabel lblEmail = new JLabel("Email*\r\n");
		lblEmail.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblEmail.setBounds(40, 317, 185, 40);
		panelBase.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha*\r\n");
		lblSenha.setFont(new Font("Candara Light", Font.PLAIN, 25));
		lblSenha.setBounds(40, 386, 185, 40);
		panelBase.add(lblSenha);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Candara Light", Font.PLAIN, 15));
		textNome.setBackground(new Color(224, 255, 255));
		textNome.setBounds(40, 138, 515, 30);
		panelBase.add(textNome);
		textNome.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Candara Light", Font.PLAIN, 15));
		textSenha.setColumns(10);
		textSenha.setBackground(new Color(224, 255, 255));
		textSenha.setBounds(40, 421, 515, 30);
		panelBase.add(textSenha);
		
		textCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textCPF.setBackground(new Color(224, 255, 255));
		textCPF.setBounds(40, 208, 515, 30);
		panelBase.add(textCPF);
		
		textNumero = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		textNumero.setBackground(new Color(224, 255, 255));
		textNumero.setBounds(40, 276, 515, 30);
		panelBase.add(textNumero);
		
		textEmail = new JFormattedTextField();
		textEmail.setBackground(new Color(224, 255, 255));
		textEmail.setBounds(40, 353, 515, 30);
		panelBase.add(textEmail);
		panelBase.add(lblNome);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Tratar Strings de CPF e número
				long CPF = Long.parseLong(tratarString(textCPF.getText().toString()));
				long numero = Long.parseLong(tratarString(textNumero.getText().toString()));
				String nome = textNome.getText().toString();
				String Email = textEmail.getText().toString();
				String senha = textSenha.getPassword().toString();
				
				Boolean cadastrado;
				try {
					cadastrado = fachada.cadastrarUsuario(nome, senha, Email, CPF, numero);
					if(cadastrado) {
						setVisible(false);
						LoginView login = new LoginView(fachada);
						login.setVisible(true);
						textNome.setText("");
						textEmail.setText("");
						textSenha.setText("");
						textCPF.setText("");
						textNumero.setText("");
					}
				} catch (StringVaziaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ElementoJaExisteException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}catch (ParseException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
	
					
				}
			
		});
		btnConfirmar.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btnConfirmar.setBackground(new Color(204, 255, 204));
		btnConfirmar.setBounds(220, 492, 131, 23);
		panelBase.add(btnConfirmar);
		
	}
	
	public String tratarString(String tratar) {
		tratar = tratar.replace("-", "");
		tratar = tratar.replace(".", "");
		tratar = tratar.replace("(", "");
		tratar = tratar.replace(")", "");
		return tratar;
	}
	
	
	
	
}