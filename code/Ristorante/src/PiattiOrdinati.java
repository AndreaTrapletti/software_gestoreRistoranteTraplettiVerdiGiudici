
public class PiattiOrdinati {

	protected Piatto piatti[];
	protected int Tavolo; 
	protected int num_Persone;
	protected static double Coperto = 2.5;
	
	public PiattiOrdinati(Piatto[] piatti, int tavolo, int num_Persone) {
	
		this.piatti = piatti;
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
	}

	public PiattiOrdinati(int tavolo, int num_Persone) {
		
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
	}
	
	public PiattiOrdinati(Piatto piatti, int tavolo, int num_Persone) {
		
		this.piatti[0] = piatti;
		Tavolo = tavolo;
		this.num_Persone = num_Persone;
	}
	
		public void AddPiatto(Piatto piatto) {
			piatti[piatti.length+1]=piatto;
			System.out.println("piatto aggiunto correttamente");
		}
		public void RemovePiatto(Piatto piatto) {
			boolean check = false;
			for(int i= 0; i<=piatti.length; i++) {
				if(check=false) {
				if(piatti[i].Nome==piatto.Nome) {
					Piatto momento[]=piatti;
					for(int k=0; k<i;k++) {
						piatti[k]= momento[k];
						
					}
					for(int k=i+1; k<momento.length; k++) {
						piatti[k-1]=momento[k];
					}
					check=true;
					System.out.println("piatto rimosso");
					}
				
					}
			}
		}
		
		public float Totale() {
			float totale = 0;
			for(int i = 0; i <= piatti.length;i++) {
				totale = totale + piatti[i].Prezzo;
			}
			totale += (Coperto*num_Persone);
			return totale;
		}
		
		public float TotaleRomana() {
			float totale = Totale();
			return totale/num_Persone;
		}
		public Ingrediente[] CalcoloIngredienti() {
			Ingrediente ingredientireturn[]= null;
			for(int i= 0; i<=piatti.length; i++) {
				for(int k = 0; k <=piatti[i].ingredienti.length;k++) {
					ingredientireturn[ingredientireturn.length+k]=piatti[i].ingredienti[k];
				}
			}
			return ingredientireturn;
		}
	
}
