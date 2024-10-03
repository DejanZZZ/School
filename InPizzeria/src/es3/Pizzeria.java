package es3;
import java.util.concurrent.*;
import java.util.Random;

public class Pizzeria {
    private final int maxTavoli = 20;
    private final int maxPersone = 100;
    private int personeAttualmenteAiTavoli = 0;
    private int pizzeDaConsegnare = 0;
    private Semaphore tavoliDisponibili = new Semaphore(maxTavoli, true);
    private Semaphore pizzeDisponibili = new Semaphore(0, true);
    private Random random = new Random();

    public synchronized void produciPizze(int numPizze) {
        pizzeDaConsegnare += numPizze;
        pizzeDisponibili.release(numPizze);
    }

    public synchronized int getPizzeDaConsegnare() {
        return pizzeDaConsegnare;
    }

    public synchronized int getTavoliOccupati() {
        return personeAttualmenteAiTavoli / 4;  // Circa 4 persone per tavolo
    }

    public int prendiOrdine() {
        try {
            tavoliDisponibili.acquire();  // Aspetta che un tavolo si liberi
            synchronized (this) {
                if (personeAttualmenteAiTavoli < maxPersone) {
                    int personeAlTavolo = random.nextInt(4) + 1;  // Da 1 a 4 persone per tavolo
                    personeAttualmenteAiTavoli += personeAlTavolo;
                    System.out.println("Nuovo ordine al tavolo con " + personeAlTavolo + " persone. Totale persone ai tavoli: " + personeAttualmenteAiTavoli);
                    return personeAttualmenteAiTavoli / 4;  // Restituisce il numero del tavolo
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return -1;  // Nessun ordine
    }

    public int consegnaPizze() {
        try {
            pizzeDisponibili.acquire();  // Aspetta che ci siano pizze pronte
            synchronized (this) {
                if (pizzeDaConsegnare > 0) {
                    pizzeDaConsegnare--;
                    int tavolo = random.nextInt(maxTavoli) + 1;
                    System.out.println("Pizze consegnate al tavolo " + tavolo + ". Pizze rimanenti da consegnare: " + pizzeDaConsegnare);
                    return tavolo;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return -1;  // Nessuna pizza da consegnare
    }

    public synchronized void liberaTavolo(int personeAlTavolo) {
        personeAttualmenteAiTavoli -= personeAlTavolo;
        tavoliDisponibili.release();
        System.out.println("Tavolo liberato. Persone rimaste ai tavoli: " + personeAttualmenteAiTavoli);
    }
}
