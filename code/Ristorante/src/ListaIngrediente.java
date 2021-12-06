import java.util.Vector;

import prog.io.ConsoleInputManager;

public class ListaIngrediente {
	public  static Vector<Ingrediente> lista = new Vector<>();
	public ListaIngrediente() {}
	public void AddIngrediente(Ingrediente i) {
		lista.add(i);
	}
	
	public void RemoveIngrediente(Ingrediente i) {
		lista.remove(i);
	}
	public void AumentaQuantit�(String nome, int qt) {
		boolean check = false; 
		for(int i = 0; i<lista.size(); i++) {
			if(lista.elementAt(i).name == nome && check == false) {
				lista.elementAt(i).qtd += qt;
				check = true;
			}
		}
		if(check == true)
			System.out.println("quantit� aggiunta correttamente");
		else {
			System.out.println("Ingrediente non trovato, si consiglia di aggiungerlo");
		}
	}
	public static void RemoveQuantit�(String nome, int qt) {
		boolean check = false; 
		for(int i = 0; i<lista.size(); i++) {
			if(lista.elementAt(i).name == nome && check == false) {
				check = true;
				int a = lista.elementAt(i).qtd - qt;
				if(a >=0 ) {
					System.out.println("quantit� rimossa correttamente");
					lista.elementAt(i).qtd = a;
				}
				else{
					System.out.println("quantit� non disponibile mancano : "+ (0-a) + " pezzi");
				}
					
				
			}
		}
		if(check != true)
			System.out.println("Ingrediente non trovato, si consiglia di aggiungerlo");
	}
	
	
	
}
