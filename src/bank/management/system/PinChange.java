package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PinChange extends JFrame implements ActionListener {

	JButton change, back;
	JTextField pintf, repintf;
	String pinnumber;

	public PinChange(String pinnumber) {
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
//		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(250, 285, 500, 30);
		image.add(text);

		JLabel pintext = new JLabel("NEW PIN: ");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setBounds(160, 320, 100, 30);
		image.add(pintext);

		pintf = new JTextField();
//		pintf.setForeground(Color.white);
		pintf.setFont(new Font("Raleway", Font.BOLD, 16));
		pintf.setBounds(310, 320, 200, 30);
		image.add(pintf);

		JLabel repintext = new JLabel("Re-Enter New PIN: ");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setBounds(160, 360, 150, 30);
		image.add(repintext);

		repintf = new JTextField();
//		repintf.setForeground(Color.white);
		repintf.setFont(new Font("Raleway", Font.BOLD, 16));
		repintf.setBounds(310, 360, 200, 30);
		image.add(repintf);

		change = new JButton("CHANGE");
		change.setBounds(365, 486, 140, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(365, 519, 140, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(400, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			new PinChange(pinnumber);
			try {
				String npin = pintf.getText();
				String rpin = repintf.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does'nt Match");
					return;
				}

				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter new PIN");
					return;

				}
				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");
					return;
				}

				JdbcConn jc = new JdbcConn();
				String query1 = "update bank set pin='" + rpin + "' where pin ='" + pinnumber + "'";
				String query2 = "update login set pin='" + rpin + "' where pin ='" + pinnumber + "'";
				String query3 = "update signupthree set pin='" + rpin + "' where pin ='" + pinnumber + "'";
				jc.st.executeUpdate(query1);
				jc.st.executeUpdate(query2);
				jc.st.executeUpdate(query3);
				JOptionPane.showMessageDialog(null, "PIN Changed Sucessfully!");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}

		if (ae.getSource() == change) {

		} else if (ae.getSource() == back) {

		}

	}

	public static void main(String args[]) {
		new PinChange("").setVisible(true);

	}
}