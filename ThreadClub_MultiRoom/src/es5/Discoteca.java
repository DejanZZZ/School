package es5;

class Discoteca {
    private int[] personeNellePiste; // Array per tenere traccia delle persone in ciascuna delle 4 piste

    public Discoteca() {
        personeNellePiste = new int[4]; // 4 piste nella discoteca
    }

    // Metodo sincronizzato per far entrare un gruppo in una pista specifica
    public synchronized void entra(int pista, int numeroPersone) {
        personeNellePiste[pista] += numeroPersone; // Incrementa il numero di persone nella pista
    }

    // Metodo sincronizzato per far uscire un gruppo da una pista specifica
    public synchronized void esce(int pista, int numeroPersone) {
        personeNellePiste[pista] -= numeroPersone; // Decrementa il numero di persone nella pista
    }

    // Metodo sincronizzato per ottenere il numero di persone in una pista specifica
    public synchronized int getPersoneInPista(int pista) {
        return personeNellePiste[pista];
    }

    // Metodo sincronizzato per stampare lo stato di tutte le piste
    public synchronized void stampaStato() {
        System.out.println("Persone nella Pista 1: " + personeNellePiste[0]);
        System.out.println("Persone nella Pista 2: " + personeNellePiste[1]);
        System.out.println("Persone nella Pista 3: " + personeNellePiste[2]);
        System.out.println("Persone nella Pista 4: " + personeNellePiste[3]);
        System.out.println("---------------------------");
    }
}