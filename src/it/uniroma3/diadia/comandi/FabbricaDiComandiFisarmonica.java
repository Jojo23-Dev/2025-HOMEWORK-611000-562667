package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	@Override
	public Comando comandi(String istruzioni) {
		Scanner scannerDiParole = new Scanner(istruzioni);
		String istruzione=null;
		String parametro=null;
		Comando comando=null;
				// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			istruzione= scannerDiParole.next(); 
		
		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
	
		if(istruzione==null)
			return comando;
		if (istruzione.equals("fine") ) {
			comando=new ComandoFine(); 
			
		} else if (istruzione.equals("vai"))
			comando=new ComandoVai();
		else if (istruzione.equals("aiuto"))
			comando=new ComandoAiuto();
		else if (istruzione.equals("prendi")) 
			comando=new ComandoPrendi();
		
		else if (istruzione.equals("posa")) 
			comando=new ComandoPosa();
		else
			comando=new ComandoNonValido();		
		comando.setParametro(parametro);
		return comando;
	}


}
