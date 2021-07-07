package project_4;

abstract class Konto implements CalculateInterest { // why is konto not an interface? because you need to copy the 3 lines below to GiroKonto and SparbuchKonto
    private long kontonummer;
    private Inhaber inhaber;
    protected double balance;

    public Konto(long kontonummer, Inhaber inhaber, double balance) {
        this.kontonummer = kontonummer;
        this.inhaber = inhaber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public long getKontonummer() {
        return kontonummer;
    }

    public Inhaber getInhaber() {
        return inhaber;
    }

    @Override                   //TODO : Override for easy println      DONE
    public String toString() {
        return String.format("\n" + "Kontonummer: " + kontonummer + " \t" + "Inhaber: " + inhaber + " \t" + "Kontostand: " + balance + "\n");
    }
}
