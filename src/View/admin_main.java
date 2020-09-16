package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import AccessObj.AdminObj;
import AccessObj.UserObj;
import model.Admin;
import model.usertype;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;

public class admin_main {
	private JFrame admin_frame;
	public static usertype usertype;
	public static Object adminobject;
	private JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_main window = new admin_main();
					window.admin_frame.setVisible(true);
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
	public admin_main(usertype usertype,Object adminobject) {                //重写构造函数
		this.usertype=usertype;
		this.adminobject=adminobject;
		initialize();
	}
	
	public void setVisible(boolean y) {                             //setvisible操作
		admin_frame.setVisible(y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		admin_frame = new JFrame();
		admin_frame.getContentPane().setBackground(SystemColor.textHighlight);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.textHighlight);
		admin_frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF  made by.Sensorjang \u8F6F\u4EF61902\u7941\u76FC");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 35));
		lblNewLabel.setBounds(83, 172, 957, 230);
		desktopPane.add(lblNewLabel);
		admin_frame.setTitle("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF \u7BA1\u7406\u5458\u63A7\u5236\u53F0");
		admin_frame.setBounds(100, 100, 1047, 682);                                            //相同大小
		admin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admin_frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.window);
		admin_frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                             //修改信息
				AdminChgInfo chginfo= new AdminChgInfo();
				chginfo.setVisible(true);
				desktopPane.add(chginfo);
				chginfo.moveToFront();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {                         //修改密码
			public void actionPerformed(ActionEvent e) {
				chgpassword(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u8D26\u6237\u6CE8\u9500");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {                    //注销账户
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(admin_frame, "【警告：不可恢复的操作！】\n注销账号将导致您的账户永久消失\n请在这之前保证您的账户重要资料清空或转移！")== JOptionPane.OK_OPTION) {
					if(JOptionPane.showConfirmDialog(admin_frame, "【请再次确认：将执行注销账户操作！】\n此操作不可恢复！")== JOptionPane.OK_OPTION) {
						cancellation();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5546\u54C1\u5217\u8868");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                           //商品列表
				CommodityPrintList commodityprintlist = new CommodityPrintList();
				commodityprintlist.setVisible(true);
				desktopPane.add(commodityprintlist);
				commodityprintlist.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5F3A\u5236\u4E0B\u67B6");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                            //商品删除
				DeleteCommodity deletecommodity = new DeleteCommodity();
				deletecommodity.setUr("Admin");
				deletecommodity.setVisible(true);
				desktopPane.add(deletecommodity);
				deletecommodity.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5546\u54C1\u67E5\u627E");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                               //商品查找
				CommodityPrintList commodityprintlist = new CommodityPrintList();
				commodityprintlist.setVisible(true);
				desktopPane.add(commodityprintlist);
				commodityprintlist.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u7528\u6237\u5217\u8868");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                      //用户列表
				UserList userlist= new UserList();
				userlist.setVisible(true);
				desktopPane.add(userlist);
				userlist.moveToFront();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7528\u6237\u5220\u9664");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {                                //用户删除
			public void actionPerformed(ActionEvent arg0) {
				DeleteUser deleteuser = new DeleteUser();
				deleteuser.setVisible(true);
				desktopPane.add(deleteuser);
				deleteuser.moveToFront();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7528\u6237\u67E5\u627E");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserList userlist= new UserList();                                            //用户查找
				userlist.setVisible(true);
				desktopPane.add(userlist);
				userlist.moveToFront();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u5546\u5BB6\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5546\u5BB6\u5217\u8868");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BussinessList bussinesslist = new BussinessList();                              //商家列表
				bussinesslist.setVisible(true);
				desktopPane.add(bussinesslist);
				bussinesslist.moveToFront();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5546\u5BB6\u5220\u9664");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {                               //商家删除
			
			public void actionPerformed(ActionEvent e) {
				DeleteBussiness deletebussiness= new DeleteBussiness();
				deletebussiness.setVisible(true);
				desktopPane.add(deletebussiness);
				deletebussiness.moveToFront();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5546\u5BB6\u67E5\u627E");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BussinessList bussinesslist = new BussinessList();                              //商家查找
				bussinesslist.setVisible(true);
				desktopPane.add(bussinesslist);
				bussinesslist.moveToFront();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("   \u5E2E\u52A9    ");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u5173\u4E8E\u5F00\u53D1\u8005");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                    //关于我们
				AboutUs(arg0);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");            //退出系统
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(admin_frame,"确定退出么?") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBar.add(btnNewButton);
		
	}

	protected void cancellation() {                    //注销操作
		// TODO Auto-generated method stub
		Admin admin = (Admin)adminobject;
		AdminObj adminobj=new AdminObj();
		JOptionPane.showMessageDialog(null, adminobj.deleteadmin(admin.getAccount()));
	}

	protected void chgpassword(ActionEvent e) {                   //修改密码
		// TODO Auto-generated method stub
		
		new ChangePasswordFrm('A').setVisible(true);
		
	}
	protected void AboutUs(ActionEvent arg0) {                    //关于我们弹窗
		// TODO Auto-generated method stub
		
		String pri="【Made by。Sensorjang（软件1902祁盼）】\n";
		pri += "我的邮箱：515310624@qq。com\n";
		pri +="我要进领航后台组！\n";
		String[] buttons= {"确认","访问网站（没）"};
		JOptionPane.showOptionDialog(admin_frame , pri, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, buttons, null);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
