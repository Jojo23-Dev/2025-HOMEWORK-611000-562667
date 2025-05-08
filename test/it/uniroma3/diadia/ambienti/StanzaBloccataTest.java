package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	Stanza a;
	Stanza b;
	StanzaBloccata bloccata;
	Attrezzo at;
	@BeforeEach
	void setUp(){
		this.at=new Attrezzo("Piede di porco",2);
		this.a=new Stanza("Stanza A");
		this.b=new Stanza("Stanza B");
		this.bloccata=new StanzaBloccata("Stanza A bloccata","sud","Piede di porco" );
		bloccata.impostaStanzaAdiacente("sud", a);
	}
	//Test metodo getStanzaAdiacente
	@Test
	void testgetStanzaAdiacenteBloccata() {
		assertEquals(bloccata,bloccata.getStanzaAdiacente("sud"));
	}
	@Test
	void testgetStanzaAdiacenteNonBloccata() {
	
		assertNotEquals(b.getNome(),bloccata.getStanzaAdiacente("sud").getNome());
	}
	@Test
	void testgetStanzaAdiacenteNull() {
		
		assertNull(bloccata.getStanzaAdiacente("nord"));
	}
	
	//Test metodo getDescrizione
	@Test
	void testgetDescrizione() {
		
		bloccata.addAttrezzo(at);	
		assertEquals(bloccata.toString(),bloccata.getDescrizione());
	}
	@Test
	void testgetDescrizioneNotEquals() {
		assertNotEquals(bloccata.toString(),bloccata.getDescrizione());
	}
	@Test
	void testgetDescrizioneNotNull() {
		assertNotNull(bloccata.getDescrizione());
	}
}
