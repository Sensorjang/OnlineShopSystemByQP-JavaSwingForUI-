package View;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import AccessObj.BussinessObj;
import AccessObj.CommodityObj;
import model.Bussiness;
import model.Commodity;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyCommodityBuss extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table; 
	private String acc;

	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCommodityBuss frame = new MyCommodityBuss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */

	/**
	 * Create the frame.
	 */
	public MyCommodityBuss(String acc) {
		
		this.acc=acc;
		
		setTitle("\u6211\u7684\u5546\u54C1");
		setClosable(true);
		setBounds(100, 100, 927, 584);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u4E0A\u67B6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                  //上架  按钮
				PutOnCommodity putoncommodity = new PutOnCommodity();
				putoncommodity.setAcc(acc);
				putoncommodity.setVisible(true);
				bussiness_main.addframe(putoncommodity);
				putoncommodity.moveToFront();
			}
		});
		btnNewButton.setBounds(35, 23, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u67B6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                   //下架  按钮
				DeleteCommodity deletecommodity = new DeleteCommodity();
				deletecommodity.setUr(acc);
				deletecommodity.setVisible(true);
				bussiness_main.addframe(deletecommodity);
				deletecommodity.moveToFront();
			}
		});
		btnNewButton_1.setBounds(148, 23, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                 //退出 按钮
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(763, 23, 93, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(49, 89, 79, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(278, 89, 79, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(113, 86, 128, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(345, 86, 220, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u627E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                  //查找
				print(textField.getText(),textField_1.getText());
			}
		});
		btnNewButton_3.setBounds(623, 85, 93, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                 //刷新
				print(textField.getText(),textField_1.getText());
			}
		});
		btnNewButton_4.setBounds(734, 85, 93, 23);
		getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 161, 775, 332);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u5E93\u5B58", "\u5546\u54C1\u5355\u4EF7", "\u5546\u54C1\u63CF\u8FF0", "\u53D1\u5E03\u8005"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setPreferredWidth(220);
		scrollPane.setViewportView(table);
		
		print("","");

	}
	
	public void print(String no,String name) {
		DefaultTableModel def = (DefaultTableModel) table.getModel();
		def.setRowCount(0);
		CommodityObj commodityobj = new CommodityObj();
		List<Commodity> ls = commodityobj.mycommodity(this.acc,no,name);
		for(Commodity Uu : ls) {
			Vector v = new Vector();
			v.add(Uu.getNo());
			v.add(Uu.getName());
			v.add(Uu.getStock());
			v.add(Uu.getPrice());
			v.add(Uu.getDescribeit());
			v.add(Uu.getPublisher());
			def.addRow(v);
		}
	}
}
