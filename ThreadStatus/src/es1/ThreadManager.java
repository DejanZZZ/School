package es1;
import java.util.Random;

//Classe ThreadManager per gestire l'esecuzione e lo stato dei thread
class ThreadManager {
 private Thread[] threads;
 private CounterRunnable[] runnables;

 public ThreadManager(int T, int N) {
     threads = new Thread[T];
     runnables = new CounterRunnable[T];
     Random random = new Random();

     // Crea e avvia T thread
     for (int i = 0; i < T; i++) {
         int target = random.nextInt(N + 1); // Genera un numero casuale tra 0 e N
         runnables[i] = new CounterRunnable(target, i); // Crea l'oggetto Runnable
         threads[i] = new Thread(runnables[i]); // Associa Runnable a un nuovo thread
         threads[i].start(); // Avvia il thread
     }
 }

 // Metodo per stampare lo stato dei thread
 public void printThreadStatus() {
     for (int i = 0; i < runnables.length; i++) {
         if (runnables[i].isCompleted()) {
             System.out.println("Thread " + runnables[i].getId() + ": COMPLETATO");
         } else {
             System.out.println("Thread " + runnables[i].getId() + ": Contando a " + runnables[i].getCount());
         }
     }
 }

 // Metodo per verificare se tutti i thread sono completati
 public boolean areAllThreadsCompleted() {
     for (CounterRunnable runnable : runnables) {
         if (!runnable.isCompleted()) {
             return false;
         }
     }
     return true;
 }
}