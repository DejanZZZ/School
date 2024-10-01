package es4;

public class Main {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca(); // Crea la discoteca
        Thread[] gruppi = new Thread[5]; // Crea un array di 5 thread (5 gruppi di persone)

        // Crea e avvia i thread che rappresentano i gruppi di persone
        for (int i = 0; i < gruppi.length; i++) {
            int numeroPersoneNelGruppo = 1 + (int) (Math.random() * 10); // Ogni gruppo ha da 1 a 10 persone
            gruppi[i] = new Thread(new GruppoPersone(discoteca, numeroPersoneNelGruppo), "Gruppo " + (i + 1));
            gruppi[i].start();
        }

        // Ciclo che stampa il numero di persone dentro ogni 2 secondi
        while (true) {
            try {
                Thread.sleep(2000); // Aspetta 2 secondi
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Stampa il numero di persone attualmente nella discoteca
            System.out.println("Persone nella discoteca: " + discoteca.getNumeroPersoneDentro());
        }
    }
}