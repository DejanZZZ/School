package esPizza;

import java.util.Queue;
import java.util.LinkedList;

public class Forno {
    
    private final int maxPizze;
    private Queue<String> pizzeInCottura;
    
    public Forno() {
        maxPizze = 8;
        pizzeInCottura = new LinkedList<>();
    }
    
    public synchronized void inforna(String pizza) {
        while (pizzeInCottura.size() >= maxPizze) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pizzeInCottura.add(pizza);
        System.out.println("Infornata: " + pizza);
        notifyAll();
    }
    
    public synchronized String sforna() {
        while (pizzeInCottura.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String pizza = pizzeInCottura.remove();
        System.out.println("Sfornata: " + pizza);
        notifyAll();
        return pizza;
    }
}
