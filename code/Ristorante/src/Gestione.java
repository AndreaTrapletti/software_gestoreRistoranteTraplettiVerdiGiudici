import java.util.concurrent.Semaphore;

import prog.utili.Data;

public class Gestione {
	
	Semaphore mutex;  
	Semaphore mutex2;
		
	public Gestione(){
		mutex = new Semaphore(1,true);
		mutex2 = new Semaphore(1,true);
	}
	public void loopcontrollo() {
		try {
			mutex.acquire();
		}catch (InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		for(int i=0; i<ListaIngrediente.lista.size(); i++) {
			if(ListaIngrediente.lista.elementAt(i).ControlloQuantita() == false || ListaIngrediente.lista.elementAt(i).ControlloScadenza() == false) {
				if(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.contains(ListaIngrediente.lista.elementAt(i))!=true) {
				ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.addElement(ListaIngrediente.lista.elementAt(i));
				Menù.disabilita(ListaIngrediente.lista.elementAt(i));}
				Menù.stampa();
			}
		}
		ListaIngredienteScadutiFiniti.stampa();
		mutex.release();
	}
	
	
	public void rifornimento() {
		try {
			mutex.acquire();
		}catch (InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		if(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.size()==0) return;
		for(int i=0; i<ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.size(); i++) {
			if(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).qtd <= 0) {
				int qtd = (int) (Math.random()+0.1)*10;
			
				
				Ingrediente daInserire = new Ingrediente(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).name,qtd, 
						ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).scadenza, ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).prezzo);
				ListaIngrediente.lista.add(daInserire);
	
				ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.remove(i);
				System.out.println("il fornitore ha aggiunto ingredienti al magazzino");
			}
			else if(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).scadenza.isMinore(new Data())) {
			
				Data data = new Data();
				int mese = data.getMese() + (int) (0.1 + Math.random())*10;
				data = new Data(data.getGiorno(), mese, data.getAnno());
				
				Ingrediente daInserire = new Ingrediente(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).name, 
						ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).qtd, data, ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).prezzo);
				ListaIngrediente.lista.add(daInserire);
				ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.remove(i);
				System.out.println("il fornitore ha aggiunto ingredienti al magazzino");
			}
			
 		}
		mutex.release();
	}
}
