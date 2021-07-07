package project3;

public class Pkw extends Motorisiert {

    public Pkw(int neupreis, int baujahr, int gefahreneKilometer) {
        super(neupreis, baujahr, gefahreneKilometer);
    }

    public Pkw(Pkw pkw) {
        super(pkw);
    }

    @Override
    public int preis() {
        int price = super.preis();
        int killometers = this.getGefahreneKilometer() / 10000;
        int kmPriceReduction = (int) Math.round(this.getNeupreis() * 0.7);
        for (int i = 0; i < killometers; i++) {
            price = price - kmPriceReduction;
        }
        return price;
    }
}
