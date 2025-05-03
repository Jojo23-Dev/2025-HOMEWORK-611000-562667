package it.uniroma3.diadia.giocatore;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    
	private Borsa borsa;
	
	
	
	@BeforeEach
	public void setUp() throws Exception {
		borsa = new Borsa();
		attrezzo1 = new Attrezzo("spada",3);
		attrezzo2 = new Attrezzo("coltello",5);
		
	}

	@Test
	public void testRemoveAttrezzoBorsaVuotaInizio() {
	
		assertNull(borsa.removeAttrezzo(attrezzo1.getNome()), "Non rimuovo nulla in una borsa vuota!");
		
	}
	
	
	
	@Test // da rifare
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		Attrezzo attrezzo3 = new Attrezzo("pietra", 6);
		borsa.addAttrezzo(attrezzo3);
	    Attrezzo rimosso = borsa.removeAttrezzo(attrezzo3.getNome());
	    assertNull(rimosso, "Rimuovendo un attrezzo inesistente dovrebbe restituire null.");
	       
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		Attrezzo attrezzo3 = new Attrezzo("chiave",10);
		borsa.addAttrezzo(attrezzo3);
		assertNull(borsa.removeAttrezzo(attrezzo3.getNome()));
	}
	
	
	
	/*getAttrezzo*/
	@Test
	public void testGetAttrezzoBorsaVuotaInizio() {
		
		//Controllo che la borsa sia vuota dall'inizio
		assertNull(borsa.getAttrezzo(attrezzo1.getNome()), "L'attrezzo non presente in una borsa vuota!");
		
	}
	
	@Test
	public void testGetAttrezzoNonPresente() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		//verifico che non riesco a trovare l'attrezzo nella borsa
		assertNull(borsa.getAttrezzo("chiave"),"L'attrezzo non è presente nella borsa!!");
	}
	
	
	@Test 
	
	public void testGetAttrezzoPresente() {
		
	    borsa.addAttrezzo(attrezzo1);
	    borsa.addAttrezzo(attrezzo2);
		assertNotNull(borsa.getAttrezzo(attrezzo2.getNome()),"L'attrezzo è presente nella borsa e lo puoi prendere!");
	}
	
	
	
}

