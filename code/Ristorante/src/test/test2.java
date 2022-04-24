package test;
import ristorante.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import prog.utili.Data;
class test2 {

	Ingrediente i = new Ingrediente("mais", 2, new Data(22, 06, 2000), 5);
	Piatto popcorn = new Piatto("popcorn", i, 3);
	@Test
	void testPiattoPrezzo() {
		popcorn.ModificaPrezzo(3.25);
		assertEquals(3.25, popcorn.getPrezzo());
	}
	@Test
	void testPiattoIngrediente() {
		Ingrediente i2 = new Ingrediente("burro", 2, new Data(22, 06, 2000), 5);
		popcorn.ModificaIngrediente( i2, true);
		
		assertEquals("burro", popcorn.getListaIngredienti().elementAt(1).getName());
	}
}
