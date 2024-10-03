package es3;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();

        Thread forno = new Thread(new Forno(pizzeria));
        forno.start();

        Thread cameriere1 = new Thread(new Cameriere(pizzeria, 1));
        Thread cameriere2 = new Thread(new Cameriere(pizzeria, 2));
        Thread cameriere3 = new Thread(new Cameriere(pizzeria, 3));

        cameriere1.start();
        cameriere2.start();
        cameriere3.start();
    }
}
