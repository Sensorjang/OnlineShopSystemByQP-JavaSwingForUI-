package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import AccessObj.BalanceObj;
import AccessObj.CommodityObj;
import AccessObj.ShoppingCartObj;
import model.Bussiness;
import model.Commodity;
import model.ShoppingCartMod;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class ShoppingCart extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCart frame = new ShoppingCart("");
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
	public ShoppingCart(String acc) {
		setTitle("\u6211\u7684\u8D2D\u7269\u8F66");
		setClosable(true);
		setBounds(100, 100, 772, 492);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 43, 80, 32);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 43, 171, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5546\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                //添加商品
				comadd(Integer.parseInt(textField.getText()),acc);
				ShoppingCartObj shoppingcartobj= new ShoppingCartObj(); //刷新
				print(acc);
				lblNewLabel_1.setText("\u5408\u8BA1\uFF1A"+shoppingcartobj.total(acc)+"   \u5143");
			}
		});
		btnNewButton.setBounds(337, 43, 100, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u5546\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {                           //删除商品
			public void actionPerformed(ActionEvent e) {
				ShoppingCartObj shoppingcartobj= new ShoppingCartObj();
				System.out.println(shoppingcartobj.delete(Integer.parseInt(textField.getText()),acc));
				print(acc);                                 //刷新
				lblNewLabel_1.setText("\u5408\u8BA1\uFF1A"+shoppingcartobj.total(acc)+"   \u5143");
			}
		});
		btnNewButton_1.setBounds(456, 43, 100, 32);
		getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 102, 611, 254);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u5355\u4EF7", "\u53D1\u5E03\u8005"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(145);
		table.getColumnModel().getColumn(3).setPreferredWidth(164);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton_2 = new JButton("\u786E\u5B9A\u4E0B\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {                         //确定下单
			public void actionPerformed(ActionEvent e) {
				ShoppingCartObj shoppingcartobj= new ShoppingCartObj(); 
				BalanceObj balanceobj = new BalanceObj();
				JOptionPane.showMessageDialog(null, balanceobj.recharge("User", acc, 0-(shoppingcartobj.total(acc))));
				shoppingcartobj.bussin(acc);
			}
			
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(576, 380, 132, 56);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("\u5237\u65B0");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				ShoppingCartObj shoppingcartobj= new ShoppingCartObj(); //刷新
				print(acc);
				lblNewLabel_1.setText("\u5408\u8BA1\uFF1A"+shoppingcartobj.total(acc)+"   \u5143");
			}
		});
		btnNewButton_1_1.setBounds(649, 103, 100, 32);
		getContentPane().add(btnNewButton_1_1);
		
		                       //显示合计价格
		ShoppingCartObj shoppingcartobj= new ShoppingCartObj(); 
		lblNewLabel_1 = new JLabel("\u5408\u8BA1\uFF1A"+shoppingcartobj.total(acc)+"   \u5143");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(122, 387, 229, 48);
		getContentPane().add(lblNewLabel_1);
		
		print(acc);

	}
	
	void comadd(int no,String acc) {
		
		ShoppingCartObj shoppingcartobj= new ShoppingCartObj();
		System.out.println(shoppingcartobj.add(no, acc));
	}
	
	void print(String acc) {
		ShoppingCartObj shoppingcartobj= new ShoppingCartObj();
		DefaultTableModel def = (DefaultTableModel) table.getModel();
		def.setRowCount(0);
		List<ShoppingCartMod> ls = shoppingcartobj.print(acc);
		for(ShoppingCartMod Uu : ls) {
			Vector v = new Vector();
			v.add(Uu.getNo());
			v.add(Uu.getName());
			v.add(Uu.getPrice());
			v.add(Uu.getPublisher());
			v.add(Uu.getPurchaser());
			def.addRow(v);
		}
	}
}
