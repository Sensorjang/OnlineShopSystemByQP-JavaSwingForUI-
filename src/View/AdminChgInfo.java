package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import AccessObj.AdminObj;
import model.Admin;
import model.Info;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminChgInfo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Info readinfo;
	private Admin admin= (Admin)admin_main.adminobject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminChgInfo frame = new AdminChgInfo();
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
	public AdminChgInfo() {
		
		//÷¥––read–≈œ¢≤Ÿ◊˜
		AdminObj adminobj= new AdminObj();
		//System.out.println(admin.getAccount());           µ˜ ‘”Ôæ‰
		readinfo= adminobj.readinfo(admin.getAccount());              //readinfo”√¿¥¥Ú”°
		
		setClosable(true);
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setBounds(100, 100, 734, 522);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		lblNewLabel.setBounds(63, 70, 113, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(63, 121, 113, 35);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(63, 176, 113, 35);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(63, 227, 113, 44);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		lblNewLabel_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(63, 281, 113, 44);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminObj adminobj= new AdminObj();
				JOptionPane.showMessageDialog(null,adminobj.writeinfo(admin.getAccount(),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText()));
			}
		});
		btnNewButton.setBounds(115, 388, 188, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(398, 388, 188, 50);
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField(readinfo.getName());
		textField.setBounds(174, 75, 301, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(readinfo.getAge());
		textField_1.setColumns(10);
		textField_1.setBounds(174, 126, 301, 30);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField(readinfo.getGender());
		textField_2.setColumns(10);
		textField_2.setBounds(174, 178, 301, 30);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField(readinfo.getTel());
		textField_3.setColumns(10);
		textField_3.setBounds(174, 236, 301, 30);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField(readinfo.getEmail());
		textField_4.setColumns(10);
		textField_4.setBounds(174, 291, 301, 30);
		getContentPane().add(textField_4);
		
	}
}
