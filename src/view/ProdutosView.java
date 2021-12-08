package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.ElementoJaExisteException;
import exceptions.ElementoNaoExisteException;
import exceptions.JaExisteNoPedidoException;
import sistema.Fachada;
import sistema.Produto;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProdutosView extends JPanel {

	private DefaultListModel model = new DefaultListModel();
	private JList listProduto = new JList(); 
	private JTextField textNome;
	private JTextField textCodigo;
	private JTextField textTag;
	private JTextField textDescricao;
	private JTextField textObs;
	private JTextField textPreco;
	private JTextField textNomeAt;
	private JTextField textCodigoAt;
	private JTextField textTagAt;
	private JTextField textDescricaoAt;
	private JTextField textObsAt;
	private JTextField textPrecoAt;
	/**
	 * Create the panel.
	 */
	public ProdutosView(Fachada fachada) {
		setBackground(new Color(255, 255, 255));
		setBounds(267, 117, 917, 444);
		setLayout(null);
		
		JList listProduto = new JList();
		listProduto.setBounds(10, 78, 581, 355);
		add(listProduto);
		
		JButton btnAdicionarProduto = new JButton("Adicionar");
		btnAdicionarProduto.setBounds(618, 29, 143, 30);
		add(btnAdicionarProduto);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(760, 29, 147, 30);
		add(btnExcluir);
		
		JPanel panelBase = new JPanel();
		panelBase.setBounds(618, 61, 289, 372);
		add(panelBase);
		panelBase.setLayout(null);
		
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
		btnExcluir.setBounds(754, 4, 147, 30);
		add(btnExcluir);
		
		JPanel panelNovoProduto = new JPanel();
		panelNovoProduto.setBounds(0, 0, 289, 372);
		panelBase.add(panelNovoProduto);
		panelNovoProduto.setLayout(null);
		panelNovoProduto.setVisible(false);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 56, 46, 14);
		panelNovoProduto.add(lblCodigo);
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setBounds(10, 96, 46, 14);
		panelNovoProduto.add(lblTag);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(10, 146, 46, 14);
		panelNovoProduto.add(lblDescricao);
		
		JLabel lblObservacao = new JLabel("Observa\u00E7\u00E3o");
		lblObservacao.setBounds(10, 215, 72, 14);
		panelNovoProduto.add(lblObservacao);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 263, 46, 14);
		panelNovoProduto.add(lblPreco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		panelNovoProduto.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 27, 237, 20);
		panelNovoProduto.add(textNome);
		textNome.setColumns(10);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(10, 69, 237, 20);
		panelNovoProduto.add(textCodigo);
		
		textTag = new JTextField();
		textTag.setColumns(10);
		textTag.setBounds(10, 113, 237, 20);
		panelNovoProduto.add(textTag);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(10, 163, 237, 38);
		panelNovoProduto.add(textDescricao);
		
		textObs = new JTextField();
		textObs.setColumns(10);
		textObs.setBounds(10, 231, 237, 29);
		panelNovoProduto.add(textObs);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(10, 284, 237, 20);
		panelNovoProduto.add(textPreco);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText().toString();
				String tag = textTag.getText().toString();
				String descricao = textDescricao.getText().toString();
				String observacao = textObs.getText().toString();
				double preco = Double.parseDouble(textPreco.getText().toString());
				int codigo = Integer.parseInt(textCodigo.getText().toString());
				Produto produto = new Produto(codigo, tag, descricao, observacao, preco, nome);
				try {
					boolean sucesso = fachada.inserirProduto(produto);
					if(sucesso) {
						textNome.setText("");
						textTag.setText("");
						textDescricao.setText("");
						textObs.setText("");
						textPreco.setText("");
						textCodigo.setText("");
						adicionar(produto);
					}
				} catch (ElementoJaExisteException | JaExisteNoPedidoException | ElementoNaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionar.setBounds(140, 338, 107, 23);
		panelNovoProduto.add(btnAdicionar);
		
		JPanel panelAtualizar = new JPanel();
		panelAtualizar.setLayout(null);
		panelAtualizar.setBounds(0, 0, 289, 372);
		panelBase.add(panelAtualizar);
		panelAtualizar.setVisible(false);
		
		JLabel lblCodigo_1 = new JLabel("C\u00F3digo");
		lblCodigo_1.setBounds(10, 56, 46, 14);
		panelAtualizar.add(lblCodigo_1);
		
		JLabel lblTag_1 = new JLabel("Tag");
		lblTag_1.setBounds(10, 96, 46, 14);
		panelAtualizar.add(lblTag_1);
		
		JLabel lblDescricao_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao_1.setBounds(10, 146, 46, 14);
		panelAtualizar.add(lblDescricao_1);
		
		JLabel lblObservacao_1 = new JLabel("Observa\u00E7\u00E3o");
		lblObservacao_1.setBounds(10, 215, 72, 14);
		panelAtualizar.add(lblObservacao_1);
		
		JLabel lblPreco_1 = new JLabel("Pre\u00E7o");
		lblPreco_1.setBounds(10, 263, 46, 14);
		panelAtualizar.add(lblPreco_1);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 11, 46, 14);
		panelAtualizar.add(lblNome_1);
		
		textNomeAt = new JTextField();
		textNomeAt.setColumns(10);
		textNomeAt.setBounds(10, 27, 237, 20);
		panelAtualizar.add(textNomeAt);
		
		textCodigoAt = new JTextField();
		textCodigoAt.setColumns(10);
		textCodigoAt.setBounds(10, 69, 237, 20);
		panelAtualizar.add(textCodigoAt);
		
		textTagAt = new JTextField();
		textTagAt.setColumns(10);
		textTagAt.setBounds(10, 113, 237, 20);
		panelAtualizar.add(textTagAt);
		
		textDescricaoAt = new JTextField();
		textDescricaoAt.setColumns(10);
		textDescricaoAt.setBounds(10, 163, 237, 38);
		panelAtualizar.add(textDescricaoAt);
		
		textObsAt = new JTextField();
		textObsAt.setColumns(10);
		textObsAt.setBounds(10, 231, 237, 29);
		panelAtualizar.add(textObsAt);
		
		textPrecoAt = new JTextField();
		textPrecoAt.setColumns(10);
		textPrecoAt.setBounds(10, 284, 237, 20);
		panelAtualizar.add(textPrecoAt);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listProduto.getSelectedIndex();
				String nome = textNomeAt.getText().toString();
				String tag = textTagAt.getText().toString();
				String descricao = textDescricaoAt.getText().toString();
				String observacao = textObsAt.getText().toString();
				double preco = Double.parseDouble(textPrecoAt.getText().toString());
				int codigo = Integer.parseInt(textCodigoAt.getText().toString());
				Produto produto = new Produto(codigo, tag, descricao, observacao, preco, nome);
				
				try {
					boolean sucesso = fachada.atualizarProduto(produto);
					if(sucesso) {
						listProduto.setModel(model);
						model.set(index, produto);
						textNomeAt.setText("");
						textTagAt.setText("");
						textDescricaoAt.setText("");
						textObsAt.setText("");
						textPrecoAt.setText("");
						textCodigoAt.setText("");
					}
				} catch (ElementoNaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnAtualizar.setBounds(140, 338, 107, 23);
		panelAtualizar.add(btnAtualizar);
		
		listProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Produto produtoSelecionado = (Produto) listProduto.getSelectedValue();
				int index = listProduto.getSelectedIndex();
				textNomeAt.setText(produtoSelecionado.getNome());
				textTagAt.setText(produtoSelecionado.getTag());
				textDescricaoAt.setText(produtoSelecionado.getDescricao());
				textObsAt.setText(produtoSelecionado.getObservacao());
				textPrecoAt.setText(Double.toString(produtoSelecionado.getPreco()));
				textCodigo.setText(Integer.toString(produtoSelecionado.getIdProduto()));
				panelNovoProduto.setVisible(false);
				panelAtualizar.setVisible(true);
				
			}
		});
		btnAdicionarProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panelAtualizar.setVisible(false);
				panelNovoProduto.setVisible(true);

			}
		});
		
	
	
	}
	public void adicionar(Produto produto)
	{
		listProduto.setModel(model);
		model.addElement(produto);
	}
}
