package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.SenhaIncorretaException;

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
	private ConfirmarSenhaView confirmarSenha = new ConfirmarSenhaView();


	/**
	 * Create the dialog.
	 */
	public AlterarInfoUsuario() {
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
		{
			textCPF = new JFormattedTextField();
			textCPF.setColumns(10);
			textCPF.setBounds(25, 87, 147, 20);
			contentPanel.add(textCPF);
		}
		{
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(25, 151, 147, 20);
			contentPanel.add(textEmail);
		}
		{
			textNumero = new JFormattedTextField();
			textNumero.setColumns(10);
			textNumero.setBounds(239, 31, 147, 20);
			contentPanel.add(textNumero);
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
						if(email.length() != 0 || senha.length() != 0) {
							confirmarSenha.setVisible(true);
							confirmarSenha.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
							confirmarSenha.setBounds(200, 200, 150, 200);
							confirmarSenha.getOkButton().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									String senha = confirmarSenha.getTextSenha().getPassword().toString();
									try {
									if(senha == "") { //comparar senha digitada com a real
										
										textSenha.setText("");
										confirmarSenha.setVisible(false);
										setVisible(false);
										JOptionPane.showMessageDialog(null, "Informações modificadas com sucesso");
									}else {
										throw new SenhaIncorretaException();
									}
									}catch(SenhaIncorretaException e1)
									{
										JOptionPane.showMessageDialog(null, e1.getMessage());
									}
								}
							});
						}else {
							//só mudar as coisas automaticas
							JOptionPane.showMessageDialog(null, "Informações modificadas com sucesso!");
							setVisible(false);
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

