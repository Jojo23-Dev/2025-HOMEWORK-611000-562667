package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	IOConsole ioconsole=new IOConsole();
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
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			ioconsole.mostraMessaggio("Quale attrezzo vuoi posare?");
			ioconsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
			
		
		else {
			Attrezzo attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if(attrezzo!=null ){
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				//System.out.println("Il giocatore ha posato l'attrezzo ->"+this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
				ioconsole.mostraMessaggio("Hai posato l'attrezzo ->"+partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			
			}
			else
				ioconsole.mostraMessaggio("Attrezzo non presente nella borsa!!");
		}
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;
		
	}


}
