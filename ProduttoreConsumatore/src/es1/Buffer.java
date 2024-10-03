package es1;
import java.util.Queue;
import java.util.LinkedList;

public class Buffer {
    private Queue<Integer> Coda;

    public Buffer() {
        Coda = new LinkedList<>();  // La coda può crescere dinamicamente
    }

    public synchronized void Enqueue(int n) {
        Coda.add(n); // Aggiunge il numero in coda
        notifyAll(); // Notifica che un nuovo elemento è disponibile
    }

    public synchronized int Dequeue() {
        while (Coda.isEmpty()) {
            try {
                wait(); // Attende che ci siano elementi nel buffer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return Coda.remove(); // Rimuove il primo elemento dalla coda
    }
}