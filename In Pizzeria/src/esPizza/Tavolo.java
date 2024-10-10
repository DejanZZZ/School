package esPizza;

import java.util.Random;

public class Tavolo implements Runnable {
    private final int idTavolo;
    private final int maxClienti;
    private int nClienti;
    private String[] pizzaOrdinata;
    private String[] menu;

    public Tavolo(int idTavolo) {
        this.idTavolo = idTavolo;
        this.maxClienti = 5;
        this.nClienti = (int) (Math.random() * (maxClienti + 1));
        this.menu = new String[]{"Margherita", "Diavola", "4Stagioni", "Wurstel"};
        this.pizzaOrdinata = new String[nClienti];
        ordinaPizze();
    }

    @Override
    public void run() {
        System.out.println("Tavolo " + idTavolo + " ha " + nClienti + " clienti.");
        try {
            Thread.sleep(1000); // Simula il tempo per prendere l'ordine
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void ordinaPizze() {
        Random random = new Random();
        for (int i = 0; i < nClienti; i++) {
            pizzaOrdinata[i] = menu[random.nextInt(menu.length)];
        }
    }

    public String[] getPizzaOrdinata() {
        return pizzaOrdinata;
    }

    public int getIdTavolo() {
        return idTavolo;
    }

    public int getNumeroClienti() {
        return nClienti;
    }
}
