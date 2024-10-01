package es3;

class Discoteca {
    private int personeDentro; // Contatore delle persone dentro

    public Discoteca() {
        personeDentro = 0; // Inizialmente non ci sono persone
    }

    // Metodo sincronizzato per far entrare una persona
    public synchronized void entra() {
        personeDentro++; // Incrementa il conteggio delle persone dentro
    }

    // Metodo sincronizzato per far uscire una persona
    public synchronized void esce() {
        personeDentro--; // Decrementa il conteggio delle persone dentro
    }

    // Metodo sincronizzato per ottenere il numero di persone attualmente dentro
    public synchronized int getNumeroPersoneDentro() {
        return personeDentro;
    }
}
