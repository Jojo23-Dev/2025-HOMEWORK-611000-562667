package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccataDirezione;
	public StanzaBloccata(String nome,String NDB,String NASD) {
		super(nome);
		this.nomeDirezioneBloccata=NDB;
		this.nomeAttrezzoSbloccataDirezione=NASD;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(nomeDirezioneBloccata) && !this.hasAttrezzo(nomeAttrezzoSbloccataDirezione)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	@Override
	public String getDescrizione() {
		String desc;
		if(this.hasAttrezzo(nomeAttrezzoSbloccataDirezione)!=true) {
			desc="La stanza è bloccata nella direzione ->"+this.nomeDirezioneBloccata+"\nPrendi l'attrezzo per sbloccare la stanza->"+this.nomeAttrezzoSbloccataDirezione;
			return desc;
		}
		return super.getDescrizione();
	}
}

