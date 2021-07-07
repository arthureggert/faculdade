package project3;

import java.time.Year;

public class Fahrrad extends Fahrzeug{

    private int ganganzahl;

    private int sturzanzahl;

    public Fahrrad(int neupreis, int baujahr, int ganganzahl, int sturzanzahl) {
        super(neupreis, baujahr);
        this.ganganzahl = ganganzahl;
        this.sturzanzahl = sturzanzahl;
    }

    public Fahrrad(Fahrrad fahrrad) {
        super(fahrrad);
        this.sturzanzahl = fahrrad.sturzanzahl;
        this.ganganzahl = fahrrad.ganganzahl;
    }





    @Override
    public int preis() {
        int currentYear = Year.now().getValue();
        int startingYear =  this.getBaujahr();
        int price = this.getNeupreis();
        int fallPriceReduction = (int) Math.round(this.getNeupreis() * 0.8);
        while(startingYear < currentYear) {
            price = (int) Math.round(price * 0.93);
            startingYear++;
        }
        for (int i = 0; i < this.sturzanzahl; i++) {
            price = price - fallPriceReduction;
        }

        return price;
    }
}
