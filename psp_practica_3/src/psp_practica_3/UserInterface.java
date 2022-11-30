package psp_practica_3;

import java.util.Scanner;

public class UserInterface {
	private final String menustr = 
			"Seleccione una opcion introduciéndo el numero marcado: \n\n"+ 	
				"\t0. Salir del programa \n"+
				"\t1. Encriptar frase \n"+
				"\t2. Desencriptar frase \n\n";
	private final Scanner sc = new Scanner(System.in);
	
	public int actionChooser() {
		System.out.println(menustr);
		while(true) {
			try {
				String opstr = sc.nextLine();				
				int op = Integer.parseInt(opstr);
				if(op >= 0 && op <=2) {
					return op;
				}else {
					throw new NumberFormatException();
				}
			}catch(NumberFormatException e){  
				System.out.println("Introduzca una opcion valida o pulse 0 para salir");  
			}			
		}
	}
	
	public User requestAuth() {		
		System.out.println("\n Introduzca nombre de usuario:");
		String username = sc.nextLine();
		System.out.println("Introduzca password:");
		String pass = sc.nextLine();
		return new User(username, pass);
	}
	
	public String requireSentence() {
		System.out.println("Introduzca una frase:");
		return sc.nextLine();
	}
	
	public static UserInterface getUi() {
		return new UserInterface();
	}		

}
