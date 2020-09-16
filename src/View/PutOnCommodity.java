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

public class PutOnCommodity extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String acc;
	
	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PutOnCommodity frame = new PutOnCommodity();
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
	public PutOnCommodity() {
		setClosable(true);
		setTitle("\u4E0A\u67B6\u5546\u54C1");
		setBounds(100, 100, 717, 494);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 31, 80, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u5E93\u5B58\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(41, 76, 80, 35);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u5355\u4EF7/\u5143\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(41, 121, 112, 35);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u63CF\u8FF0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(41, 177, 80, 35);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(141, 31, 495, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 80, 495, 29);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 125, 495, 29);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 176, 493, 175);
		getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                           //关闭 按钮
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(421, 390, 179, 47);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u5E03\u5546\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {                        //发布 按钮
			public void actionPerformed(ActionEvent arg0) {
				CommodityObj commodityobj = new CommodityObj();
				JOptionPane.showMessageDialog(null, commodityobj.putoncommodity(textField.getText(), textField_1.getText(), textField_2.getText(),textField_3.getText() , acc));
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(103, 390, 179, 47);
		getContentPane().add(btnNewButton_1);

	}
}
