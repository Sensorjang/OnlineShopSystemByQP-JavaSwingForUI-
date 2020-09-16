package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import AccessObj.BussinessObj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteBussiness extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBussiness frame = new DeleteBussiness();
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
	public DeleteBussiness() {
		setTitle("\u5220\u9664\u5546\u5BB6");
		setClosable(true);
		setBounds(100, 100, 425, 238);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                    //È·¶¨É¾³ý
				BussinessObj bussinessobj= new BussinessObj();
				JOptionPane.showMessageDialog(null, bussinessobj.deletebussiness(textField.getText()));
			}
		});
		btnNewButton.setBounds(291, 91, 93, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(101, 87, 167, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("account\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 93, 63, 19);
		getContentPane().add(lblNewLabel);

	}

}
