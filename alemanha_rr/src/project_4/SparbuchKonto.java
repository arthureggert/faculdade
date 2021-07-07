package project_4;

class SparbuchKonto extends Konto {



    public SparbuchKonto(long kontonummer, Inhaber inhaber, double balance) {
        super(kontonummer, inhaber, balance);
    }


    @Override
    public void calculateInterest() {
        // maths goes here

        this.balance = balance * 1.01;      //increasing balance by 1%. SparbuchKonto gets 1% interest


    }


}