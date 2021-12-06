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
	public void AumentaQuantità(String nome, int qt) {
		boolean check = false; 
		for(int i = 0; i<lista.size(); i++) {
			if(lista.elementAt(i).name == nome && check == false) {
				lista.elementAt(i).qtd += qt;
				check = true;
			}
		}
		if(check == true)
			System.out.println("quantità aggiunta correttamente");
		else {
			System.out.println("Ingrediente non trovato, si consiglia di aggiungerlo");
		}
	}
	public static void RemoveQuantità(String nome, int qt) {
		boolean check = false; 
		for(int i = 0; i<lista.size(); i++) {
			if(lista.elementAt(i).name == nome && check == false) {
				check = true;
				int a = lista.elementAt(i).qtd - qt;
				if(a >=0 ) {
					System.out.println("quantità rimossa correttamente");
					lista.elementAt(i).qtd = a;
				}
				else{
					System.out.println("quantità non disponibile mancano : "+ (0-a) + " pezzi");
				}
					
				
			}
		}
		if(check != true)
			System.out.println("Ingrediente non trovato, si consiglia di aggiungerlo");
	}
	
	
	
}
