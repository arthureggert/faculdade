package project3;

import java.time.Year;

public class Motorrad extends Motorisiert {

    public Motorrad(int neupreis, int baujahr, int gefahreneKilometer) {
        super(neupreis, baujahr, gefahreneKilometer);
    }

    public Motorrad(Motorrad motorrad) {
        super(motorrad);
    }

    @Override
    public int preis() {
       return super.preis();
    }
}
