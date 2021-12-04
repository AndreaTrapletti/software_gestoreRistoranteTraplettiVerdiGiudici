
import java.util.Vector;

import prog.utili.Data;

public class Fornitore extends Thread{
	protected String nome;
	protected String cognome;
	
	public Fornitore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	public Fornitore(String nome, String cognome, String s) {
		this.nome = nome;
		this.cognome = cognome;
		setName(s);
	}
	public void run(Vector<Ingrediente> listaScadutiFiniti, Vector<Ingrediente> lista) {
		while(true) {
		if(listaScadutiFiniti.size()==0) return;
		for(int i=0; i<listaScadutiFiniti.size(); i++) {
			if(listaScadutiFiniti.elementAt(i).qtd <= 0) {
				int qtd = (int) (Math.random()+0.1)*10;
				
				
				Ingrediente daInserire = new Ingrediente(listaScadutiFiniti.elementAt(i).name,qtd, 
						listaScadutiFiniti.elementAt(i).scadenza, listaScadutiFiniti.elementAt(i).prezzo);
				lista.add(daInserire);
				
				listaScadutiFiniti.remove(i);
				System.out.println("il fornitore ha aggiunto ingredienti al magazzino");
			}
			if(listaScadutiFiniti.elementAt(i).scadenza.isMinore(new Data())) {
			
				Data data = new Data();
				int mese = data.getMese() + (int) (0.1 + Math.random())*10;
				data = new Data(data.getGiorno(), mese, data.getAnno());
				
				Ingrediente daInserire = new Ingrediente(listaScadutiFiniti.elementAt(i).name, 
						listaScadutiFiniti.elementAt(i).qtd, data, listaScadutiFiniti.elementAt(i).prezzo);
				lista.add(daInserire);
				listaScadutiFiniti.remove(i);
				System.out.println("il fornitore ha aggiunto ingredienti al magazzino");
			}
			
 		}
		}
	}

}
