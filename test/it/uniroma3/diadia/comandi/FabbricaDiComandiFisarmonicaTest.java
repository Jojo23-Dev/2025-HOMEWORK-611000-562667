package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fdcf;
	private Comando c;
	@BeforeEach
	void setUp() throws Exception {
		fdcf = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	void testComandoVai() throws Exception {
		c=new ComandoVai();
		assertEquals(c.getNome(),fdcf.costruisciComando("vai").getNome());
	}
	
	@Test
	void testComandoNonValido() throws Exception {
		c=new ComandoNonValido();
		assertEquals(c.getNome(),fdcf.costruisciComando("scarica").getNome());
	}
	
	@Test
	void testComandoAiuto() throws Exception {
		c=new ComandoAiuto();
		assertEquals(c.getNome(),fdcf.costruisciComando("aiuto").getNome());
	}
	@Test
	void testComandoFine() throws Exception {
		c=new ComandoFine();
		assertEquals(c.getNome(),fdcf.costruisciComando("fine").getNome());
	}
	@Test
	void testComandoGuarda() throws Exception {
		c=new ComandoGuarda();
		assertEquals(c.getNome(),fdcf.costruisciComando("guarda").getNome());
	}
	@Test
	void testComandoPosa() throws Exception {
		c=new ComandoPosa();
		assertEquals(c.getNome(),fdcf.costruisciComando("posa").getNome());
	}
	@Test
	void testComandoPrendi() throws Exception {
		c=new ComandoPrendi();
		assertEquals(c.getNome(),fdcf.costruisciComando("prendi").getNome());
	}
}
