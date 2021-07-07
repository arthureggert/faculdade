package aufgabe1;

import java.util.Scanner;

public class VectorCalc {

    public static VektorWinkel KoordZuWinkel(VektorKoord koord) {
        double theta = Math.atan2(koord.y, koord.x);
        VektorWinkel winkel = new VektorWinkel();
        winkel.angle = Math.toDegrees(theta);
        winkel.length = Math.sqrt(Math.pow(koord.x, 2) + Math.pow(koord.y, 2));
        return winkel;
    }

    public static VektorKoord WinkelZuKoord(VektorWinkel winkel) {
        VektorKoord koord = new VektorKoord();
        koord.x = winkel.length * Math.cos(Math.toRadians(winkel.angle));
        koord.y = winkel.length * Math.sin(Math.toRadians(winkel.angle));
        return koord;
    }

    public static VektorWinkel MultWinkel(VektorWinkel winkel, Integer multiplier) {
        VektorWinkel multipliedWinkel = new VektorWinkel();
        for (int i = 1; i <= multiplier ; i++) {
            multipliedWinkel.angle += winkel.angle;
        }
        if(multipliedWinkel.angle > 180) {
            multipliedWinkel.angle = (multipliedWinkel.angle % 180) - 180;
        }
        if(multipliedWinkel.angle < -180) {
            multipliedWinkel.angle = multipliedWinkel.angle % 180;
        }
        return multipliedWinkel;
    }

    private static Scanner printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the option: \n 1: KoordZuWinkel \n 2: WinkelZuKoord \n 3: MultWinkel \n 4: Quit \n Selection:");
        return scanner;
    }

    public static void main(String args[]) {

        int choice = 1;

        switch (choice) {
            case 1:
                // Perform "original number" case.
                break;
            case 2:
                // Perform "encrypt number" case.
                break;
            case 3:
                // Perform "decrypt number" case.
                VektorWinkel winkel = new VektorWinkel();
                winkel.angle = 32;
                VektorWinkel e = MultWinkel(winkel, 10);
                System.out.println(e.angle);
                break;
            case 4:
            // Perform "quit" case.
                break;
            default:
                System.out.println("Wrong option");
        }

    }

}
