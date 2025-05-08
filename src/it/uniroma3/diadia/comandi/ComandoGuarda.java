 package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


public class ComandoGuarda implements Comando{
	private String parametro;
	IOConsole ioconsole=new IOConsole();
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.parametro;
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.parametro=parametro;
	}
	@Override
	public void esegui(Partita c) {
		// TODO Auto-generated method stub
		if(!c.isFinita())
		{
			ioconsole.mostraMessaggio("Descrizione della stanza:\n"+c.getStanzaCorrente().toString());
			ioconsole.mostraMessaggio("Il numero di CFU rimasti al giocatore->"+c.getGiocatore().getCfu());
		}
	}
	
	
	
	
}
