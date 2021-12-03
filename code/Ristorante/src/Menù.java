
public class Menù {
	Piatto piatti[];
	protected static double Coperto = 2.50;

	public Menù(Piatto[] piatti) {
	
		this.piatti = piatti;
	}
	public Menù(Piatto piatti) {
		
		this.piatti[0] = piatti;
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
	public void ModificaCoperto(double coperto) {
		Menù.Coperto = coperto;
	}
}
