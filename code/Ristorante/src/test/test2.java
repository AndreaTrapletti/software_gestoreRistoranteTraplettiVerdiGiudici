package test;
import ristorante.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import prog.utili.Data;
class test2 {

	Ingrediente i = new Ingrediente("mais", 2, new Data(22, 06, 2000), 5);
	Piatto popcorn = new Piatto("popcorn", i, 3);
	@Test
	void test() {
		popcorn.ModificaPrezzo(3.25)
		assertEquals(3.25, popcorn.prezzo);
	}
	void test2() {
		Ingrediente i2 = new Ingrediente("burro", 2, new Data(22, 06, 2000), 5);
		popcorn.ModificaIngrediente( i2, true)
		
		assertEquals("burro", i2.ingredienti.elementAt(1).name());
	}
	void test3() {

		assertEquals(new Data(22, 06, 2000), i.getScadenza());
	}
	
	void testIngrediente1() {
		
		assertEquals(true, i.ControlloScadenza());
	}
	
	void testIngrediente2() {

		assertEquals(true, i.ControlloQuantita());
	}

}
