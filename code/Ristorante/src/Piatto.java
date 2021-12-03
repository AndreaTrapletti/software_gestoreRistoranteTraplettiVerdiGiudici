import java.util.Vector;

public class Piatto {
	protected String Nome; 
	protected Vector<Ingrediente> ingredienti = new Vector<>();
	double Prezzo;
	boolean attivo = true;
	public Piatto(String nome, Vector<Ingrediente> ingredienti, double prezzo) {
		Nome = nome;
		this.ingredienti = ingredienti;
		Prezzo = prezzo;
	} 
		
	public Piatto(String nome, Ingrediente ingredienti, double prezzo) {
		Nome = nome;
		this.ingredienti.add(ingredienti);
		Prezzo = prezzo;
	} 
	
	public void ModificaIngrediente(Ingrediente ingrediente, boolean AddRemove){ //true = aggiungi ingrediente, false = rimuovi
		if (AddRemove == true) {
			this.ingredienti.add(ingrediente);
			System.out.println("Ingrediente aggiunto correttamente");
		}else {
			boolean controllo = false;
			for(int i = 0; i<= this.ingredienti.size(); i++) {
				if(ingredienti.elementAt(i).name ==ingrediente.name) {
					controllo = true;
					ingredienti.remove(i);
				}
			}
			if(controllo == true)
				System.out.println("ingrediente Rimosso con successo");
			else
				System.out.println("ingrediente non trovato");
		}
		
		
	}
	public void ModificaPrezzo(double NuovoPrezzo) {
		this.Prezzo = NuovoPrezzo; 
		System.out.println("il prezzo è stato correttamente aggiornato");
	}
}
