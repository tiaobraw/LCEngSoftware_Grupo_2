package view;

import java.awt.BorderLayout;
import sistema.Produto;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import sistema.Fachada;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import exceptions.ElementoNaoExisteException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutosView extends JFrame {

	private JPanel contentPane;
	private DefaultListModel model = new DefaultListModel();
	private JList listProduto = new JList(); 
	/**
	 * Launch the application.
	 */

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
		
		
		listProduto.setBounds(21, 11, 581, 372);
		contentPane.add(listProduto);
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Produto produtoSelecionado = (Produto)listProduto.getSelectedValue();
				
			}
		});
		btnNovoProduto.setBounds(665, 125, 89, 23);
		contentPane.add(btnNovoProduto);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Produto produtoSelecionado = (Produto)listProduto.getSelectedValue();
					int index = listProduto.getSelectedIndex();
					if(produtoSelecionado != null) {
						try {
							boolean sucesso = fachada.removerProduto(produtoSelecionado);
							if(sucesso) {
								model.removeElementAt(index);
								fachada.removerItemPedido(produtoSelecionado);
							}
						} catch (ElementoNaoExisteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}else {
						JOptionPane.showMessageDialog(null, "Selecione um produto!");
					}
			}
		});
		btnExcluir.setBounds(665, 245, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBounds(652, 313, 89, 23);
		contentPane.add(btnNewButton);
		
	
	
		
}
	
	public void adicionar(Produto produto)
	{
		listProduto.setModel(model);
		model.addElement(produto);
	}
}