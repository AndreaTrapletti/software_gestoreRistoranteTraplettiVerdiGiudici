
import java.util.Vector;

import prog.utili.Data;

public class Fornitore extends Thread{
	protected String nome;
	protected String cognome;
	protected String Mail;
	protected String P_IVA;
	public Gestione gestione;
	
	
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
	public Fornitore(String nome, String cognome, Gestione gestione,String Mail, String P_IVA) {
		this.nome = nome;
		this.cognome = cognome;
		this.gestione = gestione;
		this.Mail=Mail;
		this.P_IVA=P_IVA;
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
