package ristorante;
import java.util.Vector;

public class PiattiOrdinati {

	protected Vector<Piatto> piattiOrdinati = new Vector<>();
	protected int Tavolo; 
	protected int num_Persone;
	
	
	public PiattiOrdinati( int tavolo, int num_Persone, Vector<Piatto> piatti) {
	
		this.piattiOrdinati = piatti;
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
	}

	public PiattiOrdinati(int tavolo, int num_Persone) {
		
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
	}
	
	public PiattiOrdinati( int tavolo, int num_Persone, Piatto piatti) {
		
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
		this.AddPiatto(piatti);
	}
	
		public void AddPiatto(Piatto piatto) {
			int count =0 ;
			
				for(int k = 0; k < piatto.ingredienti.size();k++) {
					if (ListaIngrediente.RemoveQuantità(piatto.ingredienti.elementAt(k).name,1)) 
						count++;
		}
				if (count == piatto.ingredienti.size()) {
					piattiOrdinati.add(piatto);
				System.out.println("piatto aggiunto correttamente");}
				else System.out.println("piatto non ordinabile");
				}
		public void RemovePiatto(Piatto piatto) {
			boolean check = false;
			for(int i= 0; i<=piattiOrdinati.size(); i++) {
				if(check=false) {
				if(piattiOrdinati.elementAt(i).Nome==piatto.Nome) {
					piattiOrdinati.remove(i);
					check=true;
					System.out.println("piatto rimosso");
					}
				}
			}
		}
		
		public double Totale() {
			double totale = 0;
			for(int i = 0; i < piattiOrdinati.size();i++) {
				totale = totale + piattiOrdinati.elementAt(i).Prezzo;
			}
			totale += (Menù.Coperto*num_Persone);
			return totale;
		}
		
		public double TotaleRomana() {
			double totale = Totale();
			return totale/num_Persone;
		}
		public Vector<Ingrediente> CalcoloIngredienti() {
			Vector<Ingrediente> ingredientireturn= new Vector<>();
			for(int i= 0; i<=piattiOrdinati.size(); i++) {
				for(int k = 0; k <=piattiOrdinati.elementAt(i).ingredienti.size();k++) {
					ingredientireturn.add(piattiOrdinati.elementAt(i).ingredienti.elementAt(k));
				}
			}
			return ingredientireturn;
		}
	
}
