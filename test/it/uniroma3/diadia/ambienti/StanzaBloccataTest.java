package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	Stanza a;
	Stanza b;
	StanzaBloccata sb;
	Attrezzo at;
	@BeforeEach
	void setUp(){
		this.at=new Attrezzo("Piede di porco",2);
		this.a=new Stanza("Stanza A");
		this.b=new Stanza("Stanza B");
		this.sb=new StanzaBloccata(a.getNome(),"sud",at.getNome() );
		a.impostaStanzaAdiacente("sud", sb);
	}
	//Test metodo getStanzaAdiacente
	@Test
	void testgetStanzaAdiacenteBloccata() {
	
		assertEquals(a.getStanzaAdiacente("sud"),sb.getStanzaAdiacente("sud"));
	}
	@Test
	void testgetStanzaAdiacenteNonBloccata() {
		a.impostaStanzaAdiacente("nord", b);
		assertNotEquals(a.getStanzaAdiacente("nord"),sb.getStanzaAdiacente("sud"));
	}
	@Test
	void testgetStanzaAdiacenteNull() {
		sb.impostaStanzaAdiacente("sud", a);
		assertNull(sb.getStanzaAdiacente("nord"));
	}
	
	//Test metodo getDescrizione
	@Test
	void testgetDescrizione() {

		a.addAttrezzo(at);
		assertEquals(sb.getStanzaAdiacente("sud").getDescrizione(),sb.getDescrizione());
	}
}
