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

public class ChgNum extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChgNum frame = new ChgNum("");
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
	public ChgNum(String acc) {
		setTitle("\u4FEE\u6539\u6570\u91CF");
		setClosable(true);
		setBounds(100, 100, 397, 291);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(32, 51, 103, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u6570\u91CF/\u4E2A\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(32, 112, 103, 41);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(127, 56, 183, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 117, 183, 33);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {                         //确认修改
			public void actionPerformed(ActionEvent e) {
				CommodityObj commodityobj = new CommodityObj();
				JOptionPane.showMessageDialog(null, commodityobj.chgnum(acc,Integer.parseInt(textField.getText()) , Integer.parseInt(textField_1.getText())));
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(123, 186, 123, 41);
		getContentPane().add(btnNewButton);

	}

}
