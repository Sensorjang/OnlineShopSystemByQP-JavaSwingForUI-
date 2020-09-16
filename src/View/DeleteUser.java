package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.UserObj;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteUser extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		setTitle("\u7528\u6237\u5220\u9664");
		setClosable(true);
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("account\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 87, 73, 29);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 87, 186, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                    //È·¶¨É¾³ý
				UserObj userobj =new UserObj();
				JOptionPane.showMessageDialog(null, userobj.deleteuser(textField.getText()));
			}
		});
		btnNewButton.setBounds(309, 90, 93, 23);
		getContentPane().add(btnNewButton);

	}
}
