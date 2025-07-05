package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	@Override
	public Comando costruisciComando(String istruzioni) throws Exception{
		Scanner scannerDiParole = new Scanner(istruzioni); // es . 'vai sud'
		String istruzione=null; // es. 'vai'
		String parametro=null; // es. 'sud'
		Comando comando=null;
				// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			istruzione= scannerDiParole.next(); 
		
		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		
		nomeClasse.append(Character.toUpperCase(istruzione.charAt(0)));
		// es. nomeClasse: 'it.uniroma3.diadia.comandi.ComandoV
		nomeClasse.append(istruzione.substring(1	));
		// es. nomeClasse: 'it.uniroma3.diadia.comandi.ComandoVai
		
		comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
		// POSSIBILE ALTERNATIVA basata sul rendere il tipo Class<Comando> esplicito:
		// comando = ((Class<Comando>)Class.forName(nomeClasse.toString())).newInstance();
		comando.setParametro(parametro);
//		if(istruzione==null)
//			return comando;
//		
//		if (istruzione.equals("fine") ) 
//			comando=new ComandoFine(); 
//		else if (istruzione.equals("vai"))
//			comando=new ComandoVai();
//		else if (istruzione.equals("aiuto"))
//			comando=new ComandoAiuto();
//		else if (istruzione.equals("prendi")) 
//			comando=new ComandoPrendi();
//		
//		else if (istruzione.equals("posa")) 
//			comando=new ComandoPosa();
//		else if(istruzione.equals("guarda"))
//			comando=new ComandoGuarda();
//		else
//			comando=new ComandoNonValido();
//		
//		comando.setParametro(parametro);
		return comando;
	}


}
