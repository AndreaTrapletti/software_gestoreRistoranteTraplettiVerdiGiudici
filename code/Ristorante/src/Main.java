import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import prog.utili.Data;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaIngredienteScadutiFiniti listaScadutiFiniti = new ListaIngredienteScadutiFiniti();
		ListaIngrediente lista = new ListaIngrediente();
		Ingrediente i1 = new Ingrediente("mela", 50, new Data(10, 01, 2022), 22);
		Ingrediente i2 = new Ingrediente("carne", 20, new Data(22, 01, 2022), 120);
		Ingrediente i3 = new Ingrediente("riso", 100, new Data(22, 01, 2024), 99);
		Ingrediente i4 = new Ingrediente("CocaCola", 1, new Data(22, 06, 2023), 200);
		Ingrediente i5 = new Ingrediente("Funghi porcini", 5, new Data(13, 02, 2022), 16);
		lista.AddIngrediente(i1);
		lista.AddIngrediente(i2);
		lista.AddIngrediente(i3);
		lista.AddIngrediente(i4);	
		lista.AddIngrediente(i5);
		Piatto CocaCola = new Piatto("CocaCola", i4, 3);
		Piatto CarneFung = new Piatto("Bistecca ai porcini",i5,6.90);
		Menù menu = new Menù(CocaCola);
		menu.AddPiatto(CarneFung);
		CarneFung.ModificaIngrediente(i2,true);
		PiattiOrdinati tavolo1 = new PiattiOrdinati(1, 4);
		tavolo1.AddPiatto(CarneFung);
		tavolo1.AddPiatto(CocaCola);
		System.out.println("il totale del tavolo 1 è :" + tavolo1.TotaleRomana()+ " €");
		for(int i = 0; i< lista.lista.size();i++) {
			System.out.println(" ingrediente : "+ lista.lista.elementAt(i).name + " qt: "+ lista.lista.elementAt(i).qtd);
		}
		
        Thread fornitore = new Thread(new Fornitore("Mattia", "Giudici", "fornitore1"));
		
		fornitore.run();
		fornitore.start();
		
		while(true) {
			loopControllo(lista.lista, listaScadutiFiniti.listaIngredienteScadutiFiniti, menu);
			try {
			    TimeUnit.SECONDS.sleep(10);  //fallo ogni giorno = 86400secondi
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
		}
		
	}
	
	public static void loopControllo(Vector<Ingrediente> lista, Vector<Ingrediente> listaScadutiFiniti, Menù menu) {
		for(int i=0; i<lista.size(); i++) {
			if(lista.elementAt(i).ControlloQuantita() == false || lista.elementAt(i).ControlloScadenza() == false) {
				listaScadutiFiniti.addElement(lista.elementAt(i));
				menu.disabilita(lista.elementAt(i));
				System.out.print("i piatti contenuti ora nel menù sono: " );
				for(int k=0; k<menu.piatti.size(); k++) {
					System.out.println(menu.piatti.elementAt(k).Nome.toString());
				}
			}
			//System.out.print(lista.elementAt(i).name.toString());
		}

		
	}
}
