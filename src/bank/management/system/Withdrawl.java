package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {
	JTextField amount;
	JButton Withdrawl, back;
	String pinnumber;

	public Withdrawl(String pinnumber) {
		this.pinnumber = pinnumber;
		Color customColor = new Color(80, 86, 204);

		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Enter amounot to be Withdrawal");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(218, 285, 400, 30);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 12));
		amount.setBounds(170, 330, 320, 25);
		image.add(amount);

		Withdrawl = new JButton("Withdraw");
		Withdrawl.setBounds(365, 488, 140, 30);
		Withdrawl.setFont(new Font("System", Font.BOLD, 16));
		Withdrawl.setBackground(customColor);
		Withdrawl.setForeground(Color.white);
		Withdrawl.addActionListener(this);

		image.add(Withdrawl);

		back = new JButton("Back");
		back.setBounds(365, 518, 140, 30);
		back.setBackground(customColor);
		back.setFont(new Font("System", Font.BOLD, 16));
		back.setForeground(Color.white);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(400, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Withdrawl("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Withdrawl) {
			String number = amount.getText();
			Date date = new Date();
			if (number.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount!");
			} else {
				JdbcConn jc = new JdbcConn();
				String query = "insert into bank values('" + pinnumber + "','" + date.toLocaleString()
						+ "','Withdrawl','" + number + "')";
				try {
					jc.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Succesfully!");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);

		}
	}

}
