package es1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiedi i valori T ed N all'utente
        System.out.print("Inserisci il numero di thread (T): ");
        int T = scanner.nextInt();
        System.out.print("Inserisci il valore massimo (N): ");
        int N = scanner.nextInt();

        // Crea un gestore di thread
        ThreadManager manager = new ThreadManager(T, N);

        // Ciclo per monitorare lo stato dei thread una volta al secondo
        while (!manager.areAllThreadsCompleted()) {
            manager.printThreadStatus();
            try {
                Thread.sleep(1000); // Attesa di 1 secondo prima di controllare di nuovo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Stampa finale quando tutti i thread sono completati
        System.out.println("TUTTI I THREAD COMPLETATI");
        
        scanner.close();
    }
}