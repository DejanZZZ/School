package es1;

// Definizione della classe CounterRunnable che implementa Runnable
class CounterRunnable implements Runnable {
    private int target;      // Valore X massimo che il thread deve raggiungere
    private int count = 0;   // Contatore corrente
    private boolean completed = false;  // Stato del thread (se ha completato o meno)
    private final int id;    // Identificativo del thread

    public CounterRunnable(int target, int id) {
        this.target = target;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (count <= target) {
                Thread.sleep(120); // Attesa di 120ms tra ogni conteggio
                count++; // Incrementa il contatore
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Gestione delle interruzioni del thread
        }
        completed = true; // Segna il thread come completato
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}