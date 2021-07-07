package project_4;

class GiroKonto extends Konto {
    public GiroKonto(long kontonummer, Inhaber inhaber, double balance) { super(kontonummer, inhaber, balance); }

    @Override
   public void calculateInterest() {
        // Negative interest if balance is <0.
        // TODO : INDIVIDUALLY SET-able for each account

        if(balance < 0) {
            this.balance = balance * 0.99;          // decreasing balance by 1% . Negative interest of 1%
        }
        else{
            System.out.println("This GiroKonto has no negative balance.");
        }

    }
}