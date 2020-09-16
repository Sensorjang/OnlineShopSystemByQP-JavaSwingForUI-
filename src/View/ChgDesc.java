package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.CommodityObj;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChgDesc extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChgDesc frame = new ChgDesc("");
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
	public ChgDesc(String acc) {
		setTitle("\u4FEE\u6539\u63CF\u8FF0");
		setClosable(true);
		setBounds(100, 100, 496, 385);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 46, 80, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u7684\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 100, 80, 30);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(113, 43, 324, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 106, 324, 139);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {                            //确定修改
			public void actionPerformed(ActionEvent e) {
				CommodityObj commodityobj = new CommodityObj();
				JOptionPane.showMessageDialog(null, commodityobj.chgdesc(acc,Integer.parseInt(textField.getText()) , textField_1.getText()));
			}
		});
		btnNewButton.setBounds(326, 283, 111, 30);
		getContentPane().add(btnNewButton);

	}

}
