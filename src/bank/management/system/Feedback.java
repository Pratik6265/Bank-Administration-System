package bank.management.system;

import java.sql.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Feedback extends JFrame {
	JTextField nametf, accounttf;
	JSlider ratingSlider;
	JComboBox<String> reasonCombo;
	JTextArea complaintsArea, commentsArea;
	JButton submitButton;
	String formno;
	Feedback(String formno) {
		this.formno=formno;
		setLayout(null);
		setTitle("Bank Customer Feedback Form");
		JLabel heading = new JLabel("Bank Customer Feedback Form");
		heading.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
		heading.setBounds(150, 10, 300, 30);
		add(heading);

		JLabel name = new JLabel("Full Name: ");
		name.setFont(new Font("Arial", Font.BOLD, 18));
		name.setBounds(70, 55, 100, 30);
		add(name);

		nametf = new JTextField();
		nametf.setFont(new Font("Arial", Font.PLAIN, 18));
		nametf.setBounds(210, 55, 300, 30);
		add(nametf);

		JLabel accountno = new JLabel("Account No. :");
		accountno.setFont(new Font("Arial", Font.BOLD, 18));
		accountno.setBounds(70, 100, 200, 30);
		add(accountno);

		accounttf = new JTextField();
		accounttf.setFont(new Font("Arial", Font.PLAIN, 18));
		accounttf.setBounds(210, 100, 300, 30);
		add(accounttf);

		JLabel ratingLabel = new JLabel("Rating:");
		ratingLabel.setFont(new Font("Arial", Font.BOLD, 18));
		ratingLabel.setBounds(70, 145, 100, 30);
		add(ratingLabel);

		ratingSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1); // Create a slider with values 1 to 5
		ratingSlider.setMajorTickSpacing(1);
//	    ratingSlider.setMinorTickSpacing(2);
//	    ratingSlider.setBackground(Color.green);
		ratingSlider.setPaintTicks(true);
		ratingSlider.setBounds(210, 145, 300, 50);
		add(ratingSlider);

		ratingSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int rating = ratingSlider.getValue();
				// You can use the 'rating' value in your feedback submission logic.
			}
		});

		JLabel reasonLabel = new JLabel("Primary reason for your visit:");
		reasonLabel.setFont(new Font("Arial", Font.BOLD, 18));
		reasonLabel.setBounds(70, 200, 250, 30);
		add(reasonLabel);

		String[] reasonOptions = { "Deposit", "Withdrawal", "Account Inquiry", "Loan Application",
				"Others (please specify)" };
		reasonCombo = new JComboBox<>(reasonOptions);
		reasonCombo.setFont(new Font("Arial", Font.PLAIN, 18));
		reasonCombo.setBounds(330, 200, 180, 30);
		add(reasonCombo);

		JLabel commentsLabel = new JLabel("Additional comments or suggestions:");
		commentsLabel.setFont(new Font("Arial", Font.BOLD, 18));
		commentsLabel.setBounds(70, 250, 400, 30);
		add(commentsLabel);

		commentsArea = new JTextArea();
		commentsArea.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(commentsArea);
		scrollPane.setBounds(70, 290, 420, 100);
		add(scrollPane);

		JLabel complaintsLabel = new JLabel("Complaints or Issues:");
		complaintsLabel.setFont(new Font("Arial", Font.BOLD, 18));
		complaintsLabel.setBounds(70, 400, 300, 30);
		add(complaintsLabel);

		complaintsArea = new JTextArea();
		complaintsArea.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane complaintsScrollPane = new JScrollPane(complaintsArea);
		complaintsScrollPane.setBounds(70, 440, 420, 100);
		add(complaintsScrollPane);

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.BOLD, 18));
		submitButton.setBounds(380, 560, 110, 40);
		add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nametf.getText();
				String accountNumber = accounttf.getText();
				int rating = ratingSlider.getValue();
				String reason = (String) reasonCombo.getSelectedItem();
				String comments = commentsArea.getText();
				String complaints = complaintsArea.getText();

				// Check if any of the required fields are empty
				if (name.isEmpty() || accountNumber.isEmpty() || comments.isEmpty() || complaints.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill the required fields");
				} else {

					try {
						JdbcConn jc = new JdbcConn();
						// SQL query to insert feedback into the "feedback" table
						String sql = "INSERT INTO feedback (name, account_number, rating, reason, comments, complaints) "
								+ "VALUES (?, ?, ?, ?, ?, ?)";

						PreparedStatement preparedStatement = jc.con.prepareStatement(sql);
						preparedStatement.setString(1, name);
						preparedStatement.setString(2, accountNumber);
						preparedStatement.setInt(3, rating);
						preparedStatement.setString(4, reason);
						preparedStatement.setString(5, comments);
						preparedStatement.setString(6, complaints);

						int rowsAffected = preparedStatement.executeUpdate();
						if (rowsAffected > 0) {
							JOptionPane.showMessageDialog(null, "Feedback submitted successfully");
						} else {
							JOptionPane.showMessageDialog(null, "Failed to submit feedback");
						}

						jc.con.close();
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error while submitting feedback");
					}
				}
			}
		});

		getContentPane().setBackground(Color.lightGray);
		setSize(600, 800);
		setLocation(100, 50);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Feedback("");

	}
}
