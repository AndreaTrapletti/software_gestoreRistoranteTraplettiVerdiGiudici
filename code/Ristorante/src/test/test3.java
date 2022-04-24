package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import prog.utili.Data;
import ristorante.Ingrediente;
import ristorante.ListaIngrediente;

class test3 {
    
	public Ingrediente i1 = new Ingrediente("mais", 2, new Data(22, 06, 2000), 5);
	public Ingrediente i2 = new Ingrediente("avena", 5, new Data(22, 06, 2000),  1);
	public ListaIngrediente lista = new ListaIngrediente();
	@Test
	public void testAddLista() {
		lista.AddIngrediente(i1);
		lista.AddIngrediente(i2);
		assertEquals("avena", ListaIngrediente.lista.elementAt(1).getName());
	}
	@Test
	public void testRemoveLista() {
		lista.AddIngrediente(i1);
		lista.AddIngrediente(i2);
		lista.RemoveIngrediente(i1);
		assertEquals(3, ListaIngrediente.lista.size());
	}
	@Test
	public void testListaQuantita() {
		lista.AddIngrediente(i1);
		lista.AddIngrediente(i2);
		ListaIngrediente.AumentaQuantita(i1.getName(), 3);
		assertEquals(5, ListaIngrediente.lista.elementAt(0).getQtd());
	}
	@Test
	public void testListaQuantita2() {
		lista.AddIngrediente(i1);
		lista.AddIngrediente(i2);
		ListaIngrediente.RemoveQuantita(i2.getName(), 5);
		assertEquals(0, ListaIngrediente.lista.elementAt(1).getQtd());
	}
	@Test
	public void testListaCambioData() {
		lista.AddIngrediente(i1);
		ListaIngrediente.cambioData(i1.getName(), new Data(22, 06, 2023));
		assertEquals(new Data(22, 06, 2023), ListaIngrediente.lista.elementAt(0).getScadenza());
	}
}
