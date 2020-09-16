package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import AccessObj.AdminObj;
import AccessObj.UserObj;
import AccessObj.BussinessObj;
import model.Admin;
import model.User;
import model.Bussiness;
import model.usertype;
import mytools.StrTools;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class First {

	private JFrame frmbySensorjang;
	private JTextField accountTextField;
	private JTextField passwordTextField;
	private JComboBox usertypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.frmbySensorjang.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmbySensorjang = new JFrame();
		frmbySensorjang.setTitle("\u767B\u5F55\uFF08by Sensorjang\uFF09");
		frmbySensorjang.setBounds(100, 100, 601, 389);
		frmbySensorjang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmbySensorjang.getContentPane().setLayout(null);
		frmbySensorjang.setLocationRelativeTo(null);                             //���ھ���
		
		JLabel lblNewLabel = new JLabel("Account\uFF1A");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		lblNewLabel.setBounds(55, 114, 154, 46);
		frmbySensorjang.getContentPane().add(lblNewLabel);
		
		JLabel lblPasswod = new JLabel("Passwod\uFF1A");
		lblPasswod.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		lblPasswod.setBounds(55, 173, 154, 46);
		frmbySensorjang.getContentPane().add(lblPasswod);
		
		accountTextField = new JTextField();                          //�˻���TextField
		accountTextField.setBounds(156, 124, 184, 27);
		frmbySensorjang.getContentPane().add(accountTextField);
		accountTextField.setColumns(10);
		
		passwordTextField = new JTextField();                      //����TextField
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(156, 184, 184, 27);
		frmbySensorjang.getContentPane().add(passwordTextField);
		
		usertypeComboBox = new JComboBox();                  //�û����͸�ѡ��
		usertypeComboBox.setModel(new DefaultComboBoxModel(new usertype[] {usertype.ADMIN,usertype.BUSSINESS,usertype.USER}));         //ö�ٺ���usertype
		usertypeComboBox.setToolTipText("");
		usertypeComboBox.setBounds(156, 250, 184, 27);
		frmbySensorjang.getContentPane().add(usertypeComboBox);
		
		JLabel lblPasswod_1 = new JLabel("\u8EAB\u4EFD\uFF1A");         
		lblPasswod_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		lblPasswod_1.setBounds(55, 237, 154, 51);
		frmbySensorjang.getContentPane().add(lblPasswod_1);
		
		JButton loginBtnNewButton = new JButton("\u767B\u5F55");             //��¼��ť
		loginBtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginact();
			}
		});
		loginBtnNewButton.setBounds(412, 271, 129, 46);
		frmbySensorjang.getContentPane().add(loginBtnNewButton);
		
		JButton registerBtnNewButton_1 = new JButton("\u6CE8\u518C");          //ע�ᰴť
		registerBtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registeract();
			}
		});
		registerBtnNewButton_1.setBounds(412, 211, 129, 46);
		frmbySensorjang.getContentPane().add(registerBtnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u7C97\u5236\u6EE5\u9020\u767B\u9646\u754C\u9762");
		lblNewLabel_1.setFont(new Font("�����п�", Font.PLAIN, 41));
		lblNewLabel_1.setBounds(129, 21, 388, 76);
		frmbySensorjang.getContentPane().add(lblNewLabel_1);
		
		JButton resetBtnNewButton_1_1 = new JButton("\u91CD\u7F6E");
		resetBtnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		resetBtnNewButton_1_1.setBounds(412, 151, 129, 46);
		frmbySensorjang.getContentPane().add(resetBtnNewButton_1_1);
	}
 
	protected void registeract() {
		// TODO Auto-generated method stub
		register reg= new register();
		reg.main();;
	}

	protected void loginact() {                                          //��¼��Ϊ
		// TODO Auto-generated method stub
		String account=accountTextField.getText().toString();         
		String password=passwordTextField.getText().toString();	
		usertype selecteditem=(usertype)usertypeComboBox.getSelectedItem();
		if(StrTools.IsEmpty(account))
		{
			JOptionPane.showMessageDialog(frmbySensorjang, "�û�������Ϊ�գ�");                 //�ж��û��������Ƿ�Ϊ��
			return;
		}
		if(StrTools.IsEmpty(password))
		{
			JOptionPane.showMessageDialog(frmbySensorjang, "���벻��Ϊ�գ�");
			return;
		}
		Admin adminout=null;
		if("����Ա".equals(selecteditem.getName()))
		{
			//log in Administrator
			
			AdminObj adminobj= new AdminObj();
			Admin adminin= new Admin();
			adminin.setAccount(accountTextField.getText());
			adminin.setPassword(passwordTextField.getText());
			adminout=adminobj.login(adminin);
			if(adminout==null)
			{
				JOptionPane.showMessageDialog(frmbySensorjang, "�û������������");
				return;
			}
			frmbySensorjang.dispose();                                                           //���ش���
			JOptionPane.showMessageDialog(frmbySensorjang, "��ӭ��"+selecteditem.getName()+"��:��"+adminout.getAccount()+"����½��ϵͳ��");    //��ӭ����
			new admin_main(selecteditem,adminout).setVisible(true);
				
				//admin_main����
		}else if("�̼�".equals(selecteditem.getName()))
		{
			//log in Bussiness

			BussinessObj bussinessobj= new BussinessObj();
			Bussiness bussinessin= new Bussiness();
			bussinessin.setAccount(accountTextField.getText());
			bussinessin.setPassword(passwordTextField.getText());
			Bussiness bussinessout=bussinessobj.login(bussinessin);
			if(bussinessout==null)
			{
				JOptionPane.showMessageDialog(frmbySensorjang, "�û������������");
				return;
			}
			frmbySensorjang.dispose();                                                           //���ش���
			JOptionPane.showMessageDialog(frmbySensorjang, "��ӭ��"+selecteditem.getName()+"��:��"+bussinessout.getAccount()+"����½��ϵͳ��");    //��ӭ����
			new bussiness_main(selecteditem,bussinessout).setVisible(true);
				
				//bussiness_main����
				
		}else if("�û�".equals(selecteditem.getName()))
		{
			//log in User

			UserObj userobj= new UserObj();
			User userin= new User();
			userin.setAccount(accountTextField.getText());
			userin.setPassword(passwordTextField.getText());
			User userout=userobj.login(userin);
			if(userout==null)
			{
				JOptionPane.showMessageDialog(frmbySensorjang, "�û������������");
				return;
			}
			frmbySensorjang.dispose();                                                           //���ش���
			JOptionPane.showMessageDialog(frmbySensorjang, "��ӭ��"+selecteditem.getName()+"��:��"+userout.getAccount()+"����½��ϵͳ��");    //��ӭ����
			new user_main(selecteditem,userout).setVisible(true);
				
			    //user_main����
		}	
	}
	protected void reset() {
		// TODO Auto-generated method stub
		accountTextField.setText("");
		passwordTextField.setText("");
		usertypeComboBox.setSelectedIndex(0);
	}
}
