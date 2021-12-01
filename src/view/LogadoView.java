package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogadoView extends JFrame {

	private JPanel contentPane;
	private MeuPerfilView perfil = new MeuPerfilView();


	/**
	 * Create the frame.
	 */
	public LogadoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		perfil.setVisible(true);
		
		JPanel panelBase = new JPanel();
		panelBase.setBackground(new Color(255, 255, 255));
		panelBase.setBounds(0, 0, 1184, 561);
		contentPane.add(panelBase);
		panelBase.setLayout(null);
		
		JPanel panelInicio = new JPanel();
		panelInicio.setBackground(new Color(245, 255, 250));
		panelInicio.setBounds(0, 0, 1184, 70);
		panelBase.add(panelInicio);
		panelInicio.setLayout(null);
		
		JLabel lblInicio = new JLabel("Bem-vindo, <seu nome>. \r\n");
		lblInicio.setBounds(10, 32, 573, 38);
		panelInicio.add(lblInicio);
		lblInicio.setFont(new Font("Candara Light", Font.BOLD, 40));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(135, 206, 235));
		panelTop.setBounds(0, 0, 1184, 10);
		panelInicio.add(panelTop);
		panelTop.setLayout(null);
		
		JPanel panelBarraLateral = new JPanel();
		panelBarraLateral.setBackground(new Color(135, 206, 235));
		panelBarraLateral.setBounds(0, 117, 268, 444);
		panelBase.add(panelBarraLateral);
		panelBarraLateral.setLayout(null);
		
		/*JPanel panelBaseLateral = new JPanel();
		panelBaseLateral.setBounds(267, 117, 917, 444);
		panelBaseLateral.setBackground(new Color(245, 255, 250));
		panelBase.add(panelBaseLateral);
		panelBaseLateral.setLayout(null);
		*/
		JPanel panelMeuPerfil = new JPanel();
		panelMeuPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//abrir parte do meu perfil
				panelBase.add(perfil);
				perfil.setBounds(267, 117, 917, 444);
				perfil.setVisible(true);
			}
		});
		panelMeuPerfil.setBounds(0, 25, 268, 59);
		panelMeuPerfil.setBackground(new Color(0, 0, 0));
		panelBarraLateral.add(panelMeuPerfil);
		panelMeuPerfil.setLayout(null);
		
		JLabel lblMeuPerfil = new JLabel("      Meu Perfil");
		lblMeuPerfil.setFont(new Font("Candara Light", Font.PLAIN, 36));
		lblMeuPerfil.setForeground(new Color(255, 255, 204));
		lblMeuPerfil.setBounds(21, 11, 220, 37);
		panelMeuPerfil.add(lblMeuPerfil);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBounds(0, 112, 268, 59);
		panelProdutos.setBackground(new Color(0, 0, 0));
		panelBarraLateral.add(panelProdutos);
		panelProdutos.setLayout(null);
		
		JLabel lblProdutos = new JLabel("       Produtos");
		lblProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		lblProdutos.setForeground(new Color(255, 255, 204));
		lblProdutos.setFont(new Font("Candara Light", Font.PLAIN, 36));
		lblProdutos.setBounds(0, 0, 268, 59);
		panelProdutos.add(lblProdutos);
		
		JPanel panelClientes = new JPanel();
		panelClientes.setBounds(0, 198, 268, 59);
		panelClientes.setBackground(new Color(0, 0, 0));
		panelBarraLateral.add(panelClientes);
		panelClientes.setLayout(null);
		
		JLabel lblClientes = new JLabel("       Clientes");
		lblClientes.setForeground(new Color(255, 255, 204));
		lblClientes.setFont(new Font("Candara Light", Font.PLAIN, 36));
		lblClientes.setBounds(0, 0, 268, 59);
		panelClientes.add(lblClientes);
		
		JPanel panelRelatorios = new JPanel();
		panelRelatorios.setBounds(0, 291, 268, 59);
		panelRelatorios.setBackground(Color.BLACK);
		panelBarraLateral.add(panelRelatorios);
		panelRelatorios.setLayout(null);
		
		JLabel lblRelatorios = new JLabel("       Relat\u00F3rios");
		lblRelatorios.setForeground(new Color(255, 255, 204));
		lblRelatorios.setFont(new Font("Candara Light", Font.PLAIN, 36));
		lblRelatorios.setBounds(0, 0, 268, 59);
		panelRelatorios.add(lblRelatorios);
		
		JPanel panelSair = new JPanel();
		panelSair.setBounds(0, 374, 268, 59);
		panelSair.setBackground(Color.BLACK);
		panelBarraLateral.add(panelSair);
		panelSair.setLayout(null);
		
		JLabel lblSair = new JLabel("            Sair\r\n");
		lblSair.setForeground(new Color(255, 255, 204));
		lblSair.setFont(new Font("Candara Light", Font.PLAIN, 36));
		lblSair.setBounds(0, 0, 268, 59);
		panelSair.add(lblSair);
		
		
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(135, 206, 235));
		panelBottom.setBounds(0, 71, 1184, 47);
		panelBase.add(panelBottom);
		panelBottom.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 42, 1184, 5);
		panelBottom.add(panel);
	}

}
