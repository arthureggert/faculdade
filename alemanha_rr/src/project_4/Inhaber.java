package project_4;

class Inhaber{
    private String vorname;
    private String nachname;
    private String personalausweisnr;

    public Inhaber(String vorname, String nachname, String personalausweisnr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.personalausweisnr = personalausweisnr;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getPersonalausweisnr() {
        return personalausweisnr;
    }

    @Override           //TODO : Override for easy println       DONE
    public String toString() {
        return String.format( vorname + " " + nachname + "\t"+"Pers.ID: " + personalausweisnr +"\t");
    }
}