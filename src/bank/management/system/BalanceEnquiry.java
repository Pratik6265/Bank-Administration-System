package bank.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;
@SuppressWarnings("serial")
public class BalanceEnquiry extends JFrame implements ActionListener {
	JButton back;
	String pinnumber;

	public BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setTitle("Balance Enquiry Window");
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(365, 519, 140, 30);
		back.setBackground(Color.white);
		back.setFont(new Font("System", Font.BOLD, 16));
		back.setForeground(Color.black);
		back.addActionListener(this);
		image.add(back);

		int balance = 0;
		JdbcConn jc = new JdbcConn();

		try {
			ResultSet rs = jc.st.executeQuery("select * from bank where PIN ='" + pinnumber + "'");

			while (rs.next()) {
				if (rs.getString("Type").equals("Deposite")) {
					balance = balance + Integer.parseInt(rs.getString("Amount"));

				} else if (rs.getString("Type").equals("Withdrawl")) {
					balance = balance - Integer.parseInt(rs.getString("Amount"));
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

		JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		text.setBounds(185, 290, 400, 30);
		image.add(text);

		setSize(900, 900);
		setLocation(400, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
	}

	public static void main(String args[]) {
		new BalanceEnquiry("");
	}

}
