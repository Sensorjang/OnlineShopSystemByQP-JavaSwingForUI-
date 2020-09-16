package View;

import java.awt.EventQueue;

import model.Admin;
import model.Bussiness;
import model.User;
import model.registertype;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.AdminObj;
import AccessObj.BussinessObj;
import AccessObj.UserObj;
import model.registertype;
import model.usertype;
import mytools.StrTools;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register {

	private JFrame frmbySensorjangreg;
	private JTextField accountTextField;
	private JTextField passwordTextField;
	private JComboBox registertypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frmbySensorjangreg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmbySensorjangreg = new JFrame();
		frmbySensorjangreg.setTitle("\u6CE8\u518C\uFF08by Sensorjang\uFF09");
		frmbySensorjangreg.setBounds(100, 100, 526, 354);
		frmbySensorjangreg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmbySensorjangreg.getContentPane().setLayout(null);
		frmbySensorjangreg.setLocationRelativeTo(null);   
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 43));
		lblNewLabel.setBounds(219, 16, 107, 53);
		frmbySensorjangreg.getContentPane().add(lblNewLabel);
		
		accountTextField = new JTextField();
		accountTextField.setBounds(118, 103, 156, 21);
		frmbySensorjangreg.getContentPane().add(accountTextField);
		accountTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(117, 150, 156, 21);
		frmbySensorjangreg.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		registertypeComboBox = new JComboBox();
		registertypeComboBox.setModel(new DefaultComboBoxModel(new registertype[] {registertype.BUSSINESS,registertype.USER}));         //枚举注册类型
		registertypeComboBox.setBounds(118, 199, 156, 21);
		frmbySensorjangreg.getContentPane().add(registertypeComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("account\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 106, 77, 15);
		frmbySensorjangreg.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(31, 152, 76, 15);
		frmbySensorjangreg.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("user type\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(31, 200, 77, 15);
		frmbySensorjangreg.getContentPane().add(lblNewLabel_3);
		
		JButton regBtnNewButton = new JButton("\u6CE8\u518C");
		regBtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account=accountTextField.getText().toString();         
				String password=passwordTextField.getText().toString();	
				registertype selecteditemreg = (registertype) registertypeComboBox.getSelectedItem();
				if(StrTools.IsEmpty(account))
				{
					JOptionPane.showMessageDialog(frmbySensorjangreg, "用户名不能为空！");                 //判断用户名密码是否为空
					return;
				}
				if(StrTools.IsEmpty(password))
				{
					JOptionPane.showMessageDialog(frmbySensorjangreg, "密码不能为空！");
					return;
				}
				if("商家".equals(selecteditemreg.getName()))
				{
					//注册 商家
					
					BussinessObj bussinessobj= new BussinessObj();
					Bussiness bussinessin= new Bussiness();
					bussinessin.setAccount(accountTextField.getText());
					bussinessin.setPassword(passwordTextField.getText());
					if(bussinessobj.register(bussinessin)==true) {
						JOptionPane.showMessageDialog(frmbySensorjangreg, "注册成功！");
					}else {
						JOptionPane.showMessageDialog(frmbySensorjangreg, "注册出错！");
					}
				}else if("用户".equals(selecteditemreg.getName())){
					//注册 用户
					
					UserObj userobj= new UserObj();
					User userin= new User();
					userin.setAccount(accountTextField.getText());
					userin.setPassword(passwordTextField.getText());
					if(userobj.register(userin)==true) {
						JOptionPane.showMessageDialog(frmbySensorjangreg, "注册成功！");
					}else {
						JOptionPane.showMessageDialog(frmbySensorjangreg, "注册出错！");
					}
				}
				
			}
		});
		regBtnNewButton.setBounds(282, 241, 140, 41);
		frmbySensorjangreg.getContentPane().add(regBtnNewButton);
	}
}
