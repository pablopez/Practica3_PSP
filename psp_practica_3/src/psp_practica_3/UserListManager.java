package psp_practica_3;

import java.util.ArrayList;

public class UserListManager {
	private ArrayList<User> users= new ArrayList<User>();
	
	public UserListManager() {
		this.loadDefaults();
	}
	
	public boolean login(User user) {
		for(User u : users) {
			if(u.login(user)) {
				return true;
			}
		}
		return false;
	}
	
	private void loadDefaults() {
		this.users.add(new User("usuario1", "usuario1"));
		this.users.add(new User("usuario2", "usuario2"));
		this.users.add(new User("usuario3", "usuario3"));
	}
}
