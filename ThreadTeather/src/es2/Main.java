package es2;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Thread[] spettatori = new Thread[7]; // 7 thread per rappresentare gli spettatori
        long startTime = System.currentTimeMillis(); // Memorizza l'ora di inizio

        // Crea e avvia i thread
        for (int i = 0; i < spettatori.length; i++) {
            spettatori[i] = new Thread(new Spettatore(cinema, i + 1, startTime));
            spettatori[i].start();
        }

        // Simula un'attesa di 10 secondi prima dell'inizio dello spettacolo
        try {
            Thread.sleep(10000); // Aspetta 10 secondi
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stampa il numero di posti rimasti
        System.out.println("Lo spettacolo sta per iniziare. Posti rimanenti: " + cinema.getPostiRimanenti());

        // Attendi la fine di tutti i thread
        for (Thread spettatore : spettatori) {
            try {
                spettatore.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Stampa il messaggio finale
        System.out.println("Tutti i thread completati. Posti rimanenti: " + cinema.getPostiRimanenti());
    }
}