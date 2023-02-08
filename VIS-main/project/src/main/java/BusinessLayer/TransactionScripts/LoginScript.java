package BusinessLayer.TransactionScripts;

import java.sql.SQLException;

import BusinessLayer.Objects.User;
import DataLayer.Database.LoginDB;

public class LoginScript {
	private LoginDB ldb = new LoginDB();
	
	public boolean login(String name, String password) throws SQLException {
		if(name.isEmpty() || password.isEmpty()) {
			return false;
		}else {
			User temp = new User(name, password);
			return ldb.loginTable(temp);
		}
	}
}
