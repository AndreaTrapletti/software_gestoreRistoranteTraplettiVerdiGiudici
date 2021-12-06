import java.awt.Menu;
import java.util.Vector;

public class Men� {
	protected static Vector<Piatto> piatti = new Vector<>();
	protected static double Coperto = 2.50;

	public Men�(Vector<Piatto> piatti) {
	
		this.piatti = piatti;
	}
	public Men�(Piatto piatti) {
		
		this.piatti.add(piatti);
	}
	public void AddPiatto(Piatto piatto) {
		piatti.add(piatto);
		System.out.println("piatto aggiunto correttamente");
	}
	public void RemovePiatto(Piatto piatto) {
		boolean check = false;
		for(int i= 0; i<=piatti.size(); i++) {
			if(check=false) {
			if(piatti.elementAt(i).Nome==piatto.Nome) {
				piatti.remove(i);
				check=true;
				System.out.println("piatto rimosso");
				}
			
				}else
					System.out.println("piatto non trovato");
		}
	}
	public void ModificaCoperto(double coperto) {
		Men�.Coperto = coperto;
	}
	public static void disabilita(Ingrediente ing) {
		boolean check= false;
		boolean presente = false;
		Vector<Piatto> disattivati = new Vector<>();
		for(int i = 0; i<piatti.size();i++) {
			for(int k = 0; k < piatti.elementAt(i).ingredienti.size();k++) {
				
				if(piatti.elementAt(i).ingredienti.elementAt(k).name.equals(ing.name)) {
					check = true;
					if(piatti.elementAt(i).attivo==true) {
						piatti.elementAt(i).attivo=false;
						disattivati.add(piatti.elementAt(i));
					}
					else {
						presente=true;
					}
					
				}
			
			}
			
		}
	
		if(check==true && presente == false) {
			System.out.print("i piatti non pi� disponibili sono stati disattivati: ");
			for(int i=0; i<disattivati.size(); i++) {
			System.out.println(disattivati.elementAt(i).Nome.toString());
			aggiornaMenuNegativo();
			}
		}

		
	}
	public static void aggiornaMenuNegativo() {
		for(int i=0; i<piatti.size(); i++) {
			if(piatti.elementAt(i).attivo == false) {
				piatti.remove(i);
			}
		}
	}
	
	public void abilita(Ingrediente ing) {
		for(int i = 0; i<piatti.size();i++) {
			for(int k = 0; k < piatti.elementAt(i).ingredienti.size();k++) {
				if(piatti.elementAt(i).ingredienti.elementAt(k).name.equals(ing.name)) {
					piatti.elementAt(i).attivo=true;
					aggiornaMenuPositivo(piatti.elementAt(i));
				}
			}
		}
	}
	public void aggiornaMenuPositivo(Piatto p) {
		piatti.add(p);
	}
	public static void stampa() {
		System.out.print("i piatti contenuti ora nel men� sono: " );
		for(int k=0; k<piatti.size(); k++) {
			System.out.println(piatti.elementAt(k).Nome.toString());
		}
	}
}
