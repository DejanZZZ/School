package es3;
import java.util.Random;

class Persona implements Runnable {
    private Discoteca discoteca;
    private Random random;

    public Persona(Discoteca discoteca) {
        this.discoteca = discoteca;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // La persona entra in discoteca
            discoteca.entra();
            System.out.println(Thread.currentThread().getName() + " è entrata in discoteca.");

            // Resta dentro per un tempo casuale tra 1 e 5 secondi
            try {
                Thread.sleep(1000 + random.nextInt(4000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // La persona esce dalla discoteca
            discoteca.esce();
            System.out.println(Thread.currentThread().getName() + " è uscita dalla discoteca.");

            // Attende un po' prima di rientrare (tempo casuale tra 1 e 3 secondi)
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}