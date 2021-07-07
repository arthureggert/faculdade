package project_4;

import java.util.Arrays;

import static java.lang.Math.toIntExact;

class AccountManager {

    private Konto[] konten;

    public AccountManager(int size) {
        this.konten = new Konto[size];      // TODO why is size coupled to AccountManager?
    }

    private boolean isKontenFull() {
        boolean isFull = false;
        for (int x = 0; x < konten.length; x++) {
            if (x == konten.length - 1 && this.konten[x] != null) {
                isFull = true;
                break;
            }
        }
        return isFull;
    }

    private int getNextPosition() {
        int possition = 0;
        for (int x = 0; x < konten.length; x++) {
            if (this.konten[x] == null) {
                possition = x;
                break;
            }
        }
        return possition;
    }

    private void increaseSizeBy10Percent() {
        long newSize = Math.round(konten.length * 1.1);
        if (newSize == this.konten.length) {
            newSize = this.konten.length + 1;
        }
        Konto[] temp = new Konto[toIntExact(toIntExact(newSize))];
        System.arraycopy(konten, 0, temp, 0, konten.length);
        this.konten = temp;
    }

    public void addKonto(Konto konto) {
        if (isKontenFull()) {
            this.increaseSizeBy10Percent();
        }
        this.konten[this.getNextPosition()] = konto;
    }

    public void removeKonto(long kontoNummer) {
        Integer removeIndex = null;

        for (int i = 0; i < this.konten.length; i++) {
            if (kontoNummer == konten[i].getKontonummer()) {
                removeIndex = i;
            }
        }

        if (removeIndex == null) {
            throw new IllegalArgumentException("Konto Nummer " + kontoNummer + " not found");
        }

        Konto[] temp = new Konto[konten.length];

        for (int i = 0, j = 0; i < konten.length; i++) {
            // check if index is crossed, continue without copying
            if (i != removeIndex) {
                temp[j++] = konten[i];
            }
        }
        konten = temp;
    }

    @Override
    public String toString() {
        return "AccountManager{" +
                "konten=" + Arrays.deepToString(konten) +
                '}';
    }
}