package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	Stanza a;
	Attrezzo at;
	StanzaBuia buia;
	@BeforeEach
	void setUp() throws Exception {
		this.a=new Stanza("Stanza A");
		this.at=new Attrezzo("Pollo",2);
		buia=new StanzaBuia("Stanza buia","Pollo");
		buia.impostaStanzaAdiacente("ovest", a);
	}
	//Test metodo getDescrizione
	@Test
	void testgetDescrizione() {
		buia.addAttrezzo(at);
		assertEquals(buia.toString(),buia.getDescrizione());
	}
	@Test
	void testgetDescrizioneBuia() {
		assertNotEquals(buia.toString(),buia.getDescrizione());
	}
	@Test
	void testgetDescrizioneNotNull() {
		assertNotNull(buia.getDescrizione());
	}
	
	
}
