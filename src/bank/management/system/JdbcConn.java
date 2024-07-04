package bank.management.system;

import java.sql.*;

public class JdbcConn {
	Connection con;
	Statement st;
	ResultSet result;

	public JdbcConn() {
		String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
		String user = "root";
		String password = "Mysql@7862";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
