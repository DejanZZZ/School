package es3;

public class Cameriere implements Runnable {
    private Pizzeria pizzeria;
    private int id;

    public Cameriere(Pizzeria pizzeria, int id) {
        this.pizzeria = pizzeria;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            if (pizzeria.getPizzeDaConsegnare() == 0 && pizzeria.getTavoliOccupati() == 0) {
                break;  // Terminare quando tutte le pizze sono state consegnate
            }

            // Alterna tra prendere ordini e consegnare pizze
            if (Math.random() < 0.5) {
                prendiOrdine();
            } else {
                consegnaPizze();
            }

            try {
                Thread.sleep(2000);  // Tempo per gestire il servizio
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void prendiOrdine() {
        int tavolo = pizzeria.prendiOrdine();
        if (tavolo >= 0) {
            System.out.println("Cameriere " + id + " ha preso l'ordine al tavolo " + tavolo + ".");
        }
    }

    private void consegnaPizze() {
        int tavolo = pizzeria.consegnaPizze();
        if (tavolo >= 0) {
            System.out.println("Cameriere " + id + " ha consegnato le pizze al tavolo " + tavolo + ".");
        }
    }
}
