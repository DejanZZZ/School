package es1;

public class Consumatore implements Runnable {
	
	private Buffer buffer;
	private int num, nPari, nDispari;
	
	public Consumatore(Buffer buffer) {
		this.buffer = buffer;
		num = 0;
		nPari = 0;
		nDispari = 0;
		Thread.currentThread().setName("Consumatore");
	}
	
	public void Consuma() {
		num = buffer.Dequeue();
		System.out.println(Thread.currentThread().getName() + " " + num);
		if(num % 2 == 0) nPari++; else nDispari++;
		System.out.println("Numeri pari: " + nPari + " Numeri Dispari: " + nDispari);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Consuma();
			try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
		}
	}
}
