
public class Piatto {
	protected String Nome; 
	protected Ingrediente ingredienti[];
	float Prezzo;
	public Piatto(String nome, Ingrediente[] ingredienti, float prezzo) {
		Nome = nome;
		this.ingredienti = ingredienti;
		Prezzo = prezzo;
	} 
		
	public Piatto(String nome, Ingrediente ingredienti, float prezzo) {
		Nome = nome;
		this.ingredienti[0]= ingredienti;
		Prezzo = prezzo;
	} 
	
	public void ModificaIngrediente(Ingrediente ingrediente, boolean AddRemove){ //true = aggiungi ingrediente, false = rimuovi
		if (AddRemove == true) {
			this.ingredienti[ingredienti.length+1] = ingrediente;
			System.out.println("Ingrediente aggiunto correttamente");
		}else {
			boolean controllo = false;
			for(int i = 0; i<= this.ingredienti.length; i++) {
				if(ingredienti[i].Nome ==ingrediente.Nome) {
					controllo = true;
					Ingrediente momentaneo[]= ingredienti;
					for(int k = 0; k<i;k++) {
						ingredienti[k]= momentaneo[k];
					}
					for (int k =i+1;k<momentaneo.length; k++) {
						ingredienti[k-1]=momentaneo[k];
					}
				}
			}
			if(controllo == true)
				System.out.println("ingrediente Rimosso con successo");
			else
				System.out.println("ingrediente non trovato");
		}
		
		
	}
	public void ModificaPrezzo(float NuovoPrezzo) {
		this.Prezzo = NuovoPrezzo; 
		System.out.println("il prezzo è stato correttamente aggiornato");
	}
}
