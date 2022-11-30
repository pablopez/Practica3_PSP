package psp_practica_3;

public class User {
	private String pass;
	private String username;
	public User(String username, String pass) {
		this.username = username;
		this.pass = HashMaker.hashSHA512(pass);		
	}
	
	public boolean login(User u) {
		return this.pass.equals(u.getPass()) && this.username.equals(u.getUsername());
	}

	public String getUsername() {
		return username;
	}
	public String getPass() {
		return pass;
	}
}
