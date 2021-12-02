package view;

import javax.swing.JPanel;

import sistema.Fachada;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeuPerfilView extends JPanel {
	private Fachada fachada = new Fachada();
	private AlterarInfoUsuario alterarInfo = new AlterarInfoUsuario(fachada);
	/**
	 * Create the panel.
	 */
	public MeuPerfilView(Fachada fachada) {
		this.fachada = fachada;
		setBackground(new Color(255, 255, 255));
		setBounds(100,100,452,444);
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNome.setBounds(10, 11, 268, 59);
		add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setForeground(Color.BLACK);
		lblCPF.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblCPF.setBounds(10, 81, 268, 59);
		add(lblCPF);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNumero.setBounds(10, 166, 268, 59);
		add(lblNumero);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblEmail.setBounds(10, 283, 268, 59);
		add(lblEmail);
		
		JButton btnAlterar = new JButton("Alterar Informa\u00E7\u00F5es\r\n");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarInfo.setVisible(true);
				alterarInfo.setBounds(150, 150, 500, 350);
				lblNome.setText("Nome: ");//colocar os novos nomes
				lblEmail.setText("Email: ");
				lblNumero.setText("Numero: ");
				lblCPF.setText("CPF: ");
			}
		});
		btnAlterar.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btnAlterar.setBackground(new Color(204, 255, 204));
		btnAlterar.setBounds(62, 391, 223, 42);
		add(btnAlterar);

	}
}
