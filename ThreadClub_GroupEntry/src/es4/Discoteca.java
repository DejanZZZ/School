package es4;

class Discoteca {
    private int personeDentro; // Variabile per contare le persone dentro

    public Discoteca() {
        personeDentro = 0; // Inizialmente non ci sono persone
    }

    // Metodo sincronizzato per far entrare un gruppo di persone
    public synchronized void entra(int numeroPersone) {
        personeDentro += numeroPersone; // Incrementa il conteggio delle persone dentro
    }

    // Metodo sincronizzato per far uscire un gruppo di persone
    public synchronized void esce(int numeroPersone) {
        personeDentro -= numeroPersone; // Decrementa il conteggio delle persone dentro
    }

    // Metodo sincronizzato per ottenere il numero di persone attualmente dentro
    public synchronized int getNumeroPersoneDentro() {
        return personeDentro;
    }
}
