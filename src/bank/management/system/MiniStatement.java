package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
	String pinnumber;

	public MiniStatement(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		JLabel mini = new JLabel();
		add(mini);

		JLabel bank = new JLabel("PUBLIC SERVICE BANK");
		bank.setFont(new Font("Tahoma", Font.BOLD, 19));
		bank.setForeground(Color.red);
		bank.setBounds(60, 20, 300, 60);
		add(bank);

		JLabel bankn = new JLabel("PUBLIC SERVICE BANK");
		bankn.setBackground(Color.white);
		bankn.setFont(new Font("Tahoma", Font.BOLD, 19));
		bankn.setForeground(Color.yellow);
		bankn.setBounds(62, 22, 300, 60);
		add(bankn);

		JLabel card = new JLabel();
		card.setBackground(Color.white);
		card.setFont(new Font("System", Font.PLAIN, 11));
		card.setBounds(20, 80, 300, 30);
		add(card);

		JLabel balance = new JLabel();
		balance.setBackground(Color.white);
		balance.setBounds(20, 500, 300, 20);
		add(balance);

		try {
			JdbcConn jc = new JdbcConn();
			ResultSet rs = jc.st.executeQuery("Select * from login where PIN ='" + pinnumber + "'");
			while (rs.next()) {

				card.setText("Card Number: " + rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("Card_Number").substring(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JdbcConn jc = new JdbcConn();
			int bal = 0;
			ResultSet rs = jc.st.executeQuery("Select * from bank where PIN ='" + pinnumber + "'");
			while (rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("Type") + "&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + " <br><br><html>");

				if (rs.getString("Type").equals("Deposite")) {
					bal = bal + Integer.parseInt(rs.getString("Amount"));

				} else {
					bal = bal - Integer.parseInt(rs.getString("Amount"));

				}
			}

			balance.setText("Your Account Balance is Rs " + bal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mini.setBounds(20, 160, 400, 200);

		getContentPane().setBackground(Color.white);
		setSize(400, 600);
		setLocation(20, 20);
		setVisible(true);

	}

	public static void main(String args[]) {
		new MiniStatement("");
	}

}
