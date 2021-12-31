
import java.util.Observable;
import java.util.Vector;

import prog.utili.Data;


public class Ingrediente  {
	
	protected String name = "";
	protected int qtd = 0;
	protected Data scadenza = new Data(31, 12, 2030);
	protected float prezzo = 0;
	public Ingrediente(String name, int qtd, Data scadenza, float prezzo) {
		this.name = name;
		this.qtd = qtd;
		this.scadenza = scadenza;
		this.prezzo = prezzo;
		
	}
	public String getName() {
		return name;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public Data getScadenza() {
		return scadenza;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	public boolean ControlloScadenza() {
		Data oggi = new Data();
		if(oggi.equals(this.scadenza) || oggi.isMaggiore(this.scadenza)) {
			
			return false;
		}
			
		else 
			return true;
	}
	public boolean ControlloQuantita() {
		if(this.qtd>0)
			return true;
		else return false;
	}
	
}
 