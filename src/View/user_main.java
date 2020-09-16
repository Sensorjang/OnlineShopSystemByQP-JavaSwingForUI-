package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AccessObj.BalanceObj;
import AccessObj.UserObj;
import model.User;
import model.usertype;

import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Font;

public class user_main {

	private JFrame user_frame;
	public static usertype usertype;
	public static Object userobject;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_main window = new user_main();
					window.user_frame.setVisible(true);
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
	public user_main(usertype usertype,Object userobject) {                //��д���캯��
		this.usertype=usertype;
		this.userobject=userobject;
		initialize();
	}
	public void setVisible(boolean y) {                             //setvisible����
		user_frame.setVisible(y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		User user = (User)userobject;
		BalanceObj balanceobj = new BalanceObj();
		
		user_frame = new JFrame();
		user_frame.getContentPane().setBackground(SystemColor.info);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.info);
		user_frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblMadeBysensorjang = new JLabel("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF  made by.Sensorjang \u8F6F\u4EF61902\u7941\u76FC");
		lblMadeBysensorjang.setFont(new Font("��Բ", Font.PLAIN, 35));
		lblMadeBysensorjang.setBounds(90, 193, 957, 230);
		desktopPane.add(lblMadeBysensorjang);
		user_frame.setTitle("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF \u4E2A\u4EBA\u7EC8\u7AEF");
		user_frame.setBounds(100, 100, 1047, 682);                                  //��ͬ��С
		user_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		user_frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		user_frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem.addActionListener(new ActionListener() {                             //�޸���Ϣ
			public void actionPerformed(ActionEvent arg0) {
				UserChgInfo chginfo= new UserChgInfo();
				chginfo.setVisible(true);
				desktopPane.add(chginfo);
				chginfo.moveToFront();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {                             //�޸�����
			public void actionPerformed(ActionEvent e) {
				chgpassword(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u8D26\u6237\u6CE8\u9500");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {                       //ע������
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(user_frame, "�����棺���ɻָ��Ĳ�������\nע���˺Ž����������˻�������ʧ\n������֮ǰ��֤�����˻���Ҫ������ջ�ת�ƣ�")== JOptionPane.OK_OPTION) {
					if(JOptionPane.showConfirmDialog(user_frame, "\"�����ٴ�ȷ�ϣ���ִ��ע���˻���������\n�˲������ɻָ���\"")== JOptionPane.OK_OPTION) {
						cancellation();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_4 = new JMenu("   \u5E2E\u52A9    ");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u5173\u4E8E\u5F00\u53D1\u8005");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {                     //��������
			public void actionPerformed(ActionEvent arg0) {
				AboutUs(arg0);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JButton btnNewButton_2 = new JButton("\u5546\u54C1\u5217\u8868");
		btnNewButton_2.addActionListener(new ActionListener() {                           //��Ʒ�б�
			public void actionPerformed(ActionEvent e) {
				CommodityPrintList commodityprintlist = new CommodityPrintList();
				commodityprintlist.setVisible(true);
				desktopPane.add(commodityprintlist);
				commodityprintlist.moveToFront();
			}
		});
		menuBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8D2D\u7269\u8F66");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
				User user = (User)userobject;                                             //���ﳵ
				ShoppingCart shoppingcart= new ShoppingCart(user.getAccount());
				shoppingcart.setVisible(true);
				desktopPane.add(shoppingcart);
				shoppingcart.moveToFront();
			}
		});
		menuBar.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("                                                                                                                           ");
		menuBar.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u6237\u91D1\u989D\uFF1A"); 
		menuBar.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(balanceobj.readbalance("User", user.getAccount()));
		menuBar.add(lblNewLabel_1);                                                       //��ʾ���
		
		JButton btnNewButton_1 = new JButton("\u91D1\u989D\u5145\u503C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                 //��ֵ����
				User user = (User)userobject;
				Recharge recharge = new Recharge("User",user.getAccount());
				recharge.setVisible(true);
				desktopPane.add(recharge);
				recharge.moveToFront();
			}
		});
		
		JButton btnNewButton_4 = new JButton("\u91D1\u989D\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {                         //���ˢ��
			public void actionPerformed(ActionEvent e) {
				BalanceObj balanceobj = new BalanceObj();
				User user = (User)userobject;
				lblNewLabel_1.setText(balanceobj.readbalance("User", user.getAccount()));
			}
		});
		menuBar.add(btnNewButton_4);
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {                        //�˳�ϵͳ
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(user_frame,"ȷ���˳�ô?") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBar.add(btnNewButton);
	}

	protected void cancellation() {
		// TODO Auto-generated method stub
		User user = (User)userobject;
		UserObj userobj=new UserObj();
		JOptionPane.showMessageDialog(null, userobj.deleteuser(user.getAccount()));
	}
	protected void chgpassword(ActionEvent e) {                     //�޸�����
		// TODO Auto-generated method stub

		new ChangePasswordFrm('U').setVisible(true);
	}
	
	protected void AboutUs(ActionEvent arg0) {                    //�������ǵ���
		// TODO Auto-generated method stub
		
		String pri="��Made by��Sensorjang�����1902���Σ���\n";
		pri += "�ҵ����䣺515310624@qq��com\n";
		pri +="��Ҫ���캽��̨�飡\n";
		String[] buttons= {"ȷ��","������վ��û��"};
		JOptionPane.showOptionDialog(user_frame , pri, "��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, buttons, null);
	}
}
