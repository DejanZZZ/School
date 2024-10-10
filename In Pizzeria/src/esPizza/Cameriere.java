package esPizza;

public class Cameriere implements Runnable {
    private Forno forno;
    private Tavolo[] tavoli;

    public Cameriere(Forno forno, Tavolo[] tavoli) {
        this.forno = forno;
        this.tavoli = tavoli;
    }

    @Override
    public void run() {
        for (Tavolo tavolo : tavoli) {
            if (tavolo.getNumeroClienti() > 0) {
                servePizze(tavolo);
            }
        }
    }

    private void servePizze(Tavolo tavolo) {
        System.out.println("Cameriere sta servendo al " + tavolo.getIdTavolo());
        
        // Inforna le pizze ordinate
        for (String pizza : tavolo.getPizzaOrdinata()) {
            forno.inforna(pizza); // Inforna le pizze ordinate
        }

        // Serve le pizze
        for (String pizza : tavolo.getPizzaOrdinata()) {
            String pizzaPronta = forno.sforna();
            servePizza(tavolo, pizzaPronta);
        }
    }

    private void servePizza(Tavolo tavolo, String pizza) {
        System.out.println("Cameriere ha servito " + pizza + " al " + tavolo.getIdTavolo());
    }
}
