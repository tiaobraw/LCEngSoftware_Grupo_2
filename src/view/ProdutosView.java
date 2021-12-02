package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import sistema.Fachada;

import java.awt.Color;
import javax.swing.JTable;

public class ProdutosView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosView frame = new ProdutosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProdutosView(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(267, 117, 917, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] colunas = {"Nome", "Id", "tag", "Descrição", "Observação", "Preço"};
		
		Object[][] dados = {
				{"Produto1", "Id1", "tag1", "Descrição1", "Observação1", "Preço1"},
				{"Produto2", "Id2", "tag2", "Descrição2", "Observação2", "Preço2"}
		};
		
		table = new JTable(dados, colunas);
		table.setBounds(30, 44, 594, 287);
		contentPane.add(table);
		JScrollPane barraRolagem = new JScrollPane(table);
	}
}
