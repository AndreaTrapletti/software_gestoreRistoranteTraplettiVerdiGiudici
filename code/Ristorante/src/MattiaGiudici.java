
public class MattiaGiudici extends Fornitore{
	protected String nome;
	protected String cognome;
	
	
	public MattiaGiudici(String nome, String cognome, String s, Gestione gestione) {
		this.nome = nome;
		this.cognome = cognome;
		this.gestione = gestione;
		setName(s);
	}
	
	
	@Override
	public String getNome() {
		return nome + " " + cognome;
	}
}
