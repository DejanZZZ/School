package es2;

class Cinema {
    private final int[][] posti; // Matrice che rappresenta le file e i posti
    private int postiRimanenti;

    public Cinema() {
        this.posti = new int[15][46]; // 15 file, 46 posti per fila
        this.postiRimanenti = 15 * 46; // Posti totali
    }

    // Metodo synchronized per garantire che due thread non prenotino lo stesso posto
    public synchronized boolean prenotaPosto(int threadId) {
        if (postiRimanenti <= 0) {
            return false; // Nessun posto disponibile
        }

        // Prova a trovare i posti centrali in ogni fila
        for (int i = 0; i < posti.length; i++) {
            int fila = i;
            int postoCentrale = posti[0].length / 2;

            // Cerca posti liberi dal centro verso l'esterno
            for (int j = 0; j < postoCentrale; j++) {
                int sinistra = postoCentrale - j;
                int destra = postoCentrale + j;

                if (sinistra >= 0 && posti[fila][sinistra] == 0) {
                    posti[fila][sinistra] = threadId; // Prenota il posto
                    postiRimanenti--;
                    System.out.println("Thread " + threadId + " ha prenotato il posto: Fila " + fila + " Posto " + sinistra);
                    return true;
                }

                if (destra < posti[0].length && posti[fila][destra] == 0) {
                    posti[fila][destra] = threadId; // Prenota il posto
                    postiRimanenti--;
                    System.out.println("Thread " + threadId + " ha prenotato il posto: Fila " + fila + " Posto " + destra);
                    return true;
                }
            }
        }

        return false; // Nessun posto disponibile
    }

    // Metodo per ottenere il numero di posti disponibili
    public synchronized int getPostiRimanenti() {
        return postiRimanenti;
    }
}