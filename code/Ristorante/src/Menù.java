import java.util.Vector;

public class Menù {
	Vector<Piatto> piatti = new Vector<>();
	protected static double Coperto = 2.50;

	public Menù(Vector<Piatto> piatti) {
	
		this.piatti = piatti;
	}
	public Menù(Piatto piatti) {
		
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
		Menù.Coperto = coperto;
	}
	public void disabilita(Ingrediente ing) {
		boolean check= false;
		for(int i = 0; i<piatti.size();i++) {
			for(int k = 0; k < piatti.elementAt(i).ingredienti.size();k++) {
				if(piatti.elementAt(i).ingredienti.elementAt(k).name.equals(ing.name)) {
					piatti.elementAt(i).attivo=false;
					check=true;
				}
			}
		}
		if(check==false)System.out.println("nessun piatto contiene questo ingrediente");
		else System.out.println("tutti i piatti non più disponibili sono stati disattivati");
	}
	public void abilita(Ingrediente ing) {
		for(int i = 0; i<piatti.size();i++) {
			for(int k = 0; k < piatti.elementAt(i).ingredienti.size();k++) {
				if(piatti.elementAt(i).ingredienti.elementAt(k).name.equals(ing.name)) {
					piatti.elementAt(i).attivo=true;
				}
			}
		}
	}
}
