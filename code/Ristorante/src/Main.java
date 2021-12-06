import prog.utili.Data;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaIngredienteScadutiFiniti listaScadutiFiniti = new ListaIngredienteScadutiFiniti();
		ListaIngrediente lista = new ListaIngrediente();
		Gestione gestore = new Gestione(); 
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
		for(int i = 0; i< ListaIngrediente.lista.size();i++) {
			System.out.println(" ingrediente : "+ ListaIngrediente.lista.elementAt(i).name + " qt: "+ ListaIngrediente.lista.elementAt(i).qtd);
		}
	
        Fornitore fornitore = new Fornitore("Mattia", "Giudici", "fornitore1", gestore);
		Sistema sistema = new Sistema(gestore);
		fornitore.start();
		sistema.start();		
	}
}
	
