
import java.util.Vector;

import prog.utili.Data;

public class Fornitore extends Thread{
	protected String nome;
	protected String cognome;
	
	Gestione gestione;
	
	
	public Fornitore(String nome, String cognome, Gestione gestione) {
		this.nome = nome;
		this.cognome = cognome;
		this.gestione = gestione;
	}
	public Fornitore(String nome, String cognome, String s, Gestione gestione) {
		this.nome = nome;
		this.cognome = cognome;
		this.gestione = gestione;
		setName(s);
	}
	
	@Override
	public void run () {
		System.out.println(this.nome + " sono partito");
		while(true) {
			gestione.rifornimento();
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
