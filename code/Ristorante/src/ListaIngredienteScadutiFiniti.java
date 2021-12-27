import java.util.Vector;

public class ListaIngredienteScadutiFiniti {
	protected static Vector<Ingrediente> listaIngredienteScadutiFiniti = new Vector<>();
	public ListaIngredienteScadutiFiniti() {}
	
	public static void AddIngrediente(Ingrediente i) {
		listaIngredienteScadutiFiniti.add(i);
	}

	public static void stampa() {
		for(int k = 0; k< listaIngredienteScadutiFiniti.size();k++) {
			System.out.println(" ingrediente da comprare: "+ listaIngredienteScadutiFiniti.elementAt(k).name);
		}
	}
}
