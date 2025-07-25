package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	IOConsole ioconsole=new IOConsole();

	private String direzione;
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			ioconsole.mostraMessaggio("Dove vuoi andare ? "
					+ "Devi specificare una direzione");
		return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null) {
			
			ioconsole.mostraMessaggio("Direzione inesistente");
			
			return;
			}
			partita.setStanzaCorrente(prossimaStanza);
			System.out.println(partita.getStanzaCorrente().getNome());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
//				int cfu =partita.getGiocatore().getCfu();
//				// parametro set modificato : cfu-- -> --cfu
//				partita.getGiocatore().setCfu(--cfu);
////				// aggiunto stampa del cfu che si abbassa
////				System.out.println("Il tuo CFU si abbassa -> "+ this.partita.getGiocatore().getCfu());
////			
//				// istruzione che permette di proseguire nella prossima stanza	
//				partita.setStanzaCorrente(prossimaStanza);
		
		
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione=parametro;
	}

}
