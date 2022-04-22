package ristorante;

import java.util.Vector;

import prog.utili.Data;

public abstract class  Fornitore extends Thread{
	public abstract String getNome();
	
	public Gestione gestione;
	
	
	@Override
	public void run () {
		System.out.println(this.getNome() + " sono partito");
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
