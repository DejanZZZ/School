package es6;

class Discoteca {
    private int personeDentro; // Numero di persone attualmente dentro la discoteca
    private final int capienzaMassima; // Capienza massima della discoteca

    public Discoteca(int capienzaMassima) {
        this.personeDentro = 0;
        this.capienzaMassima = capienzaMassima;
    }

    // Metodo sincronizzato per far entrare un gruppo, se la capienza lo permette
    public synchronized void entra(String nomeGruppo, int numeroPersone) throws InterruptedException {
        // Se il gruppo non può entrare perché supera la capienza, aspetta
        while (personeDentro + numeroPersone > capienzaMassima) {
            System.out.println(nomeGruppo + " è in attesa di entrare con " + numeroPersone + " persone.");
            wait(); // Il thread aspetta finché non c'è spazio
        }
        // Fa entrare il gruppo nella discoteca
        personeDentro += numeroPersone;
        System.out.println(nomeGruppo + " è entrato con " + numeroPersone + " persone.");
    }

    // Metodo sincronizzato per far uscire un gruppo
    public synchronized void esce(String nomeGruppo, int numeroPersone) {
        personeDentro -= numeroPersone;
        System.out.println(nomeGruppo + " è uscito con " + numeroPersone + " persone.");
        notifyAll(); // Notifica i gruppi in attesa che potrebbero ora entrare
    }

    // Metodo sincronizzato per ottenere il numero di persone dentro
    public synchronized int getNumeroPersoneDentro() {
        return personeDentro;
    }
}