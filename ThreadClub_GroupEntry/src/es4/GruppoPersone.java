package es4;
import java.util.Random;

class GruppoPersone implements Runnable {
    private Discoteca discoteca;
    private int numeroPersone;
    private Random random;

    public GruppoPersone(Discoteca discoteca, int numeroPersone) {
        this.discoteca = discoteca;
        this.numeroPersone = numeroPersone; // Il numero di persone nel gruppo
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // Il gruppo entra in discoteca
            discoteca.entra(numeroPersone);
            System.out.println(Thread.currentThread().getName() + " è entrato con " + numeroPersone + " persone.");

            // Resta dentro per un tempo casuale tra 1 e 5 secondi
            try {
                Thread.sleep(1000 + random.nextInt(4000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Il gruppo esce dalla discoteca
            discoteca.esce(numeroPersone);
            System.out.println(Thread.currentThread().getName() + " è uscito con " + numeroPersone + " persone.");

            // Attende un po' prima di rientrare (tempo casuale tra 1 e 3 secondi)
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}