package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {

	JButton deposite, withdrawl, fastcash, minireciept, pinchange, exit, balancequiry,feedback;

	String pinnumber;

	Transaction(String pinnumber) {
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Plese Select your Transaction ");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(218, 290, 400, 30);
		image.add(text);

		Color customColor = new Color(80, 86, 204);
		deposite = new JButton("Deposite");
		deposite.setBounds(160, 418, 140, 30);
		deposite.setBackground(customColor);
		deposite.setForeground(Color.white);
		deposite.setFont(new Font("System", Font.BOLD, 14));
		deposite.addActionListener(this);
		image.add(deposite);

		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(365, 418, 140, 30);
		withdrawl.setBackground(customColor);
		withdrawl.setForeground(Color.white);
		withdrawl.setFont(new Font("System", Font.BOLD, 14));
		withdrawl.addActionListener(this);
		image.add(withdrawl);

		minireciept = new JButton("Mini reciept");
		minireciept.setBounds(365, 453, 140, 30);
		minireciept.setBackground(customColor);
		minireciept.setForeground(Color.white);
		minireciept.setFont(new Font("System", Font.BOLD, 14));
		minireciept.addActionListener(this);

		image.add(minireciept);

		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(160, 453, 140, 30);
		fastcash.setBackground(customColor);
		fastcash.setForeground(Color.white);
		fastcash.setFont(new Font("System", Font.BOLD, 14));

		fastcash.addActionListener(this);
		image.add(fastcash);

		pinchange = new JButton("PIN change");
		pinchange.setBounds(160, 486, 140, 30);
		pinchange.setBackground(customColor);
		pinchange.setForeground(Color.white);
		pinchange.setFont(new Font("System", Font.BOLD, 14));
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		feedback = new JButton("Feedback");
        feedback.setBounds(160, 520, 140, 30); // Adjust the bounds as needed
        feedback.setBackground(customColor);
        feedback.setForeground(Color.white);
        feedback.setFont(new Font("System", Font.BOLD, 14));
        feedback.addActionListener(this);
        image.add(feedback);

		balancequiry = new JButton("Balance Quiry");
		balancequiry.setBounds(365, 486, 140, 30);
		balancequiry.setBackground(customColor);
		balancequiry.setForeground(Color.white);
		balancequiry.setFont(new Font("System", Font.BOLD, 14));

		balancequiry.addActionListener(this);
		image.add(balancequiry);

		exit = new JButton("Exit");
		exit.setBounds(365, 519, 140, 30);
		exit.setBackground(Color.red);
		exit.setFont(new Font("System", Font.BOLD, 16));
		exit.setForeground(Color.black);
		exit.addActionListener(this);
		image.add(exit);

		setSize(900, 900);
		setLocation(400, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			System.exit(0);
		} else if (ae.getSource() == deposite) {
			setVisible(false);
			new Deposite(pinnumber).setVisible(true);

		}
		else if(ae.getSource()== feedback) {		
			setVisible(false);
			new Feedback(pinnumber).setVisible(true);
			
			
		}
		else if (ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		} else if (ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if (ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		} else if (ae.getSource() == balancequiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		} else if (ae.getSource() == minireciept) {

			new MiniStatement(pinnumber).setVisible(true);
		}
	}

	public static void main(String args[]) {

		new Transaction("");
	}

}
