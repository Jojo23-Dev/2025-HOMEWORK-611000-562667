package it.uniroma3.diadia;

public class IOSimulator implements IO {
	private String[] rigaLettere;
	private String[] messaggiMostrati;
	private int indiceWrite;
	private int indiceRead;
	IOConsole ioconsole=new IOConsole();
	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		if(indiceWrite<messaggiMostrati.length) {
			messaggiMostrati[indiceWrite]=messaggio;
		}
		else
			ioconsole.mostraMessaggio("Errore!!");
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		if(indiceRead<rigaLettere.length)
			return (rigaLettere[indiceRead++]);
		return null;
	}

	public IOSimulator(String[] rigaLettere) {
		this.rigaLettere=rigaLettere;
		this.messaggiMostrati=new String[100];
		this.indiceWrite=0;
		this.indiceRead=0;
	}

}
