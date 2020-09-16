package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import AccessObj.BalanceObj;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recharge extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recharge frame = new Recharge("","");
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
	public Recharge(String type,String acc) {
		setTitle("\u5145\u503C");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(40, 107, 205, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5145\u503C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(textField.getText());
				BalanceObj balanceobj = new BalanceObj();
				if("Bussiness".equals(type)) JOptionPane.showMessageDialog(null, balanceobj.recharge("Bussiness", acc, i));
				else JOptionPane.showMessageDialog(null, balanceobj.recharge("User", acc, i));
				
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		btnNewButton.setBounds(268, 107, 131, 41);
		getContentPane().add(btnNewButton);

	}

}
