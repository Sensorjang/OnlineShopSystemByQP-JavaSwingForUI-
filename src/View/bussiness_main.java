package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.SystemColor;
import java.awt.BorderLayout;
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
import AccessObj.BussinessObj;
import model.Bussiness;
import model.User;
import model.usertype;
import javax.swing.JDesktopPane;
import java.awt.Font;

public class bussiness_main {

	private JFrame bussiness_frame;
	public static usertype usertype;
	public static Object bussinessobject;
	private static JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bussiness_main window = new bussiness_main();
					window.bussiness_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */

	public static void addframe(JInternalFrame A) {
		desktopPane.add(A);
	}
	
	/** 
	 * Create the application.
	 */
	public bussiness_main(usertype usertype,Object bussinessobject) {                //重写构造函数
		this.usertype=usertype;
		this.bussinessobject=bussinessobject;
		initialize();
	}
	public void setVisible(boolean y) {                             //setvisible操作
		bussiness_frame.setVisible(y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Bussiness bussiness = (Bussiness)bussinessobject;
		BalanceObj balanceobj = new BalanceObj();
		
		bussiness_frame = new JFrame();
		bussiness_frame.getContentPane().setBackground(SystemColor.activeCaption);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		bussiness_frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF  made by.Sensorjang \u8F6F\u4EF61902\u7941\u76FC");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(81, 183, 957, 230);
		desktopPane.add(lblNewLabel_1);
		bussiness_frame.setBackground(SystemColor.window);
		bussiness_frame.setTitle("\u5546\u54C1\u4EA4\u6613\u7CFB\u7EDF \u5546\u6237\u7EC8\u7AEF");
		bussiness_frame.setBounds(100, 100, 1047, 682);                                     //相同大小
		bussiness_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bussiness_frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		bussiness_frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem.addActionListener(new ActionListener() {                          //修改信息
			public void actionPerformed(ActionEvent arg0) {
				BussinessChgInfo chginfo= new BussinessChgInfo();
				chginfo.setVisible(true);
				desktopPane.add(chginfo);
				chginfo.moveToFront();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {                         //修改密码
			public void actionPerformed(ActionEvent e) {
				chgpassword(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u8D26\u6237\u6CE8\u9500");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {                          //注销操作
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(bussiness_frame, "【警告：不可恢复的操作！】\n注销账号将导致您的账户永久消失\n请在这之前保证您的账户重要资料清空或转移！")== JOptionPane.OK_OPTION) {
					if(JOptionPane.showConfirmDialog(bussiness_frame, "\"【请再次确认：将执行注销账户操作！】\n此操作不可恢复！\"")== JOptionPane.OK_OPTION) {
						cancellation();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6211\u7684\u5546\u54C1");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {                          //我的商品
			public void actionPerformed(ActionEvent arg0) {
				Bussiness bussiness = (Bussiness) bussinessobject;
				MyCommodityBuss mycommoditybuss = new MyCommodityBuss(bussiness.getAccount());
				mycommoditybuss.setVisible(true);
				desktopPane.add(mycommoditybuss);
				mycommoditybuss.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5E73\u53F0\u5546\u54C1");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                             //显示平台全部商品
				CommodityPrintList commodityprintlist = new CommodityPrintList();
				commodityprintlist.setVisible(true);
				desktopPane.add(commodityprintlist);
				commodityprintlist.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4FEE\u6539\u63CF\u8FF0");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {                           //修改描述
			public void actionPerformed(ActionEvent e) {
				Bussiness bussiness = (Bussiness)bussinessobject;
				ChgDesc chgdesc =new ChgDesc(bussiness.getAccount());
				chgdesc.setVisible(true);
				desktopPane.add(chgdesc);	
				chgdesc.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u4FEE\u6539\u4EF7\u683C");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {                            //修改价格
			public void actionPerformed(ActionEvent e) {
				Bussiness bussiness = (Bussiness)bussinessobject;
				ChgPrice chgprice =new ChgPrice(bussiness.getAccount());
				chgprice.setVisible(true);
				desktopPane.add(chgprice);	
				chgprice.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u4FEE\u6539\u6570\u91CF");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {                          //修改数量
			public void actionPerformed(ActionEvent e) {
				Bussiness bussiness = (Bussiness)bussinessobject;
				ChgNum chgnum =new ChgNum(bussiness.getAccount());
				chgnum.setVisible(true);
				desktopPane.add(chgnum);	
				chgnum.moveToFront();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JButton btnNewButton_1 = new JButton("\u5546\u54C1\u4E0A\u67B6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                     //上架商品
				PutOnCommodity putoncommodity = new PutOnCommodity();
				Bussiness bussiness = (Bussiness)bussinessobject;
				putoncommodity.setAcc(bussiness.getAccount());
				putoncommodity.setVisible(true);
				desktopPane.add(putoncommodity);
				putoncommodity.moveToFront();
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5546\u54C1\u4E0B\u67B6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                       //下架商品
				DeleteCommodity deletecommodity = new DeleteCommodity();
				Bussiness bussiness = (Bussiness)bussinessobject;
				deletecommodity.setUr(bussiness.getAccount());
				deletecommodity.setVisible(true);
				desktopPane.add(deletecommodity);
				deletecommodity.moveToFront();
			}
		});
		menuBar.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("                                                                                                      ");
		menuBar.add(lblNewLabel_3);
		
		JMenu mnNewMenu_4 = new JMenu("   \u5E2E\u52A9    ");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u5173\u4E8E\u5F00\u53D1\u8005");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {         //关于我们
			public void actionPerformed(ActionEvent arg0) {
				AboutUs(arg0);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JLabel lblNewLabel = new JLabel("\u94B1\u5305\u4F59\u989D\uFF1A");
		menuBar.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(balanceobj.readbalance("Bussiness", bussiness.getAccount()));
		menuBar.add(lblNewLabel_2);                                                       //显示余额
		
		JButton btnNewButton_3 = new JButton("\u91D1\u989D\u5145\u503C");
		btnNewButton_3.addActionListener(new ActionListener() {                           //充值操作
			public void actionPerformed(ActionEvent arg0) {
				Bussiness bissiness = (Bussiness)bussinessobject;
				Recharge recharge = new Recharge("Bussiness",bussiness.getAccount());
				recharge.setVisible(true);
				desktopPane.add(recharge);
				recharge.moveToFront();
			}
		});
		
		JButton btnNewButton_4 = new JButton("\u91D1\u989D\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {                             //金额刷新
			public void actionPerformed(ActionEvent e) {
				Bussiness bissiness = (Bussiness)bussinessobject;
				BalanceObj balanceobj = new BalanceObj();
				lblNewLabel_2.setText(balanceobj.readbalance("Bussiness", bussiness.getAccount()));
			}
		});
		menuBar.add(btnNewButton_4);
		menuBar.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {           //退出系统
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(bussiness_frame,"确定退出么?") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBar.add(btnNewButton);
	}

	protected void cancellation() {
		// TODO Auto-generated method stub
		
		Bussiness bussiness= (Bussiness)bussinessobject;
		BussinessObj bussinessobj=new BussinessObj();
		JOptionPane.showMessageDialog(null, bussinessobj.deletebussiness(bussiness.getAccount()));
	}
	protected void chgpassword(ActionEvent e) {                 //修改密码
		// TODO Auto-generated method stub
		
		new ChangePasswordFrm('B').setVisible(true);
	}
	protected void AboutUs(ActionEvent arg0) {                    //关于我们弹窗
		// TODO Auto-generated method stub
		
		String pri="【Made by。Sensorjang（软件1902祁盼）】\n";
		pri += "我的邮箱：515310624@qq。com\n";
		pri +="我要进领航后台组！\n";
		String[] buttons= {"确认","访问网站（没）"};
		JOptionPane.showOptionDialog(bussiness_frame , pri, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, buttons, null);
	}
}
