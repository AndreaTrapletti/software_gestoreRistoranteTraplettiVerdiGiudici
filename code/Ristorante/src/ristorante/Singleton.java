package ristorante;

public class Singleton {
	private static Singleton theIstance;
	private Singleton() {
		System.out.println("Costruisco l'istanza men�");
	}
	public static Singleton getIstance() {
		if (theIstance == null)
			theIstance = new Singleton();
		return theIstance;
	}
	
}
