package bank.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

	JButton login, clear, cancel, signup;
	JTextField Cardn;
	JPasswordField pinno;

	Login() {

		setTitle("ATM");
		setLayout(null);
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
		Image i5 = i4.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0, 0, 900, 900);
		add(image);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(5, 110, 100, 100);
		image.add(label);

		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 30));
		text.setBounds(270, 40, 300, 40);
		image.add(text);

		JLabel Cardno = new JLabel("Account No.:");
		Cardno.setFont(new Font("Raleway", Font.BOLD, 22));
		Cardno.setBounds(460, 340, 300, 40);

		image.add(Cardno);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(460, 390, 300, 40);
		image.add(pin);

		Cardn = new JTextField();
		Cardn.setBackground(Color.LIGHT_GRAY);
		Cardn.setBounds(597, 350, 250, 30);
		Cardn.setFont(new Font("Arial", Font.BOLD, 15));
		image.add(Cardn);

		pinno = new JPasswordField();
		pinno.setBounds(597, 400, 250, 30);
		pinno.setBackground(Color.LIGHT_GRAY);
		pinno.setFont(new Font("Arial", Font.BOLD, 15));
		image.add(pinno);

		login = new JButton("Sign in");
		login.setBounds(590, 450, 110, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		// foreground is used for change font of button

		int borderRadius = 20; // You can adjust this value

		Border roundedBorder = BorderFactory.createEmptyBorder();
		roundedBorder = new LineBorder(Color.gray, 3, true); // Add a white border
		roundedBorder = BorderFactory.createCompoundBorder(roundedBorder,
				BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));

		login.setBorder(roundedBorder);

		login.setPreferredSize(new Dimension(190, 60));
		login.addActionListener(this);

		image.add(login);

		clear = new JButton("Clear");
		clear.setBounds(730, 450, 110, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		int borderRadius1 = 20; // You can adjust this value

		Border roundedBorder1 = BorderFactory.createEmptyBorder();
		roundedBorder1 = new LineBorder(Color.gray, 3, true); // Add a white border
		roundedBorder1 = BorderFactory.createCompoundBorder(roundedBorder1,
				BorderFactory.createEmptyBorder(10, borderRadius1, 10, borderRadius1));

		clear.setBorder(roundedBorder1);

		clear.setPreferredSize(new Dimension(190, 60));
		clear.addActionListener(this);
		clear.addActionListener(this);
		int borderRadius11 = 20; // You can adjust this value

		Border roundedBorder11 = BorderFactory.createEmptyBorder();
		roundedBorder11 = new LineBorder(Color.gray, 3, true); // Add a white border
		roundedBorder11 = BorderFactory.createCompoundBorder(roundedBorder11,
				BorderFactory.createEmptyBorder(10, borderRadius11, 10, borderRadius11));

		clear.setBorder(roundedBorder11);

		clear.setPreferredSize(new Dimension(190, 60));
		clear.addActionListener(this);
		image.add(clear);

		cancel = new JButton("╳");
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		cancel.setBounds(850, 0, 50, 50);
		cancel.addActionListener(this);
		image.add(cancel);

		signup = new JButton("Sign Up");
		signup.setBounds(590, 490, 250, 30);

		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.setBorder(BorderFactory.createRaisedBevelBorder());

		int borderRadius111 = 20; // You can adjust this value

		Border roundedBorder111 = BorderFactory.createEmptyBorder();
		roundedBorder111 = new LineBorder(Color.gray, 3, true); // Add a white border
		roundedBorder111 = BorderFactory.createCompoundBorder(roundedBorder111,
				BorderFactory.createEmptyBorder(10, borderRadius111, 10, borderRadius111));

		signup.setBorder(roundedBorder111);

		signup.setPreferredSize(new Dimension(190, 60));
		signup.addActionListener(this);
		image.add(signup);

		Color custom = new Color(186, 186, 186);

		// getContentPane() is used to catch full frame
		getContentPane().setBackground(custom);
		setUndecorated(true);
		setSize(900, 980);
		setLocation(350, 5);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancel) {
			System.exit(0);
		} else if (ae.getSource() == clear) {
			pinno.setText("");
			Cardn.setText("");

		} else if (ae.getSource() == login) {

			JdbcConn jc = new JdbcConn();
			String cardnumber = Cardn.getText();
			String pinnumber = pinno.getText();
			String query = "select * from login where Card_Number = '" + cardnumber + "' and PIN = '" + pinnumber + "'";
			try {
				ResultSet rs = jc.st.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				} else if (cardnumber.equals("") && pinnumber.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter PIN or Card Number");
				} else if (cardnumber.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Card Number");
				} else if (pinnumber.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter PIN");
				} else if (cardnumber != Cardn.getText()) {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number");
				}

				else if (pinnumber != pinno.getText()) {
					JOptionPane.showMessageDialog(null, "Incorrect PIN");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (ae.getSource() == signup) {
			setVisible(false);
			new Signupone().setVisible(true);
		}
	}

	public static void main(String[] args) throws Exception {
		new Login();

	}

}
