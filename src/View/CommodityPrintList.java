package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import AccessObj.CommodityObj;
import AccessObj.UserMagObj;
import model.Commodity;
import model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommodityPrintList extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommodityPrintList frame = new CommodityPrintList();
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
	public CommodityPrintList() {
		setClosable(true);
		setTitle("\u5546\u54C1\u5217\u8868");
		setBounds(100, 100, 886, 596);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(117, 44, 54, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(300, 44, 54, 31);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(181, 48, 109, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(364, 48, 192, 28);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                       //查询操作
				print(textField.getText(),textField_1.getText());
			}
		});
		btnNewButton.setBounds(646, 46, 109, 31);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 127, 714, 382);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5E93\u5B58\u6570\u91CF", "\u5355\u4EF7", "\u5546\u54C1\u63CF\u8FF0", "\u53D1\u5E03\u5546\u5BB6"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		print("","");               //初始化 显示整表

	}
	public void print(String no,String name) {
		DefaultTableModel def = (DefaultTableModel) table.getModel();
		def.setRowCount(0);
		CommodityObj commodityobj = new CommodityObj();
		List<Commodity> ls = commodityobj.admingetcommoditylist(no,name);
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
