package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


class PartitaTest {
	private Partita partita;

	private Stanza stanza;

	@BeforeEach
	public void setUp()  {
		stanza=new Stanza("stanza");

		partita = new Partita();
		
	}
	
	// Test metodo getStanzaCorrente
	
	@Test
	public void testgetStanzaCorrente() {
		this.partita.setStanzaCorrente(stanza);
		assertSame(stanza,this.partita.getStanzaCorrente());
		
	}
	@Test
	public void testgetStanzaNull() {
		this.partita.setStanzaCorrente(null);
		assertNull(this.partita.getStanzaCorrente());
		
	}
	@Test
	public void testgetStanzaCorrente_Adiacente() {
		Stanza stanzaNord=new Stanza("nord");
		this.stanza.impostaStanzaAdiacente("nord", stanzaNord);
		this.partita.setStanzaCorrente(stanzaNord);
		assertSame(stanzaNord,this.partita.getStanzaCorrente());
		
		Stanza stanzaOvest=new Stanza("ovest");
		this.stanza.impostaStanzaAdiacente("ovest", stanzaOvest);
		assertNotSame(stanzaOvest,this.partita.getStanzaCorrente());
	}
	
	// Test metodo costruttore Partita fatto in aula
	@Test
	public void testNuovaParitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}
	@Test
	public void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	
	// Test metodo costruttore Partita

	@Test
	public void testPartita_Inizializzato() {
		assertNotNull(this.partita);
	}
	@Test
	public void testPatitaStanza_NonSonoOggettiUguali() {

		assertNotSame(this.partita,this.stanza);
	}
	@Test
	public void testsetStanzaVincente_IsNull() {
		partita=null;
		assertNull(partita);
	}
	
	// Test metodo vinta
	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(partita.vinta());
	}
	@Test
	public void testNonVinta() {
		this.partita.setStanzaCorrente(stanza);
		assertFalse(partita.vinta());
	}
	@Test
	public void testVintaInizioPartita() {

		assertFalse(partita.vinta());
	}
	
	
	// Test metodo isFinita
	@Test
	void testisFinita_finita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	@Test
	void testisFinita_ZeroCFU() {
		
		this.partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	@Test
	void testisFinita_Vinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(partita.isFinita());
	}
}
