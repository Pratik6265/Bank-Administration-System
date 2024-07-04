package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

	JButton rs100, rs500, rs200, rs1000, rs5000, back, rs10000;

	String pinnumber;

	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		Color customColor = new Color(38, 199, 43);

		JLabel text = new JLabel("Plese Select your Transaction Amount");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(196, 290, 400, 30);
		image.add(text);

		rs100 = new JButton("Rs 100");
		rs100.setBounds(160, 418, 140, 30);
		rs100.setBackground(customColor);
		rs100.setForeground(Color.black);
		rs100.setFont(new Font("System", Font.BOLD, 14));
		rs100.addActionListener(this);
		image.add(rs100);

		rs500 = new JButton("Rs 500");
		rs500.setBounds(365, 418, 140, 30);
		rs500.setBackground(customColor);
		rs500.setForeground(Color.black);
		rs500.setFont(new Font("System", Font.BOLD, 14));
		rs500.addActionListener(this);
		image.add(rs500);

		rs1000 = new JButton("Rs 1000");
		rs1000.setBounds(365, 453, 140, 30);
		rs1000.setBackground(customColor);
		rs1000.setForeground(Color.black);
		rs1000.setFont(new Font("System", Font.BOLD, 14));
		rs1000.addActionListener(this);

		image.add(rs1000);

		rs200 = new JButton("Rs 200");
		rs200.setBounds(160, 453, 140, 30);
		rs200.setBackground(customColor);
		rs200.setForeground(Color.black);
		rs200.setFont(new Font("System", Font.BOLD, 14));

		rs200.addActionListener(this);
		image.add(rs200);

		rs5000 = new JButton("Rs 5000");
		rs5000.setBounds(160, 486, 140, 30);
		rs5000.setBackground(customColor);
		rs5000.setForeground(Color.black);
		rs5000.setFont(new Font("System", Font.BOLD, 14));
		rs5000.addActionListener(this);
		image.add(rs5000);

		rs10000 = new JButton("Rs 10000");
		rs10000.setBounds(365, 486, 140, 30);
		rs10000.setBackground(customColor);
		rs10000.setForeground(Color.black);
		rs10000.setFont(new Font("System", Font.BOLD, 14));

		rs10000.addActionListener(this);
		image.add(rs10000);

		back = new JButton("Back");
		back.setBounds(365, 519, 140, 30);
		back.setBackground(customColor);
		back.setFont(new Font("System", Font.BOLD, 16));
		back.setForeground(Color.black);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(400, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);

		} else {
			String amount = ((JButton) ae.getSource()).getText().substring(3);
			JdbcConn jc = new JdbcConn();
			try {
				ResultSet rs = jc.st.executeQuery("select * from bank where PIN ='" + pinnumber + "'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("Type").equals("Deposite")) {
						balance = balance + Integer.parseInt(rs.getString("Amount"));

					} else {
						balance = balance - Integer.parseInt(rs.getString("Amount"));

					}
				}
				if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount
						+ "')";
				jc.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Succesfully!");

				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {

		new FastCash("");
	}

}
