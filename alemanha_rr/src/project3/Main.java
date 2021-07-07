package project3;

public class Main {
    public static void main(String[] args) {
        Fahrzeug fahrzeug = new Pkw(1000,2019, 15000);
        Pkw golf = (Pkw) fahrzeug;
        golf.fahre(10);
        System.out.println(golf.preis());
    }



}
