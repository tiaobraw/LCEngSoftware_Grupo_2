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
	private JLabel lblCPF;
	private JLabel lblNome;
	private JLabel lblNumero;
	private JLabel lblEmail;
	/**
	 * Create the panel.
	 */
	public MeuPerfilView(Fachada fachada) {
		AlterarInfoUsuario alterarInfo = new AlterarInfoUsuario(fachada, this);
		setBackground(new Color(255, 255, 255));
		setBounds(100,100,452,444);
		setLayout(null);
		
		lblNome = new JLabel("Nome: " + fachada.getUsuario().getNome());
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNome.setBounds(10, 11, 268, 59);
		add(lblNome);
		
		lblCPF = new JLabel("CPF: " + fachada.getUsuario().getCPF());
		lblCPF.setForeground(Color.BLACK);
		lblCPF.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblCPF.setBounds(10, 81, 268, 59);
		add(lblCPF);
		
		lblNumero = new JLabel("Número: " + fachada.getUsuario().getNumero());
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNumero.setBounds(10, 166, 268, 59);
		add(lblNumero);
		
		lblEmail = new JLabel("Email:" + fachada.getUsuario().getEmail());
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblEmail.setBounds(10, 283, 268, 59);
		add(lblEmail);
		
		JButton btnAlterar = new JButton("Alterar Informa\u00E7\u00F5es\r\n");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarInfo.setVisible(true);
				alterarInfo.setBounds(150, 150, 500, 350);
			}
		});
		btnAlterar.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btnAlterar.setBackground(new Color(204, 255, 204));
		btnAlterar.setBounds(62, 391, 223, 42);
		add(btnAlterar);

	}
	public JLabel getLblCPF() {
		return lblCPF;
	}
	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}
	public JLabel getLblNome() {
		return lblNome;
	}
	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}
	public JLabel getLblNumero() {
		return lblNumero;
	}
	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
	}
	public JLabel getLblEmail() {
		return lblEmail;
	}
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}
	
	
}
