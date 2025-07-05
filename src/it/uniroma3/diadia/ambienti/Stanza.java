package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;
/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;

    
    private Map<String,Stanza> stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
    
    private Map<String, Attrezzo> nome2attrezzo;
    private int numeroAttrezzi;
    
	private String[] direzioni;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
      this.stanzeAdiacenti = new  HashMap<>();// Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.nome2attrezzo = new HashMap<>();//new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    
    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return this.nome2attrezzo.values();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
//    	for(int i=0; i<this.direzioni.length; i++)
//        	if (direzione.equals(this.direzioni[i])) {
//        		this.stanzeAdiacenti.put(direzione, stanza);
//        		aggiornato = true;
//        	}
        if(stanzeAdiacenti.containsKey(direzione)) {
        	this.stanzeAdiacenti.put(direzione, stanza);
        	aggiornato = true;
        }
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
// 			this.direzioni[numeroStanzeAdiacenti] = direzione;
//    			this.stanzeAdiacenti.put(numeroStanzeAdiacenti, stanza);
    			
    			this.stanzeAdiacenti.put(direzione, stanza);
    		    this.numeroStanzeAdiacenti++;
    		}
    }
    
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
    
	public boolean removeAttrezzo(Attrezzo wanted) {
			
//			for(	int i=0; i<this.numeroAttrezzi; i++) {
//				if(this.nome2attrezzo.get(i)==wanted) {//cerco l'oggetto per il momento non uso equals
//				    this.nome2attrezzo.put(i, this.nome2attrezzo.get(this.numeroAttrezzi-1));
//				    this.nome2attrezzo.put(this.numeroAttrezzi-1,null) ;
//				    this.numeroAttrezzi--;
//					return true;
//				}
//			}
			if(wanted!=null) {
				this.nome2attrezzo.remove(wanted.getNome(),wanted);
				return true;	
			}
			return false;
		}
//	public boolean removeAttrezzo(Attrezzo nomeAttrezzo) {
//	    if (nomeAttrezzo == null) {
//	        return false;
//	    }
//	    for (int i = 0; i < this.numeroAttrezzi; i++) {
//	        if (attrezzi[i] != null && this.attrezzi[i].equals(nomeAttrezzo)) {
//	            // Sposta gli elementi a sinistra per riempire il "buco"
//	            for (int j = i; j < numeroAttrezzi - 1; j++) {
//	                attrezzi[j] = attrezzi[j + 1];
//	            }
//	            this.attrezzi[this.numeroAttrezzi - 1] = null; // Imposta l'ultimo elemento a null
//	            numeroAttrezzi--; // Aggiorna il numero di attrezzi
//	            return true; // Rimosso con successo
//	        }
//	    }
//	    return false; // Attrezzo non trovato
//	}
    
    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato=false;

//		for (int i=0;i<this.numeroAttrezzi;i++) {
//			if (this.nome2attrezzo.get(i).getNome().equals(nomeAttrezzo))
//				trovato = true;
//		}
		if(nomeAttrezzo!= null && nome2attrezzo.containsKey(nomeAttrezzo))
			trovato = true;
		return trovato;
	}
    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti.get(direzione);
        return stanza;
	}
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.nome2attrezzo.put(attrezzo.getNome(), attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }
    
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	    Attrezzo attrezzoCercato = null;
//	    for (Attrezzo attrezzo : this.nome2attrezzo.values()) {
//	        if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
//	            attrezzoCercato = attrezzo;
//	    }
	    if(this.nome2attrezzo.containsKey(nomeAttrezzo))
	    	attrezzoCercato = this.nome2attrezzo.get(nomeAttrezzo);
	    return attrezzoCercato;	
	}
    /**
 	* Restituisce una rappresentazione stringa di questa stanza,
 	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
 	* @return la rappresentazione stringa
 	*/
     public String toString() {
         StringBuilder risultato = new StringBuilder();
         risultato.append(this.nome);
         risultato.append("\nUscite: ");
         for (String direzione : this.direzioni)
             if (direzione!=null)
                 risultato.append(" " + direzione);
         risultato.append("\nAttrezzi nella stanza: ");
//         for (Attrezzo attrezzo : this.attrezzi) {
//             if (attrezzo != null) {
//            	 risultato.append(" "+attrezzo.toString());
//             }
//         }
         risultato.append(this.getAttrezzi().toString());
//         for (int i=0;i<this.numeroAttrezzi;i++) {
//            
//            	 risultato.append(" "+this.nome2attrezzo.get(i ));
//             
//         }
         return risultato.toString();
     }
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}