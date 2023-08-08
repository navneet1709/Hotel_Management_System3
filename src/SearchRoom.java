
import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;
        Choice c1;
		Choice c2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public SearchRoom() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);
		
		// JLabel lblRoomAvailable = new JLabel("Bed Type:");
		// lblRoomAvailable.setBounds(50, 70, 96, 20);
		// contentPane.add(lblRoomAvailable);

		JLabel lblac = new JLabel("AC Type:");
		lblac.setBounds(50, 120, 96, 20);
		contentPane.add(lblac);
		
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
                
        //         JLabel l1 = new JLabel("Bed Type");
		// l1.setBounds(580, 162, 96, 14);
		// contentPane.add(l1);

		JLabel l12 = new JLabel("AC Type");
		l12.setBounds(680, 162, 96, 14);
		contentPane.add(l12);
		
		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
                checkRoom.setBackground(Color.WHITE);
		contentPane.add(checkRoom);

		JCheckBox checkRoom_type = new JCheckBox("Double bed");
		checkRoom_type.setBounds(153, 69, 205, 23);
                checkRoom_type.setBackground(Color.WHITE);
		contentPane.add(checkRoom_type);

		JCheckBox checkRoom_type2 = new JCheckBox("Single bed");
		checkRoom_type2.setBounds(153, 89, 205, 23);
                checkRoom_type2.setBackground(Color.WHITE);
		contentPane.add(checkRoom_type2);
		
		
        //         c1 = new Choice();
        //         c1.add("Single Bed");
        //         c1.add("Double Bed");
        //         c1.setBounds(153, 70, 120, 20);
		// contentPane.add(c1);

		c2 = new Choice();
                c2.add("Ac");
                c2.add("Non-Ac");
                c2.setBounds(153, 120, 120, 20);
		contentPane.add(c2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String SQL = "select * from Room where bed_type = '"+c2.getSelectedItem()+"'";
				String SQL = "select * from Room where bed_type = 'Single Bed' AND ac = '"+ c2.getSelectedItem()+"'";
				String SQL2 = "select * from Room where availability = 'Available' AND ac = '"+c2.getSelectedItem()+"'";
			    // String SQL1 = "select * from Room where ac = '"+c2.getSelectedItem()+"'";
				String SQL1 = "select * from Room where bed_type = 'Double Bed' AND ac = '"+ c2.getSelectedItem()+"'";
				
				try{			
                                conn c = new conn();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));

				rs = c.s.executeQuery(SQL1);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(checkRoom.isSelected())
				{	
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}

				if(checkRoom_type.isSelected())
				{	
					rs = c.s.executeQuery(SQL1);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				if(checkRoom_type2.isSelected())
				{	
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(20, 187, 760, 300);
		contentPane.add(table);
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblCleanStatus);
                
                getContentPane().setBackground(Color.WHITE);
	}
}