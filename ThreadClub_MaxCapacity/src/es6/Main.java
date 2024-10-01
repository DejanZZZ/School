package es6;

public class Main {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca(161); // Capienza massima della discoteca: 161 persone
        Thread[] gruppi = new Thread[10]; // 10 gruppi di persone

        // Crea e avvia i thread che rappresentano i gruppi di persone
        for (int i = 0; i < gruppi.length; i++) {
            int numeroPersoneNelGruppo = 10 + (int) (Math.random() * 30); // Ogni gruppo ha da 10 a 40 persone
            gruppi[i] = new Thread(new GruppoPersone(discoteca, "Gruppo " + (i + 1), numeroPersoneNelGruppo));
            gruppi[i].start();
        }

        // Ciclo che stampa ogni secondo lo stato della discoteca
        while (true) {
            try {
                Thread.sleep(1000); // Aspetta 1 secondo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Stampa il numero di persone dentro la discoteca
            System.out.println("Persone nella discoteca: " + discoteca.getNumeroPersoneDentro());
            System.out.println("----------------------------");
        }
    }
}