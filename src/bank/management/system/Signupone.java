package bank.management.system;

import bank.management.system.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import com.toedter.calendar.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Signupone extends JFrame implements ActionListener {
	long random;
	JTextField nametf, fatherntf, datetf, emailtf, pincodetf, statetf, citytf;
	JTextArea addressarea;
	JButton next;
	JRadioButton male, female, other, married, unmarried, othermarrige;
	JDateChooser datechooser;

	public Signupone() {

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(15, 10, 100, 100);
		add(label);

		JLabel required = new JLabel("(Required Fields are denoted by *)");
		required.setForeground(Color.white);

		required.setBounds(570, 110, 300, 30);
		required.setFont(new Font("Raleway", Font.BOLD, 15));
		add(required);

		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);

		JLabel formn = new JLabel("Application Form No. : " + random);
		formn.setForeground(Color.white);
		formn.setFont(new Font("Raleway", Font.BOLD, 38));
		formn.setBounds(140, 20, 600, 40);
		add(formn);

		JLabel personalD = new JLabel("PAGE 1: Personal Details ");
		personalD.setForeground(Color.white);
		personalD.setFont(new Font("Raleway", Font.BOLD, 22));
		personalD.setBounds(245, 80, 300, 30);
		add(personalD);

		JLabel name = new JLabel("Name*: ");
		name.setForeground(Color.white);
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nametf = new JTextField();
		nametf.setFont(new Font("Raleway", Font.PLAIN, 16));
		nametf.setBackground(Color.white);
		nametf.setBounds(300, 140, 400, 30);
		add(nametf);

		JLabel fathern = new JLabel("Father's Name*: ");
		fathern.setForeground(Color.white);
		fathern.setFont(new Font("Raleway", Font.BOLD, 20));
		fathern.setBounds(100, 190, 160, 30);
		add(fathern);

		fatherntf = new JTextField();
		fatherntf.setFont(new Font("Raleway", Font.PLAIN, 16));
		fatherntf.setBackground(Color.white);
		fatherntf.setBounds(300, 190, 400, 30);
		add(fatherntf);

		JLabel dob = new JLabel("Date of Birth*:");
		dob.setForeground(Color.white);
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 230, 160, 30);
		add(dob);

		datechooser = new JDateChooser();
		datechooser.setBounds(300, 230, 400, 30);
		datechooser.setForeground(Color.white);
		add(datechooser);

		JLabel gender = new JLabel("Gender*:");
		gender.setForeground(Color.white);
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 280, 160, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 280, 60, 30);

		male.setBackground(Color.LIGHT_GRAY);
		add(male);
		female = new JRadioButton("Female");
		female.setBounds(450, 280, 100, 30);
		female.setBackground(Color.LIGHT_GRAY);
		add(female);
		other = new JRadioButton("Other");
		other.setBounds(600, 280, 60, 30);
		other.setBackground(Color.LIGHT_GRAY);
		add(other);

		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);

		JLabel email = new JLabel("Email*:");
		email.setForeground(Color.white);
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 330, 160, 30);
		add(email);

		emailtf = new JTextField();
		emailtf.setFont(new Font("Raleway", Font.PLAIN, 16));
		emailtf.setBackground(Color.white);
		emailtf.setBounds(300, 330, 400, 30);
		add(emailtf);

		JLabel marrigeStatus = new JLabel("Maritial Status*:");
		marrigeStatus.setForeground(Color.white);
		marrigeStatus.setFont(new Font("Raleway", Font.BOLD, 20));
		marrigeStatus.setBounds(100, 380, 160, 30);
		add(marrigeStatus);

		married = new JRadioButton("Married");
		married.setBounds(300, 380, 100, 30);
		married.setBackground(Color.LIGHT_GRAY);
		add(married);
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 380, 100, 30);
		unmarried.setBackground(Color.LIGHT_GRAY);
		add(unmarried);
		othermarrige = new JRadioButton("Other");
		othermarrige.setBounds(600, 380, 60, 30);
		othermarrige.setBackground(Color.LIGHT_GRAY);
		add(othermarrige);

		ButtonGroup marrigestatusgroup = new ButtonGroup();
		marrigestatusgroup.add(married);
		marrigestatusgroup.add(unmarried);
		marrigestatusgroup.add(othermarrige);

		JLabel address = new JLabel("Address*:");
		address.setForeground(Color.white);
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 430, 160, 30);
		add(address);

		addressarea = new JTextArea(3, 5);
		addressarea.setFont(new Font("Raleway", Font.PLAIN, 16));
		addressarea.setBackground(Color.white);
		addressarea.setBounds(300, 430, 400, 90);
		add(addressarea);

		JLabel city = new JLabel("City*:");
		city.setForeground(Color.white);
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 550, 160, 30);
		add(city);

		citytf = new JTextField();
		citytf.setFont(new Font("Raleway", Font.PLAIN, 16));
		citytf.setBackground(Color.white);
		citytf.setBounds(300, 550, 400, 30);
		add(citytf);

		JLabel state = new JLabel("State*:");
		state.setForeground(Color.white);
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 600, 160, 30);
		add(state);

		statetf = new JTextField();
		statetf.setFont(new Font("Raleway", Font.PLAIN, 16));
		statetf.setBackground(Color.white);
		statetf.setBounds(300, 600, 400, 30);
		add(statetf);

		JLabel pincode = new JLabel("Pincode*:");
		pincode.setForeground(Color.white);
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 650, 160, 30);
		add(pincode);

		pincodetf = new JTextField();
		pincodetf.setFont(new Font("Raleway", Font.PLAIN, 16));
		pincodetf.setBackground(Color.white);
		pincodetf.setBounds(300, 650, 400, 30);
		add(pincodetf);

		JButton next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 15));
		next.setBounds(620, 700, 80, 30);
		add(next);
		next.addActionListener(this);

		getContentPane().setBackground(Color.gray);
		setSize(850, 800);
		setLocation(400, 110);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random; // long
		String name = nametf.getText();
		String fname = fatherntf.getText();
		String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		} else if (other.isSelected()) {
			gender = "Other";
		}
		String email = emailtf.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "UnMarried";
		} else if (othermarrige.isSelected()) {
			marital = "Other";
		}
		String address = addressarea.getText();
		String city = citytf.getText();
		String state = statetf.getText();
		String pin = pincodetf.getText();

		try {
			if (name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") || email.equals("")
					|| marital.equals("") || address.equals("") || city.equals("") || state.equals("")
					|| pin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Fill the Required Fields");

			}

			else {
				JdbcConn jc = new JdbcConn();

				String query = "Insert into signup values('" + formno + "','" + name + "','" + fname + "','" + gender
						+ "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state
						+ "')";

				jc.st.executeUpdate(query);
				new SignUpTwo(formno).setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//  private Window SignUpTwo(String formno2) {
//	// TODO Auto-generated method stub
//	return null;
//}

	public static void main(String[] args) {
		new Signupone();

	}

}