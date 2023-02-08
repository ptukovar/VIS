package BusinessLayer.Objects;

public class User {
	public String name;
	public String password;
	public String role="";
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.role = "Seller";
	}
	
}
