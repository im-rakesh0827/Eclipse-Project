import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class ShowTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTable frame = new ShowTable();
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
	public ShowTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		
		JButton btnShow = new JButton("Show Table");
		btnShow.setBackground(new Color(0, 153, 153));
		btnShow.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		
		final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
        final String USERNAME = "root";
        final String PASSWORD = "Apple@0827";
        int count = 0;
		btnShow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
		        
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
					java.sql.Statement st = con.createStatement();
					String query = "select * from registration";
					ResultSet rs = st.executeQuery(query);
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols = rsmd.getColumnCount();
					String colName[] = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
						
					}
					model.setColumnIdentifiers(colName);
					
					while(rs.next()) {
						String name, email, phone, address, password;
						name = rs.getString(1);
						email = rs.getString(2);
						phone = rs.getString(3);
						address = rs.getString(4);
						password = rs.getString(5);
						
						String row[] = {name, email, phone, address, password};
						model.addRow(row);
					}
					st.close();
					con.close();
							
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnShow.setBounds(39, 86, 117, 29);
		contentPane.add(btnShow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 17, 251, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				
			}
		});
		btnClear.setBackground(new Color(22, 138, 169));
		btnClear.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnClear.setBounds(39, 162, 117, 29);
		contentPane.add(btnClear);
	}
}
