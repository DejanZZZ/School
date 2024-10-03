package es1;

public class Main {

	public static void main(String[] args) {
		
		Buffer buff = new Buffer();
		
		Thread P = new Thread(new Produttore(buff));
		Thread C = new Thread(new Consumatore(buff));
		
		P.start();
		C.start();
		
	}

}
