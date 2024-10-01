package es6;
import java.util.Random;

class GruppoPersone implements Runnable {
    private Discoteca discoteca;
    private String nomeGruppo;
    private int numeroPersone;
    private Random random;

    public GruppoPersone(Discoteca discoteca, String nomeGruppo, int numeroPersone) {
        this.discoteca = discoteca;
        this.nomeGruppo = nomeGruppo;
        this.numeroPersone = numeroPersone;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Prova ad entrare in discoteca
                discoteca.entra(nomeGruppo, numeroPersone);

                // Resta dentro per un tempo casuale (1-5 secondi)
                Thread.sleep(1000 + random.nextInt(4000));

                // Esce dalla discoteca
                discoteca.esce(nomeGruppo, numeroPersone);

                // Aspetta un po' prima di provare a rientrare (1-3 secondi)
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}