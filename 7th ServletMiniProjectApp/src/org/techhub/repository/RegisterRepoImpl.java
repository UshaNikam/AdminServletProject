package org.techhub.repository;

import org.techhub.model.Register;
import java.sql.*;

public class RegisterRepoImpl implements RegisterRepo {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public RegisterRepoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","system");
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
	}

	@Override
	public boolean isRegister(Register model) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement("insert into smreg values('0',?,?,?,?,?)");
			stmt.setString(1,model.getName());
			stmt.setString(2,model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4, model.getUsername());
			stmt.setString(5,model.getPassword());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error  is " + ex);
			return false;
		}
		 
	}

}













