package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	IOConsole ioconsole=new IOConsole();
	private String nomeAttrezzo;
	@Override
	public void comand(Partita partita) {

		if(nomeAttrezzo == null) {
			System.out.println("Quale attrezzo vuoi prendere?");
			
		}
		else {
			Attrezzo attrezzo=partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(attrezzo!=null ){
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
					
					ioconsole.mostraMessaggio("Hai preso l'attrezzo ->"+partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
					partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			
			}
			else
				ioconsole.mostraMessaggio("Attrezzo non presente nella stanza!!");
		}
		
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
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
		this.nomeAttrezzo=parametro;
	}


}
