package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
public class ComandoFine implements Comando{
	IOConsole ioconsole = new IOConsole();
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
	public void esegui(Partita par) {
		ioconsole.mostraMessaggio("Grazie per aver giocato !!");  // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}
