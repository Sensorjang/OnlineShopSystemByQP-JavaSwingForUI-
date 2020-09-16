package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.CommodityObj;
import model.usertype;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCommodity extends JInternalFrame {
	private JTextField textField;
	private String Ur;

	public String getUr() {
		return Ur;
	}

	public void setUr(String ur) {
		Ur = ur;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCommodity frame = new DeleteCommodity();
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
	public DeleteCommodity() {
		setTitle("\u5220\u9664\u5546\u54C1");
		setClosable(true);
		setBounds(100, 100, 569, 354);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 137, 107, 40);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 137, 161, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		btnNewButton.setBounds(377, 137, 107, 40);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u63D0\u793A\uFF1A\u5546\u5BB6\u4EC5\u53EF\u5220\u9664\u81EA\u5DF1\u53D1\u5E03\u7684\u5546\u54C1    \u7BA1\u7406\u5458\u53EF\u4EE5\u5220\u9664\u4EFB\u4F55\u5546\u54C1");
		lblNewLabel_1.setBounds(90, 244, 453, 15);
		getContentPane().add(lblNewLabel_1);

	}
	
	public void delete() {	
		CommodityObj commodityobj = new CommodityObj();
		if("Admin".equals(Ur)) {
			JOptionPane.showMessageDialog(this, commodityobj.deletecommodity("Admin", textField.getText()));
		}else {
			JOptionPane.showMessageDialog(this, commodityobj.deletecommodity(Ur, textField.getText()));
		}
	}
}
