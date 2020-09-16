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

import AccessObj.BussinessMagObj;
import AccessObj.UserMagObj;
import model.Bussiness;
import model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BussinessList extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BussinessList frame = new BussinessList();
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
	public BussinessList() {
		setClosable(true);
		setTitle("\u5546\u5BB6\u7BA1\u7406");
		setBounds(100, 100, 799, 521);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 17));
		lblNewLabel.setBounds(90, 64, 115, 32);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 64, 279, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setlist(textField.getText());
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		btnNewButton.setBounds(528, 64, 115, 32);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 142, 593, 287);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D26\u53F7", "\u5BC6\u7801", "\u521B\u5EFA\u65E5\u671F"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(123);
		table.getColumnModel().getColumn(2).setPreferredWidth(339);
		scrollPane.setViewportView(table);
		
		setlist("");
	}
	
	public void setlist(String acc) {
		DefaultTableModel def = (DefaultTableModel) table.getModel();
		def.setRowCount(0);
		BussinessMagObj bussinessmagobj = new BussinessMagObj();
		List<Bussiness> ls = bussinessmagobj.getbussinesslist(acc);
		for(Bussiness Uu : ls) {
			Vector v = new Vector();
			v.add(Uu.getAccount());
			v.add(Uu.getPassword());
			v.add(Uu.getCreatedate());
			def.addRow(v);
		}
	}
}
