package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 5;
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	private boolean finita;
	
	public Partita(){
		this.labirinto=new Labirinto();
		this.stanzaCorrente=labirinto.getStanzaIniziale();
		this.stanzaVincente=labirinto.getStanzaFinale();
		this.setGiocatore(new Giocatore());
		this.finita = false;
		this.getGiocatore().setCfu(CFU_INIZIALI);
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
	     return this.getStanzaCorrente()==this.labirinto.getStanzaFinale();  
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	public String toString() {
		return this.getStanzaCorrente()+"\nCfu= "+this.giocatore.getCfu();
	}

	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		if(this.giocatore.getCfu()>0)
			return true;
		return false;
	}


	

	
}
