package View;

import java.awt.EventQueue;
import model.Admin;
import model.Bussiness;
import model.User;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import AccessObj.AdminObj;
import AccessObj.BussinessObj;
import AccessObj.UserObj;
import model.usertype;
import mytools.StrTools;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordFrm {

	private JFrame chgframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private char ch;

	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordFrm window = new ChangePasswordFrm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */

	/**
	 * Create the application.
	 */
	public ChangePasswordFrm(char ch) {
		this.ch=ch;
		initialize();
	}
	public void setVisible(boolean y) {                   //重写setVisible函数
		chgframe.setVisible(y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chgframe = new JFrame();
		chgframe.setTitle("\u4FEE\u6539\u5BC6\u7801");
		chgframe.setBounds(100, 100, 450, 300);
		chgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		chgframe.getContentPane().setLayout(null);
		chgframe.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel.setBounds(23, 60, 67, 15);
		chgframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(23, 103, 67, 15);
		chgframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(23, 144, 67, 15);
		chgframe.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(100, 57, 193, 21);
		chgframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 100, 193, 21);
		chgframe.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 141, 193, 21);
		chgframe.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnNewButton.setBounds(153, 202, 93, 23);
		chgframe.getContentPane().add(btnNewButton);
		
		
	}
	protected void edit() {
		// TODO Auto-generated method stub
		
		String pwd1=textField.getText().toString();
		String pwd2=textField_1.getText().toString();
		String pwd3=textField_2.getText().toString();
		if(StrTools.IsEmpty(pwd1)) {
			JOptionPane.showMessageDialog(chgframe, "原密码不能为空！");
			return ;
		}
		if(StrTools.IsEmpty(pwd2)) {
			JOptionPane.showMessageDialog(chgframe, "新密码不能为空！");
			return ;
		}
		if(StrTools.IsEmpty(pwd3)) {
			JOptionPane.showMessageDialog(chgframe, "请确认密码！");
			return ;
		}
		if(!pwd2.equals(pwd3)) {
			JOptionPane.showMessageDialog(chgframe, "两次密码输入不一致！");
			return ;
		}
		
		if(this.ch == 'A'){
			AdminObj adminobj=new AdminObj();
			JOptionPane.showMessageDialog(chgframe, adminobj.editpwd((Admin)admin_main.adminobject,pwd2,pwd1));
			return ;
		}else if(this.ch == 'B'){
			System.out.println("B");
			BussinessObj bussinessobj=new BussinessObj();
			JOptionPane.showMessageDialog(chgframe, bussinessobj.editpwd((Bussiness)bussiness_main.bussinessobject,pwd2,pwd1));
			return ;
		}else if(this.ch == 'U'){
			System.out.println("C");
			UserObj userobj=new UserObj();
			JOptionPane.showMessageDialog(chgframe, userobj.editpwd((User)user_main.userobject,pwd2,pwd1));
			return ;
		}
		
		
	}
			
		
}
