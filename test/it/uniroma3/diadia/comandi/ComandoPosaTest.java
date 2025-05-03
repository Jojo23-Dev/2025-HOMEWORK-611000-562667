package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class ComandoPosaTest {
	private ComandoPosa cp;
	private Partita p;
	
	@BeforeEach
	void setUp()  {
		cp=new ComandoPosa();
		p=new Partita();
	}
	// test metodo t
	@Test
	void testSetNull() {
		assertEquals(null,cp.getParametro());
	}

}
