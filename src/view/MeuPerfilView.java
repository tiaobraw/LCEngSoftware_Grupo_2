package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MeuPerfilView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MeuPerfilView() {
		setBackground(new Color(204, 255, 255));
		setBounds(100,100,917,444);
		setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		panelTop.setBounds(0, 0, 917, 152);
		add(panelTop);
		panelTop.setLayout(null);
		
		JPanel panelTopTop = new JPanel();
		panelTopTop.setBackground(new Color(0, 0, 0));
		panelTopTop.setBounds(0, 0, 917, 29);
		panelTop.add(panelTopTop);
		
		JPanel panelTopBottom = new JPanel();
		panelTopBottom.setBackground(Color.BLACK);
		panelTopBottom.setBounds(0, 79, 917, 18);
		panelTop.add(panelTopBottom);
		
		JLabel lblOla = new JLabel("Ol\u00E1, <seu nome>");
		lblOla.setBounds(0, 63, 243, 14);
		panelTop.add(lblOla);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNome.setBounds(10, 177, 268, 59);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblCpf.setBounds(10, 258, 268, 59);
		add(lblCpf);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblNumero.setBounds(10, 358, 268, 59);
		add(lblNumero);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lblEmail.setBounds(394, 177, 268, 59);
		add(lblEmail);
		
		JButton btnAlterar = new JButton("Alterar Informa\u00E7\u00F5es\r\n");
		btnAlterar.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btnAlterar.setBackground(new Color(204, 255, 204));
		btnAlterar.setBounds(394, 366, 223, 42);
		add(btnAlterar);

	}
}
