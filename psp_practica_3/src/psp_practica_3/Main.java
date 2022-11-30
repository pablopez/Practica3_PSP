package psp_practica_3;

public class Main {
	private UserInterface ui;
	private UserListManager user_manager;
	private byte[] encrypted_phrase;
	private MyCipher c;
	private int try_login_cont = 0;
	
	public Main() {
		this.user_manager = new UserListManager();
		this.ui =  UserInterface.getUi();
		this.encrypted_phrase = null;
	}	

	public int getAction() {
		return this.ui.actionChooser();
	}
	
	public void cifra() {
		String sentence = this.ui.requireSentence();
		this.encrypted_phrase = c.encode(sentence);
		System.out.println("frase cifrada: "+new String(this.encrypted_phrase));
	}
	
	public void  descifra() {
		if(this.encrypted_phrase != null) {
			System.out.println(c.decode(this.encrypted_phrase));
		}else {
			System.out.println("no hay ninguna frase en memoria...\n");
		}		
	}
	
	public boolean doAction() {
		int current_action = this.ui.actionChooser();
		if(current_action == 1) {
			this.cifra();
		}else if(current_action == 2) {
			this.descifra();
		}else if(current_action == 0) {			
			return false;
		}else {
			System.out.println("acción no disponible");			
		}
		return true;
	}
	
	public boolean login() {
		if(this.c == null) {
			User u = this.ui.requestAuth();
			if(this.user_manager.login(u)) {
				this.c = MyCipher.getCipher();
				System.out.println("¡Hola "+u.getUsername()+"!");
				return true;
			}
			try_login_cont++;
			return false;
		}else {
			return true;
		}		
	}
	
	public boolean maxTries() {
		return try_login_cont == 3;
	}
	
	public static void main(String[] args) {
		Main app = new Main();
		while(true) {
			if(!app.maxTries()) {
				if(app.login()) {
					if(!app.doAction()) {
						break;
					}
				}else {
					System.out.println("Usuario no valido, intentelo de nuevo");
				}
			}else {
				System.out.println("Has alcanzado el numero maximo de intentos.");
				break;
			}									
		}
		System.out.println("Fin del programa. Adios.");
		
	}

}
