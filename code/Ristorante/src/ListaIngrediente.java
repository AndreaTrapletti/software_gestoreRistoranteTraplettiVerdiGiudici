import java.util.Vector;

public class ListaIngrediente {
	public Vector<Ingrediente> lista = new Vector<>();
	public ListaIngrediente() {}
	public void AddIngrediente(Ingrediente i) {
		lista.add(i);
	}
	
	public void RemoveIngrediente(Ingrediente i) {
		lista.remove(i);
	}
}
