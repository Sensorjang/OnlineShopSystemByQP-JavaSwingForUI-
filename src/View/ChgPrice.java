package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.CommodityObj;

import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChgPrice extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChgPrice frame = new ChgPrice("");
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
	public ChgPrice(String acc) {
		getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {   
			}
		});
		
		setTitle("\u4FEE\u6539\u4EF7\u683C");
		setClosable(true);
		setBounds(100, 100, 467, 275);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(32, 54, 88, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u4EF7\u683C/\u5143\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(32, 121, 99, 40);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(130, 54, 264, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 121, 264, 31);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                //确定修改
				CommodityObj commodityobj = new CommodityObj();
				JOptionPane.showMessageDialog(null, commodityobj.chgprice(acc,Integer.parseInt(textField.getText()) , Integer.parseInt(textField_1.getText())));
			}
		});
		btnNewButton.setBounds(168, 184, 115, 31);
		getContentPane().add(btnNewButton);

	}

}
