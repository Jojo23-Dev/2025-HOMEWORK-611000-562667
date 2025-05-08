package it.uniroma3.diadia;


//import java.util.Scanner;

//import it.uniroma3.diadia.ambienti.Stanza;
//import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
//	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IO ioconsole;

	public DiaDia(IO io) {
		this.ioconsole=io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 


		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione) );
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			this.ioconsole.mostraMessaggio("Hai vinto");
		if (!this.partita.giocatoreIsVivo())

			this.ioconsole.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
//		if(comandoDaEseguire.getNome()==null)
//			return false;
//		if (comandoDaEseguire.getNome().equals("fine") ) {
//			this.fine(); 
//			return true;
//		} else if (comandoDaEseguire.getNome().equals("vai"))
//			this.vai(comandoDaEseguire.getParametro());
//		else if (comandoDaEseguire.getNome().equals("aiuto"))
//			this.aiuto();
//		else if (comandoDaEseguire.getNome().equals("prendi")) 
//			this.prendi(comandoDaEseguire.getParametro());
//		
//		else if (comandoDaEseguire.getNome().equals("posa")) 
//			this.posa(comandoDaEseguire.getParametro());
//		else
//			ioconsole.mostraMessaggio("Comando sconosciuto");

		
	} 
	//metodo posa attrezzo
//	private void posa(String nomeAttrezzo) {
//		if(nomeAttrezzo == null) {
//			ioconsole.mostraMessaggio("Quale attrezzo vuoi posare?");
//			ioconsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
//		}
//			
//		
//		else {
//			Attrezzo attrezzo=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
//			if(attrezzo!=null ){
//				this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
//				//System.out.println("Il giocatore ha posato l'attrezzo ->"+this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
//				ioconsole.mostraMessaggio("Hai posato l'attrezzo ->"+this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
//				this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
//			
//			}
//			else
//				ioconsole.mostraMessaggio("Attrezzo non presente nella borsa!!");
//		}
//		ioconsole.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());;
//	}
	
	//metodo prende attrezzo
//	private void prendi(String nomeAttrezzo) {
//
//		if(nomeAttrezzo == null) {
//			System.out.println("Quale attrezzo vuoi prendere?");
//			
//		}
//		else {
//			Attrezzo attrezzo=this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
//			if(attrezzo!=null ){
//				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
//					
//					ioconsole.mostraMessaggio("Hai preso l'attrezzo ->"+this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
//					this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
//			
//			}
//			else
//				ioconsole.mostraMessaggio("Attrezzo non presente nella stanza!!");
//		}
//		
//		ioconsole.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
//	}
	
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
//	private void aiuto() {
//		for(int i=0; i< elencoComandi.length; i++) 
//			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
//		ioconsole.mostraMessaggio(" ");
//	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
//	private void vai(String direzione) {
//		if(direzione==null)
//			ioconsole.mostraMessaggio("Dove vuoi andare ?");
//		
//		Stanza prossimaStanza = null;
//		
//		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
//		
//		if (prossimaStanza == null)
//			
//			ioconsole.mostraMessaggio("Direzione inesistente");
//		
//		else {
//			
//				int cfu = this.partita.getGiocatore().getCfu();
//				// parametro set modificato : cfu-- -> --cfu
//				this.partita.getGiocatore().setCfu(--cfu);
////				// aggiunto stampa del cfu che si abbassa
////				System.out.println("Il tuo CFU si abbassa -> "+ this.partita.getGiocatore().getCfu());
////			
//				// istruzione che permette di proseguire nella prossima stanza	
//				this.partita.setStanzaCorrente(prossimaStanza);
//		}
//		
//		ioconsole.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
//	}

	/**
	 * Comando "Fine".
	 */
//	private void fine() {
//		
//		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
//	}

	public static void main(String[] argc) {
		IO io=new IOConsole();
		DiaDia gioco = new DiaDia(io);
		//ioconsole =new IOConsole();
		gioco.gioca();
	}
}