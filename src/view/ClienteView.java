package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exceptions.ElementoNaoExisteException;
import sistema.Cliente;
import sistema.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteView extends JPanel {
	
	private DefaultListModel model = new DefaultListModel();
	private JList listClientes = new JList(); 
	
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textResponsavel;
	private JTextField textEmailResponsavel;
	private JTextField textCNPJ;
	private JTextField textNomeAt;
	private JTextField textEnderecoAt;
	private JTextField textTelefoneAt;
	private JTextField textEmailAt;
	private JTextField textResponsavelAt;
	private JTextField textResponsavelEmailAt;
	private JTextField textCNPJAt;

	/**
	 * Create the panel.
	 */
	public ClienteView(Fachada fachada) {
		setBackground(Color.LIGHT_GRAY);
		setBounds(267, 117, 917, 444);
		setLayout(null);
		
		listClientes = new JList();
		listClientes.setBounds(0, 70, 666, 374);
		add(listClientes);
		
		JPanel panel = new JPanel();
		panel.setBounds(665, 100, 263, 344);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelAdicionar = new JPanel();
		panelAdicionar.setBounds(0, 0, 253, 344);
		panel.add(panelAdicionar);
		panelAdicionar.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		panelAdicionar.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 43, 73, 14);
		panelAdicionar.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 68, 73, 14);
		panelAdicionar.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 101, 73, 14);
		panelAdicionar.add(lblEmail);
		
		JLabel lblResponsavel = new JLabel("Respons\u00E1vel");
		lblResponsavel.setBounds(10, 134, 73, 14);
		panelAdicionar.add(lblResponsavel);
		
		JLabel lblEmailResponsavel = new JLabel("Email do Respons\u00E1vel");
		lblEmailResponsavel.setBounds(10, 177, 114, 32);
		panelAdicionar.add(lblEmailResponsavel);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 238, 73, 14);
		panelAdicionar.add(lblCNPJ);
		
		textNome = new JTextField();
		textNome.setBounds(57, 8, 186, 20);
		panelAdicionar.add(textNome);
		textNome.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(57, 36, 186, 20);
		panelAdicionar.add(textEndereco);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(57, 65, 186, 20);
		panelAdicionar.add(textTelefone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(57, 93, 186, 20);
		panelAdicionar.add(textEmail);
		
		textResponsavel = new JTextField();
		textResponsavel.setColumns(10);
		textResponsavel.setBounds(10, 149, 233, 20);
		panelAdicionar.add(textResponsavel);
		
		textEmailResponsavel = new JTextField();
		textEmailResponsavel.setColumns(10);
		textEmailResponsavel.setBounds(10, 207, 233, 20);
		panelAdicionar.add(textEmailResponsavel);
		
		textCNPJ = new JTextField();
		textCNPJ.setColumns(10);
		textCNPJ.setBounds(57, 235, 186, 20);
		panelAdicionar.add(textCNPJ);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setBounds(154, 281, 89, 23);
		panelAdicionar.add(btnAdd);
		
		JPanel panelAtualizar = new JPanel();
		panelAtualizar.setLayout(null);
		panelAtualizar.setBounds(0, 0, 253, 344);
		panel.add(panelAtualizar);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 11, 46, 14);
		panelAtualizar.add(lblNome_1);
		
		JLabel lblEndereco_1 = new JLabel("Endere\u00E7o");
		lblEndereco_1.setBounds(10, 43, 73, 14);
		panelAtualizar.add(lblEndereco_1);
		
		JLabel lblTelefone_1 = new JLabel("Telefone");
		lblTelefone_1.setBounds(10, 68, 73, 14);
		panelAtualizar.add(lblTelefone_1);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(10, 101, 73, 14);
		panelAtualizar.add(lblEmail_1);
		
		JLabel lblResponsavel_1 = new JLabel("Respons\u00E1vel");
		lblResponsavel_1.setBounds(10, 134, 73, 14);
		panelAtualizar.add(lblResponsavel_1);
		
		JLabel lblEmailResponsavel_1 = new JLabel("Email do Respons\u00E1vel");
		lblEmailResponsavel_1.setBounds(10, 177, 114, 32);
		panelAtualizar.add(lblEmailResponsavel_1);
		
		JLabel lblCNPJ_1 = new JLabel("CNPJ");
		lblCNPJ_1.setBounds(10, 238, 73, 14);
		panelAtualizar.add(lblCNPJ_1);
		
		textNomeAt = new JTextField();
		textNomeAt.setColumns(10);
		textNomeAt.setBounds(57, 8, 186, 20);
		panelAtualizar.add(textNomeAt);
		
		textEnderecoAt = new JTextField();
		textEnderecoAt.setColumns(10);
		textEnderecoAt.setBounds(57, 36, 186, 20);
		panelAtualizar.add(textEnderecoAt);
		
		textTelefoneAt = new JTextField();
		textTelefoneAt.setColumns(10);
		textTelefoneAt.setBounds(57, 65, 186, 20);
		panelAtualizar.add(textTelefoneAt);
		
		textEmailAt = new JTextField();
		textEmailAt.setColumns(10);
		textEmailAt.setBounds(57, 93, 186, 20);
		panelAtualizar.add(textEmailAt);
		
		textResponsavelAt = new JTextField();
		textResponsavelAt.setColumns(10);
		textResponsavelAt.setBounds(10, 149, 233, 20);
		panelAtualizar.add(textResponsavelAt);
		
		textResponsavelEmailAt = new JTextField();
		textResponsavelEmailAt.setColumns(10);
		textResponsavelEmailAt.setBounds(10, 207, 233, 20);
		panelAtualizar.add(textResponsavelEmailAt);
		
		textCNPJAt = new JTextField();
		textCNPJAt.setColumns(10);
		textCNPJAt.setBounds(57, 235, 186, 20);
		panelAtualizar.add(textCNPJAt);
		
		JButton btnAtt = new JButton("Atualizar");
		btnAtt.setBounds(154, 281, 89, 23);
		panelAtualizar.add(btnAtt);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(665, 71, 89, 23);
		add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente clienteSelecionado = (Cliente)listClientes.getSelectedValue();
				int index = listClientes.getSelectedIndex();
				if(clienteSelecionado != null) {
					try {
						boolean sucesso = fachada.removerCliente(clienteSelecionado);
						if(sucesso) {
							model.remove(index);
							listClientes.setModel(model);
						}
					} catch (ElementoNaoExisteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnExcluir.setBounds(839, 71, 89, 23);
		add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(752, 71, 89, 23);
		add(btnAtualizar);
	}
	
	public void adicionar(Cliente cliente) {
		listClientes.setModel(model);
		model.addElement(cliente);
	}
}
