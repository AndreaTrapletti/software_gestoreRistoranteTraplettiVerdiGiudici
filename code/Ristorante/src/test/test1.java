package test;
import ristorante.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import prog.utili.Data;

class test1 {
	Ingrediente i = new Ingrediente("mais", 2, new Data(22, 06, 2000), 5);
	@Test
	void testPrezzo() {

		assertEquals(5, i.getPrezzo());
	}
	@Test
	void testQuantita() {

		assertEquals(2, i.getQtd());
	}
	@Test
	void testScadenza() {

		assertEquals(new Data(22, 06, 2000), i.getScadenza());
	}
	@Test
	void testScadenza2() {
		
		assertEquals(false, i.ControlloScadenza());
	}
	@Test
	void testQuantita2() {

		assertEquals(true, i.ControlloQuantita());
	}
}
