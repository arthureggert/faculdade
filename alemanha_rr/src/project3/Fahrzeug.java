package project3;

public abstract class Fahrzeug {
    private int neupreis;
    private int baujahr;

    public Fahrzeug(int neupreis, int baujahr) {
        this.neupreis = neupreis;
        this.baujahr = baujahr;
    }

    public Fahrzeug(Fahrzeug fahrzeug) {
        this.neupreis = fahrzeug.getNeupreis();
        this.baujahr = fahrzeug.getBaujahr();
    }

    public int getNeupreis() {
        return neupreis;
    }

    public void setNeupreis(int neupreis) {
        this.neupreis = neupreis;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public abstract int preis();
}
