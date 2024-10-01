package es5;

public class Main {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca(); // Crea la discoteca con 4 piste
        Thread[] gruppi = new Thread[8]; // Creiamo 8 thread (8 gruppi di persone)

        // Crea e avvia i thread che rappresentano i gruppi di persone
        for (int i = 0; i < gruppi.length; i++) {
            int numeroPersoneNelGruppo = 1 + (int) (Math.random() * 10); // Ogni gruppo ha da 1 a 10 persone
            gruppi[i] = new Thread(new GruppoPersone(discoteca, numeroPersoneNelGruppo), "Gruppo " + (i + 1));
            gruppi[i].start();
        }

        // Ciclo che stampa il numero di persone in ogni pista ogni 500ms
        while (true) {
            try {
                Thread.sleep(500); // Aspetta 500ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Stampa lo stato attuale delle piste
            discoteca.stampaStato();
        }
    }
}