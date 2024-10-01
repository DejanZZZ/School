package es2;
import java.util.Random;

class Spettatore implements Runnable {
    private final Cinema cinema;
    private final int id;
    private final long startTime;
    private final Random random;

    public Spettatore(Cinema cinema, int id, long startTime) {
        this.cinema = cinema;
        this.id = id;
        this.startTime = startTime;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            // Simula un tempo casuale di arrivo al cinema
            Thread.sleep(random.nextInt(3000)); // Ogni spettatore arriva in un tempo casuale fino a 3 secondi

            // Continuo a provare a prenotare fino a quando non trovo un posto o finché non passano 10 secondi
            while (System.currentTimeMillis() - startTime < 10000) {
                boolean prenotato = cinema.prenotaPosto(id);

                if (prenotato) {
                    break; // Uscita se lo spettatore ha prenotato con successo
                }

                // Attesa di 100 ms prima di riprovare (per non sovraccaricare il sistema con tentativi immediati)
                Thread.sleep(100);
            }

            if (System.currentTimeMillis() - startTime >= 10000) {
                System.out.println("Thread " + id + ": Tempo scaduto, non ho prenotato nessun posto.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}