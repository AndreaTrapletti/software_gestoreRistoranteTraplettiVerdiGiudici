import java.util.Vector;

public class ListaIngredienteScadutiFiniti {
	protected Vector<Ingrediente> listaIngredienteScadutiFiniti = new Vector<>();
	public ListaIngredienteScadutiFiniti() {}
	
	public void AddIngrediente(Ingrediente i) {
		listaIngredienteScadutiFiniti.add(i);
	}
}
