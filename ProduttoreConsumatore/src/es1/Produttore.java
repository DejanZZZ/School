package es1;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Produttore implements Runnable {
	
	private Buffer buffer;
	private int num;
	private Random rndm;

	public Produttore(Buffer buffer) {
		this.rndm = new Random();
		this.buffer = buffer;
		Thread.currentThread().setName("Produttore");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Produci();
		}
	}
	private void Produci() {
		num = rndm.nextInt(1024);
		System.out.println(Thread.currentThread().getName() + " " + num);
	    try{ Thread.sleep(ThreadLocalRandom.current().nextLong(100, 1000 + 1)); }
	    catch (InterruptedException e) { Thread.currentThread().interrupt(); }
		buffer.Enqueue(num);
	}
	
}
