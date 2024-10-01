package es3;

public class Main {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca(); // Crea una discoteca
        Thread[] persone = new Thread[10]; // Crea un array di 10 thread (10 persone)

        // Crea e avvia i thread che rappresentano le persone
        for (int i = 0; i < persone.length; i++) {
            persone[i] = new Thread(new Persona(discoteca), "Persona " + (i + 1));
            persone[i].start();
        }

        // Ciclo che stampa il numero di persone dentro ogni secondo
        while (true) {
            try {
                Thread.sleep(1000); // Aspetta 1 secondo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Stampa il numero di persone attualmente nella discoteca
            System.out.println("Persone nella discoteca: " + discoteca.getNumeroPersoneDentro());
        }
    }
}