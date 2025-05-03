package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	IOConsole ioconsole=new IOConsole();
	@Override
	public void esegui(Partita partita) {
	for(int i=0; i< elencoComandi.length; i++) 
		ioconsole.mostraMessaggio(elencoComandi[i]+" ");
	ioconsole.mostraMessaggio(" ");
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
		
	}
}
