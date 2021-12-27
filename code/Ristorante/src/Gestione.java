import java.util.concurrent.Semaphore;

import prog.utili.Data;

public class Gestione {
	
	public Semaphore mutex;  
	public Semaphore mutex2;
		
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
				ListaIngredienteScadutiFiniti.AddIngrediente(ListaIngrediente.lista.elementAt(i));
				ListaIngrediente.RemoveQuantità(ListaIngrediente.lista.elementAt(i).name, ListaIngrediente.lista.elementAt(i).qtd);
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
			
				int qtd = (int) (Math.random()*50);
				Data data = new Data();
				int random = (int) (Math.random()*10);
				int mese = data.getMese() + random;
				data = new Data(data.getGiorno(), mese, data.getAnno());
				ListaIngrediente.AumentaQuantità(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).name, qtd);
				ListaIngrediente.cambioData(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i).name, data);
				Menù.abilita(ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.elementAt(i));
				ListaIngredienteScadutiFiniti.listaIngredienteScadutiFiniti.remove(i);
				System.out.println("il fornitore ha aggiunto ingredienti al magazzino");
				
				
			
 		}
		mutex.release();
	}
}
