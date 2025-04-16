package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza
{
	private String descrizione;
	public StanzaBuia(String nome,String nomeAttrezzo) {
		super(nome);
		this.descrizione=nomeAttrezzo;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDescrizione() {
		String des=new String();
		des="qui c'è buio pesto";
		if(!this.hasAttrezzo(descrizione))
			return des;
		return super.getDescrizione();
	
}}
