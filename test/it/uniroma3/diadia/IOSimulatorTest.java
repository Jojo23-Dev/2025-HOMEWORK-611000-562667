package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class IOSimulatorTest {
	private Partita par;
	
	private IOSimulator iosim;

	private FabbricaDiComandi factory ;
	private String stringa;
	private String[] elencoComandi= {"vai sud","prendi lanterna","vai nord","posa lanterna","vai nord"};
	@BeforeEach
	void setUp() throws Exception {
		par=new Partita();
	
		iosim=new IOSimulator(elencoComandi);

		factory = new FabbricaDiComandiFisarmonica();
	}
	private boolean Istruzioni(String ist) {
		Comando comand;
		comand=this.factory.costruisciComando(ist);
		comand.esegui(this.par);
		return this.par.isFinita();
	}
	@Test
	void testPartita() {
		for(String is:elencoComandi) {
			this.iosim.mostraMessaggio(is);
			stringa=this.iosim.leggiRiga();
			this.Istruzioni(stringa);
		}
		
	assertTrue(this.par.isFinita());

	}

}
