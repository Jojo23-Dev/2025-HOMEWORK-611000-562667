package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;
    private Labirinto labirinto;
//    private Partita partita;

    @BeforeEach
    void setUp() {
    	
    	this.stanzaFinale = new Stanza("biblioteca");
    	this.stanzaIniziale = new Stanza("atrio");
    	//this.partita = new Partita();
    	this.labirinto = new Labirinto();
    }
    
    
	@Test
	void testgetStanzaInizialeCorrente() {
		this.labirinto.setStanzaIniziale(stanzaIniziale);
		assertEquals(this.stanzaIniziale,this.labirinto.getStanzaIniziale());
	}
	
	@Test
	void testgetStanzaInizialeCorrenteVincente() {
		this.labirinto.setStanzaIniziale(stanzaIniziale);
		assertNotEquals(this.stanzaFinale,this.labirinto.getStanzaIniziale());
	}
	
	@Test
	void testgetStanzaInizialeNonEsistente() {
		this.labirinto.setStanzaIniziale(null);
		assertNull(this.labirinto.getStanzaIniziale());
	}
	
	
	@Test
	void testgetStanzaFinaleCorrente() {
		this.labirinto.setStanzaFinale(stanzaFinale);
		assertEquals(this.stanzaFinale,this.labirinto.getStanzaFinale());
	}
	
	@Test
	void testgetStanzaFinaleCorrenteVincente(){
		this.labirinto.setStanzaFinale(stanzaFinale);
		assertNotEquals(this.stanzaIniziale,this.labirinto.getStanzaFinale());
	}
	
	@Test
	void testgetStanzaFinaleNonEsistente() {
		this.labirinto.setStanzaFinale(null);
		assertNull(this.labirinto.getStanzaFinale());
	}
	
}
