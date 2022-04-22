package ristorante;
public class Sistema extends Thread{
	public Gestione gestione;

		public Sistema(Gestione gestione) {
			this.gestione=gestione;
		}
		@Override
	public void run() {
			
			while(true) {
					gestione.loopcontrollo();
				try {
					sleep(10000);    
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}}
		}

