package es3;
import java.util.Random;

public class Forno implements Runnable {
    private Pizzeria pizzeria;

    public Forno(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int pizzeProdotte = random.nextInt(8) + 1;  // Produci da 1 a 8 pizze
            pizzeria.produciPizze(pizzeProdotte);
            System.out.println("Forno ha prodotto " + pizzeProdotte + " pizze.");

            try {
                Thread.sleep(5000);  // Tempo per cucinare le pizze
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (pizzeria.getPizzeDaConsegnare() == 0 && pizzeria.getTavoliOccupati() == 0) {
                System.out.println("Tutte le pizze sono state consegnate! Simulazione terminata.");
                break;
            }
        }
    }
}
