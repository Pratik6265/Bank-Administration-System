package bank.management.system;

import bank.management.system.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener {

	JTextField pantf, aadhartf;
	JButton next;
	JRadioButton Syes, Sno, exisyes, exisno;
	JComboBox religionbox, occupationbox, incomebox, educationbox, catagorybox;
	String formno;

	@SuppressWarnings("unchecked")
	public SignUpTwo(String formno) {
		this.formno = formno;
		setLayout(null);

		setTitle("New Accounat Application Form - Page 2");
		JLabel required = new JLabel("(Required Fields are denoted by *)");
		required.setForeground(Color.white);
		required.setBounds(570, 110, 300, 30);
		required.setFont(new Font("Raleway", Font.BOLD, 15));
		add(required);

		JLabel additionalD = new JLabel("Additional Details- Page 2");
		additionalD.setForeground(Color.white);
		additionalD.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalD.setBounds(245, 80, 300, 30);
		add(additionalD);

		JLabel religion = new JLabel("Religion*: ");
		religion.setForeground(Color.white);
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 120, 30);
		add(religion);

		String[] valReligion = { "Select your Religion", "Hindu", "Muslim", "Sikh", "Christion", "Other" };
		religionbox = new JComboBox(valReligion);
		religionbox.setBackground(Color.white);
		religionbox.setFont(new Font("Raleway", Font.PLAIN, 16));
		religionbox.setBounds(300, 140, 400, 30);
		add(religionbox);

		JLabel category = new JLabel("Category*: ");
		category.setForeground(Color.white);
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 160, 30);
		add(category);

		String valcatagory[] = { "Select your Catagory", "General", "OBC", "SC", "ST", "Other" };

		catagorybox = new JComboBox(valcatagory);
		catagorybox.setBackground(Color.white);
		catagorybox.setFont(new Font("Raleway", Font.PLAIN, 16));
		catagorybox.setBounds(300, 190, 400, 30);
		add(catagorybox);

		JLabel income = new JLabel("Income*:");
		income.setForeground(Color.white);
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 230, 160, 30);
		add(income);

		String incomecategory[] = { "Select your Income Catagory", "NULL", "< 1,00,000", "< 2,50,000", "< 5,00,000",
				"Upto 10,00,000" };
		incomebox = new JComboBox(incomecategory);
		incomebox.setBackground(Color.white);
		incomebox.setFont(new Font("Raleway", Font.PLAIN, 16));
		incomebox.setBounds(300, 235, 400, 30);
		add(incomebox);

		JLabel education = new JLabel("Educational");
		education.setForeground(Color.white);
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 280, 160, 30);
		add(education);

		JLabel email = new JLabel("Qualification*:");
		email.setForeground(Color.white);
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 305, 160, 30);
		add(email);

		String educationval[] = { "Select your Education", "10th", "12th", "Graduate", "Post-Graduation", "Doctor",
				"Other" };
		educationbox = new JComboBox(educationval);
		educationbox.setBackground(Color.white);
		educationbox.setFont(new Font("Raleway", Font.PLAIN, 16));
		educationbox.setBounds(300, 295, 400, 30);
		add(educationbox);

		JLabel marrigeStatus = new JLabel("Occupation*:");
		marrigeStatus.setForeground(Color.white);
		marrigeStatus.setFont(new Font("Raleway", Font.BOLD, 20));
		marrigeStatus.setBounds(100, 380, 160, 30);
		add(marrigeStatus);

		String occupationval[] = { "Select your Occupation", "Salaried", "Self-Employed", "Bussiness", "Student",
				"Govt. Employer", "Other" };

		occupationbox = new JComboBox(occupationval);
		occupationbox.setBackground(Color.white);
		occupationbox.setFont(new Font("Raleway", Font.PLAIN, 16));
		occupationbox.setBounds(300, 380, 400, 30);
		add(occupationbox);

		JLabel pan = new JLabel("PAN Number*:");
		pan.setForeground(Color.white);
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 430, 160, 30);
		add(pan);

		pantf = new JTextField();
		pantf.setFont(new Font("Raleway", Font.PLAIN, 16));
		pantf.setBackground(Color.white);
		pantf.setBounds(300, 430, 400, 30);
		add(pantf);

		JLabel aadhar = new JLabel("Aadhar Number*:");
		aadhar.setForeground(Color.white);
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 480, 180, 30);
		add(aadhar);

		aadhartf = new JTextField();

		aadhartf.setFont(new Font("Raleway", Font.PLAIN, 16));
		aadhartf.setBackground(Color.white);
		aadhartf.setBounds(300, 480, 400, 30);
		add(aadhartf);

		JLabel senior = new JLabel("Senior Citizen*:");
		senior.setForeground(Color.white);
		senior.setFont(new Font("Raleway", Font.BOLD, 20));
		senior.setBounds(100, 530, 160, 30);
		add(senior);

		Syes = new JRadioButton("Yes");
		Syes.setBounds(300, 530, 100, 30);
		Syes.setBackground(Color.white);
		add(Syes);

		Sno = new JRadioButton("No");
		Sno.setBounds(480, 530, 100, 30);
		Sno.setBackground(Color.white);
		add(Sno);

		ButtonGroup Sgroup = new ButtonGroup();
		Sgroup.add(Syes);
		Sgroup.add(Sno);

		JLabel exisaccount = new JLabel("Existing Account*:");
		exisaccount.setForeground(Color.white);
		exisaccount.setFont(new Font("Raleway", Font.BOLD, 20));
		exisaccount.setBounds(100, 580, 200, 30);
		add(exisaccount);

		exisyes = new JRadioButton("Yes");
		exisyes.setBounds(300, 580, 100, 30);
		exisyes.setBackground(Color.white);
		add(exisyes);

		exisno = new JRadioButton("No");
		exisno.setBounds(480, 580, 100, 30);
		exisno.setBackground(Color.white);
		add(exisno);

		ButtonGroup exisgroup = new ButtonGroup();
		exisgroup.add(exisyes);
		exisgroup.add(exisno);

		JButton next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 15));
		next.setBounds(620, 700, 80, 30);
		next.setBorder(BorderFactory.createRaisedBevelBorder());

		int borderRadius = 20; // You can adjust this value

		Border roundedBorder = BorderFactory.createEmptyBorder();
		roundedBorder = new LineBorder(Color.WHITE, 2, true); // Add a white border
		roundedBorder = BorderFactory.createCompoundBorder(roundedBorder,
				BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));

		next.setBorder(roundedBorder);

		next.setPreferredSize(new Dimension(190, 60));
		add(next);
		next.addActionListener(this);

		getContentPane().setBackground(Color.GRAY);
		setSize(850, 800);
		setLocation(400, 110);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		String sreligion = (String) religionbox.getSelectedItem();
		String scatagory = (String) catagorybox.getSelectedItem();
		String sincome = (String) incomebox.getSelectedItem();

		String seducation = (String) educationbox.getSelectedItem();
		String soccupation = (String) occupationbox.getSelectedItem();
		String seniorcitizon = null;
		if (Syes.isSelected()) {
			seniorcitizon = "Yes";
		} else if (Sno.isSelected()) {
			seniorcitizon = "NO";
		}

		String sexistingaccount = null;
		if (exisyes.isSelected()) {
			sexistingaccount = "Yes";
		} else if (exisno.isSelected()) {
			sexistingaccount = "No";
		}

		String span = pantf.getText();
		String saadhar = aadhartf.getText();
		if (sreligion.equals("Select your Religion") || scatagory.equals("Select your Catagory") || span.equals("")
				|| saadhar.equals("") || sincome.equals("Select your Income Catagory")
				|| seducation.equals("Select your Education") || soccupation.equals("Select your Occupation")
				|| seniorcitizon.equals(null) || sexistingaccount.equals(null)) {
			JOptionPane.showMessageDialog(null, "Please fill the Required Fields");
		} else {

			try {
				JdbcConn jc = new JdbcConn();
				String query = "Insert into signuptwo values('" + formno + "','" + sreligion + "','" + scatagory + "','"
						+ sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','"
						+ seniorcitizon + "','" + sexistingaccount + "')";
				jc.st.executeUpdate(query);
				// Signup3 Object
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new SignUpTwo("");

	}

}