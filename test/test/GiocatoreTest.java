package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
    private Borsa borsa;
    private Giocatore giocatore;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.giocatore = new Giocatore();
	}

	@Test
	void testGetCfuPresente() {
		this.giocatore.setCfu(20);
		assertNotNull(this.giocatore.getCfu());
	}
	
	@Test
	void testGetCfuGiocoNonIniziato() {
		this.giocatore.setCfu(0);
		assertEquals(0,this.giocatore.getCfu());
	}
	
	@Test
	void testGetBorsaPresente() {
		this.giocatore.setBorsa(borsa);
		assertNotNull(this.giocatore.getBorsa());
	}
	@Test
	void testGetBorsaNonPresente() {
		this.giocatore.setBorsa(null);
		assertNull(this.giocatore.getBorsa());
	}
}
