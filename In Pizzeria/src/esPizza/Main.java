package esPizza;

public class Main {
    public static void main(String[] args) {
        Forno forno = new Forno();
        final int NUM_TAVOLI = 20;
        final int NUM_CAMERIERI = 3;

        Tavolo[] tavoli = new Tavolo[NUM_TAVOLI];
        Thread[] camerieri = new Thread[NUM_CAMERIERI];

        // Creazione dei tavoli
        for (int i = 0; i < NUM_TAVOLI; i++) {
            tavoli[i] = new Tavolo(i + 1); // Passa l'ID del tavolo
            Thread threadTavolo = new Thread(tavoli[i], "Tavolo " + (i + 1));
            threadTavolo.start();
        }

        // Creazione dei camerieri
        for (int i = 0; i < NUM_CAMERIERI; i++) {
            Cameriere cameriere = new Cameriere(forno, tavoli);
            camerieri[i] = new Thread(cameriere, "Cameriere " + (i + 1));
            camerieri[i].start();
        }

        // Aspetta che tutti i camerieri terminino
        for (int i = 0; i < NUM_CAMERIERI; i++) {
            try {
                camerieri[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
