package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.ElementoNaoExisteException;
import exceptions.SenhaIncorretaException;
import exceptions.SenhaPequenaException;
import exceptions.SenhasNaoConferemException;
import exceptions.StringVaziaException;
import sistema.Fachada;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class AlterarInfoUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JFormattedTextField textCPF;
	private JTextField textEmail;
	private JFormattedTextField textNumero;
	private JPasswordField textSenha;
	private Fachada fachada = new Fachada();
	private JPasswordField textConfirmarSenha;
	private JPasswordField textInformeSenha;


	/**
	 * Create the dialog.
	 */
	public AlterarInfoUsuario(Fachada fachada, MeuPerfilView meuPerfil) {
		this.fachada = fachada;
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(25, 31, 147, 20);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		textNome.setText(fachada.getUsuario().getNome());
		{
			textCPF = new JFormattedTextField();
			textCPF.setColumns(10);
			textCPF.setBounds(25, 87, 147, 20);
			contentPanel.add(textCPF);
			textCPF.setText(String.valueOf(fachada.getUsuario().getCPF()));
		}
		{
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(25, 151, 147, 20);
			contentPanel.add(textEmail);
			textEmail.setText(fachada.getUsuario().getEmail());
		}
		{
			textNumero = new JFormattedTextField();
			textNumero.setColumns(10);
			textNumero.setBounds(239, 31, 147, 20);
			contentPanel.add(textNumero);
			textNumero.setText(String.valueOf(fachada.getUsuario().getNumero()));
		}
		{
			textSenha = new JPasswordField();
			textSenha.setColumns(10);
			textSenha.setBounds(239, 87, 147, 20);
			contentPanel.add(textSenha);
		}
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblNome.setBounds(25, 21, 90, 14);
		contentPanel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblCpf.setBounds(25, 65, 90, 24);
		contentPanel.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblEmail.setBounds(25, 133, 67, 20);
		contentPanel.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblSenha.setBounds(239, 66, 78, 22);
		contentPanel.add(lblSenha);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblNumero.setBounds(239, 21, 108, 14);
		contentPanel.add(lblNumero);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblConfirmarSenha.setBounds(239, 134, 169, 22);
		contentPanel.add(lblConfirmarSenha);
		
		textConfirmarSenha = new JPasswordField();
		textConfirmarSenha.setColumns(10);
		textConfirmarSenha.setBounds(239, 151, 147, 20);
		contentPanel.add(textConfirmarSenha);
		
		JLabel lblInformeSuaSenha = new JLabel("Informe sua senha");
		lblInformeSuaSenha.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblInformeSuaSenha.setBounds(25, 195, 169, 22);
		contentPanel.add(lblInformeSuaSenha);
		
		textInformeSenha = new JPasswordField();
		textInformeSenha.setColumns(10);
		textInformeSenha.setBounds(159, 194, 228, 20);
		contentPanel.add(textInformeSenha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color (135, 206, 235));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = textNome.getText().toString();
						String email = textEmail.getText().toString();
						long numero = Long.parseLong(tratarString(textNumero.getText().toString()));
						long CPF = Long.parseLong(textCPF.getText().toString());
						String senha = textSenha.getPassword().toString();
						String confirmarSenha = textConfirmarSenha.getPassword().toString();
						String senhaInformada = textInformeSenha.getPassword().toString();
						
						try {
							boolean alterado = fachada.atualizarUsuario(nome, email, CPF, numero, senha, confirmarSenha, senhaInformada);
							if(alterado) {
								textNome.setText("");
								textEmail.setText("");
								textSenha.setText("");
								textCPF.setText("");
								textNumero.setText("");
								textConfirmarSenha.setText("");
								textInformeSenha.setText("");
								
								meuPerfil.getLblNome().setText("Nome: " + fachada.getUsuario().getNome());
								meuPerfil.getLblCPF().setText("CPF: " + fachada.getUsuario().getCPF());
								meuPerfil.getLblEmail().setText("Email: " +fachada.getUsuario().getEmail());
								meuPerfil.getLblNumero().setText("Número: " + fachada.getUsuario().getNumero());
								
								JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
								setVisible(false);
							}
						} catch (StringVaziaException | ElementoNaoExisteException | SenhasNaoConferemException
								| SenhaIncorretaException | SenhaPequenaException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						
						
							
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	public String tratarString(String tratar) {
		tratar = tratar.replace("-", "");
		tratar = tratar.replace(".", "");
		tratar = tratar.replace("(", "");
		tratar = tratar.replace(")", "");
		return tratar;
	}
}

