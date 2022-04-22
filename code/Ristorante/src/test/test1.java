package test;
import ristorante.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import prog.utili.Data;

class test1 {
	Ingrediente i = new Ingrediente("mais", 2, new Data(22, 06, 2000), 5);
	@Test
	void test() {

		assertEquals(5, i.getPrezzo());
	}
	void test3() {

		assertEquals(5, i.getPrezzo());
	}
	void test2() {

		assertEquals(5, i.getPrezzo());
	}


}
