package es5;
import java.util.Random;

class GruppoPersone implements Runnable {
    private Discoteca discoteca;
    private int numeroPersone;
    private int pistaCorrente; // La pista in cui si trova attualmente il gruppo
    private Random random;

    public GruppoPersone(Discoteca discoteca, int numeroPersone) {
        this.discoteca = discoteca;
        this.numeroPersone = numeroPersone; // Numero di persone nel gruppo
        this.pistaCorrente = new Random().nextInt(4); // Inizia in una pista casuale (tra 0 e 3)
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // Il gruppo entra nella pista corrente
            discoteca.entra(pistaCorrente, numeroPersone);
            System.out.println(Thread.currentThread().getName() + " è entrato nella Pista " + (pistaCorrente + 1) + " con " + numeroPersone + " persone.");

            // Resta nella pista per un tempo casuale tra 1 e 5 secondi
            try {
                Thread.sleep(1000 + random.nextInt(4000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Decide casualmente se uscire o cambiare pista
            discoteca.esce(pistaCorrente, numeroPersone);
            System.out.println(Thread.currentThread().getName() + " è uscito dalla Pista " + (pistaCorrente + 1) + " con " + numeroPersone + " persone.");

            if (random.nextBoolean()) {
                // Cambia pista
                int nuovaPista = random.nextInt(4); // Scelgo una nuova pista casuale
                while (nuovaPista == pistaCorrente) { // Evito di scegliere la stessa pista
                    nuovaPista = random.nextInt(4);
                }
                pistaCorrente = nuovaPista;
                System.out.println(Thread.currentThread().getName() + " ha cambiato pista e sta per entrare nella Pista " + (pistaCorrente + 1));
            }

            // Attende un po' prima di rientrare (tempo casuale tra 1 e 3 secondi)
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}