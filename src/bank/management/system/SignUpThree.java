package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class SignUpThree extends JFrame implements ActionListener {
	JRadioButton savingr, fdr, currentr, redar;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;

	public SignUpThree(String formno) {

		this.formno = formno;
		setLayout(null);
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setForeground(Color.white);
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);

		JLabel type = new JLabel("Account Type:");
		type.setForeground(Color.white);
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(85, 120, 250, 30);
		add(type);

		savingr = new JRadioButton("Saving Account");
		savingr.setFont(new Font("Raleway", Font.BOLD, 16));
		savingr.setBackground(Color.white);
		savingr.setBounds(165, 170, 180, 20);
		add(savingr);

		fdr = new JRadioButton("Fidex Diposit Account");
		fdr.setFont(new Font("Raleway", Font.BOLD, 16));
		fdr.setBackground(Color.white);
		fdr.setBounds(430, 170, 200, 20);
		add(fdr);

		currentr = new JRadioButton("Current Account");
		currentr.setFont(new Font("Raleway", Font.BOLD, 16));
		currentr.setBackground(Color.white);
		currentr.setBounds(165, 210, 180, 20);
		add(currentr);

		redar = new JRadioButton("Recuuring Deposite Account");
		redar.setFont(new Font("Raleway", Font.BOLD, 16));
		redar.setBackground(Color.white);
		redar.setBounds(430, 210, 250, 20);
		add(redar);

		ButtonGroup accountgroup = new ButtonGroup();
		accountgroup.add(currentr);
		accountgroup.add(fdr);
		accountgroup.add(redar);
		accountgroup.add(savingr);

		JLabel card = new JLabel("Card Number:");
		card.setForeground(Color.white);
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(85, 250, 250, 30);
		add(card);

		JLabel carddetail = new JLabel("(Your 16 Digits Card Number)");
		carddetail.setForeground(Color.white);
		carddetail.setFont(new Font("Raleway", Font.PLAIN, 15));
		carddetail.setBounds(85, 275, 250, 20);
		add(carddetail);

		JLabel cardno = new JLabel("XXXX-XXXX-XXXX-5343");
		cardno.setForeground(Color.white);
		cardno.setFont(new Font("Raleway", Font.BOLD, 22));
		cardno.setBounds(320, 250, 400, 30);
		add(cardno);

		JLabel pin = new JLabel("PIN:");
		pin.setForeground(Color.white);
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(85, 300, 250, 30);
		add(pin);

		JLabel pindetail = new JLabel("(Your 4 Digits PIN Number)");
		pindetail.setForeground(Color.white);
		pindetail.setFont(new Font("Raleway", Font.PLAIN, 15));
		pindetail.setBounds(85, 322, 250, 20);
		add(pindetail);

		JLabel pnumber = new JLabel("XXXX");
		pnumber.setForeground(Color.white);
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(320, 300, 400, 30);
		add(pnumber);

		JLabel service = new JLabel("Service Facility:");
		service.setForeground(Color.white);
		service.setFont(new Font("Raleway", Font.BOLD, 22));
		service.setBounds(85, 360, 300, 30);
		add(service);

		c1 = new JCheckBox("Credit and Debit cards");
		c1.setFont(new Font("Raleway", Font.PLAIN, 17));
		c1.setBackground(Color.white);
		c1.setBounds(85, 395, 250, 20);
		add(c1);

		c2 = new JCheckBox("Cheque Book");
		c2.setFont(new Font("Raleway", Font.PLAIN, 17));
		c2.setBackground(Color.white);
		c2.setBounds(350, 395, 140, 20);
		add(c2);

		c3 = new JCheckBox("SMS and Email Alert");
		c3.setFont(new Font("Raleway", Font.PLAIN, 17));
		c3.setBackground(Color.white);
		c3.setBounds(350, 455, 200, 20);
		add(c3);

		c4 = new JCheckBox("Insurance*");
		c4.setFont(new Font("Raleway", Font.PLAIN, 17));
		c4.setBackground(Color.white);
		c4.setBounds(85, 425, 200, 20);
		add(c4);

		c4 = new JCheckBox("Online and Mobile Banking");
		c4.setFont(new Font("Raleway", Font.PLAIN, 17));
		c4.setBackground(Color.white);
		c4.setBounds(350, 425, 250, 20);
		add(c4);

		c5 = new JCheckBox("ATMs Service");
		c5.setFont(new Font("Raleway", Font.PLAIN, 17));
		c5.setBackground(Color.white);
		c5.setBounds(85, 455, 265, 20);
		add(c5);

		c6 = new JCheckBox("I here by declare that the above entered details are correct and best of my knowledge. ");
		c6.setFont(new Font("Courier", Font.BOLD, 15));
		c6.setBackground(Color.white);
		c6.setBounds(85, 530, 630, 20);
		add(c6);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(85, 600, 80, 30);
		cancel.addActionListener(this);

		add(cancel);

		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(550, 600, 80, 30);
		submit.addActionListener(this);
		add(submit);

		getContentPane().setBackground(Color.gray);
		setSize(850, 820);
		setLocation(400, 110);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (c6.isSelected()) {

			if (ae.getSource() == submit) {
				String accountType = null;

				if (savingr.isSelected()) {
					accountType = "Saving Account";
				}
				if (fdr.isSelected()) {
					accountType = "Fixed Deposite Account";

				}

				if (currentr.isSelected()) {
					accountType = "Current Account";

				}

				if (redar.isSelected()) {
					accountType = "Reccuing Deposite Account";

				}

				Random random = new Random();

				String cardnoRandom = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

				String pinRandom = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
//		System.out.println(random+""+cardnoRandom);

				String facility = "";
				if (c1.isSelected()) {
					facility = facility + " Credit and Debit Cards";
				} else if (c2.isSelected()) {
					facility += " Cheque Book";
				}

				else if (c3.isSelected()) {
					facility += " SMS and Email Alert";
				}

				else if (c4.isSelected()) {
					facility += " Insurance*";
				} else if (c5.isSelected()) {
					facility += " Online and Mobile Banking";
				}

				try {
					if (accountType.equals("")) {
						JOptionPane.showMessageDialog(null, "Account Type is Required");
					} else {
						JdbcConn jc = new JdbcConn();
						String query1 = "Insert into signupthree values('" + formno + "','" + accountType + "','"
								+ cardnoRandom + "','" + pinRandom + "','" + facility + "')";
						String query2 = "Insert into login values('" + formno + "','" + cardnoRandom + "','" + pinRandom
								+ "')";
						jc.st.executeUpdate(query1);
						jc.st.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Card Number: " + cardnoRandom + "\n PIN: " + pinRandom);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (ae.getSource() == cancel) {

				System.exit(0);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please check the aggrement");
		}
	}

	public static void main(String args[]) {
		new SignUpThree("");
	}
}
