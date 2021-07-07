package project3;

import java.time.Year;

public abstract class Motorisiert extends Fahrzeug {

    private int gefahreneKilometer;

    public Motorisiert(int neupreis, int baujahr, int gefahreneKilometer) {
        super(neupreis, baujahr);
        this.gefahreneKilometer = gefahreneKilometer;
    }

    public Motorisiert(Motorisiert motorisiert) {
        super(motorisiert);
        this.gefahreneKilometer = motorisiert.gefahreneKilometer;
    }

    public int getGefahreneKilometer() {
        return gefahreneKilometer;
    }

    public void setGefahreneKilometer(int gefahreneKilometer) {
        this.gefahreneKilometer = gefahreneKilometer;
    }

    public int fahre(int strecke) {
        this.gefahreneKilometer = this.gefahreneKilometer + strecke;
        return this.gefahreneKilometer;
    }

    @Override
    public int preis() {
        int currentYear = Year.now().getValue();
        int startingYear =  this.getBaujahr();
        int price = this.getNeupreis();
        while(startingYear < currentYear) {
            price = (int) Math.round(price * 0.9);
            startingYear++;
        }
        return price;
    }
}
