package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.SenhaIncorretaException;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarSenhaView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField textSenha;
	private JButton okButton;


	/**
	 * Create the dialog.
	 */
	public ConfirmarSenhaView() {
		setBounds(100, 100, 383, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Confirme sua senha:");
			lblNewLabel.setFont(new Font("Candara Light", Font.PLAIN, 17));
			lblNewLabel.setBounds(10, 0, 308, 25);
			contentPanel.add(lblNewLabel);
		}
		
		textSenha = new JPasswordField();
		textSenha.setBounds(10, 27, 245, 20);
		contentPanel.add(textSenha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 235));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textSenha.setText("");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JPasswordField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JPasswordField textSenha) {
		this.textSenha = textSenha;
	}

	

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
	
	
	
	
}
