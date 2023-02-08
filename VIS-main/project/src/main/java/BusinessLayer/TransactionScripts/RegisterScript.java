package BusinessLayer.TransactionScripts;

import java.sql.SQLException;

import BusinessLayer.Objects.User;
import DataLayer.Database.LoginDB;

public class RegisterScript {
	private LoginDB ldb = new LoginDB();
	
	public boolean register(String name, String password, String passwordCheck) throws SQLException {
		if(name.isEmpty() || password.isEmpty() || passwordCheck.isEmpty()) {
			System.out.println("999");
			return false; 
		}else if(password.equals(passwordCheck)) {
			User temp = new User(name, password);
			return ldb.register(temp);
		}
		System.out.println("888");
		return false;
	}
}
