package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza stanza1;
	private Stanza stanza2;
	private Attrezzo att1;
	private Attrezzo att2;
	
	@BeforeEach
	void setUp() {
		att1=new Attrezzo("attrezzo1",1);
		att2=new Attrezzo("attrezzo2",2);
		stanza1=new Stanza("stanza1");
		stanza2=new Stanza("stanza2");
		stanza1.addAttrezzo(att1);
	}

	//test fatto in aula
	@Test
	public void testhasAttrezzo() {
		this.stanza1.addAttrezzo(this.att1);
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));
	}
	
	
	
	
	
	//test metodo hasAttrezzo
	@Test
	public void testhasAttrezzoEsiste() {
	
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));
	}
	@Test
	public void testhasNonAttrezzoNonEsiste() {
		assertFalse(stanza1.hasAttrezzo("attrezzo2"));
	}
	@Test
	public void testhasAttrezzoisNULL() {
		assertEquals(false,stanza2.hasAttrezzo(" "));
	}
	
	
	// Test metodo removeAttrezzo
	@Test
	public void testremoveAttrezzoPresente() {
		assertTrue(stanza1.removeAttrezzo(att1));
	}
	@Test
	public void testremoveAttrezzoNonPresente() {
		assertFalse(stanza1.removeAttrezzo(att2));
	}
	@Test
	public void testremoveAttrezzoStanzaVuoto() {
		assertFalse(stanza2.removeAttrezzo(null));
	}
	
	
	// Test metodo getStanzaAdiacente
	@Test
	public void testgetStanzaAdiacente_DirezioneGiusta() {
		stanza2.impostaStanzaAdiacente("est", stanza1);
		assertSame(stanza1,stanza2.getStanzaAdiacente("est"));
	}
	@Test
	public void testgetStanzaAdiacente_DirezioneSbagliata() {
		stanza1.impostaStanzaAdiacente("est", stanza2);
		assertNotSame(stanza2,stanza1.getStanzaAdiacente("ovest"));
	}
	@Test
	public void testgetStanzaAdiacenteDirezioneNonPresente() {
		assertNull(stanza1.getStanzaAdiacente(null));
	}
}
