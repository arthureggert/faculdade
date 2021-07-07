package rainer_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VektorCalc {

    public static VektorWinkel KoordZuWinkel(VektorKoord koord) {       // calculation Method of 1.a)
        double theta = Math.atan2(koord.y, koord.x);                    // atan2 returns a numeric value between –pi and pi . Converted to Degrees, it will always be between -180 and 180.
        VektorWinkel winkel = new VektorWinkel();                       // creating a new VektorWinkel instance called "winkel"
        winkel.angle = Math.toDegrees(theta);                           // converting theta from Radians to degrees
        winkel.length = Math.sqrt(Math.pow(koord.x, 2) + Math.pow(koord.y, 2)); // calculating the length of the vector
        return winkel;
    }

    public static VektorKoord WinkelZuKoord(VektorWinkel winkel) {      // calculation Method of 1.b)
        VektorKoord koord = new VektorKoord();                          // creating a new VektorKoord instance called "koord"
        koord.x = winkel.length * Math.cos(Math.toRadians(winkel.angle));   // calculating Vector Coordinate X from angle and length
        koord.y = winkel.length * Math.sin(Math.toRadians(winkel.angle));   // calculating Vector Coordinate Y from angle and length
        return koord;
    }

    public static VektorWinkel MultWinkel(VektorWinkel winkel, Integer multiplier) {    // calculation Method of 1.c)
        VektorWinkel multipliedWinkel = new VektorWinkel();                             // creating a VektorWinkel instance called "multipliedWinkel"
        for (int i = 1; i <= multiplier; i++) {                                         // Iteration to multiply through addition
            multipliedWinkel.angle += winkel.angle;
        }
        if (multipliedWinkel.angle > 180) {                                             // Calculating angles above 180 to fit into -180 to 180 Degrees
            multipliedWinkel.angle = (multipliedWinkel.angle % 180) - 180;
        }
        if (multipliedWinkel.angle < -180) {                                            // Calculating angles below 180 to fit into -180 to 180 Degrees
            multipliedWinkel.angle = multipliedWinkel.angle % 180;
        }
        return multipliedWinkel;
    }

    private static void KoordZuWinkelGet() {                                          // Method to get user input to Calculate KoordZuWinkel (1.a)

        Scanner in = new Scanner(System.in);                                          // initializing Scanner
        double x = 0;                                                                 // creating X and Y coordinates
        double y = 0;

        do
        {                                                                          // do-while loop to keep asking for input, as long as x is still 0 or input is 'NaN'
            System.out.println("Please enter your X-Coordinate.");
            try {                                                                     // try-catch block to check whether input is double and throw exception
                x = in.nextDouble();
                if (Double.isNaN(x)) {                                                // checking for Input = 'NaN' , since its not caught by in.nextDouble()
                    throw new InputMismatchException(" 'NaN' has been entered ");
                }
            } catch (InputMismatchException a) {
                System.out.println("This is not a viable Coordinate. Example : 56,3");
                in.nextLine();
            }
        } while (x == 0 || Double.isNaN(x));

        do
        {                                                                                // see line 45-51 for comments, same applies here.
            System.out.println("Please enter the Y-Coordinate.");
            try {
                y = in.nextDouble();
                if (Double.isNaN(y)) {
                    throw new InputMismatchException(" 'NaN' has been entered ");
                }
            } catch (InputMismatchException a) {
                System.out.println("Please enter a valid Coordinate. Example : 3,6");
                in.nextLine();
            }
        } while (y <= 0 || Double.isNaN(x) || Double.isNaN(y));

        VektorKoord koord = new VektorKoord();                                             // creating a new VektorKoord called "koord"
        koord.x = x;                                                                       // assigning input x to koord.x
        koord.y = y;                                                                        // assigning input y to koord.y
        VektorWinkel result = VektorCalc.KoordZuWinkel(koord);                             // Calculation with input coordinates and assigning it to temporary variable "result"
        System.out.println("Your angle is : " + result.angle);                              // OUTPUT
        System.out.println("The length of your Vector is : " + result.length);              // OUTPUT , not asked by task, maybe nice to know though
    }

    private static void WinkelZuKoordGet() {                                               //Method to get user input to Calculate WinkelZuKoord (1.b)
        // same as Method above
        Scanner in = new Scanner(System.in);
        double length = 0;
        double angle = 0;

        do {
            System.out.println("Please enter your angle");
            try {
                angle = in.nextDouble();
                if (Double.isNaN(angle)) {
                    throw new InputMismatchException(" 'NaN' has been entered ");
                }
            } catch (InputMismatchException a) {
                System.out.println("This is not a viable angle. Example : 56,3");
                in.nextLine();
            }
        } while (angle == 0 || Double.isNaN(angle));             // CHECKING FOR INPUT = "NaN"

        do {
            System.out.println("Please enter the length of your vector.");
            try {
                length = in.nextDouble();
                if (Double.isNaN(length)) {
                    throw new InputMismatchException(" 'NaN' has been entered ");
                }
            } catch (InputMismatchException a) {
                System.out.println("Please enter a valid length. Example : 3,6");
                in.nextLine();
            }
        } while (length <= 0 || Double.isNaN(angle) || Double.isNaN(length));

        VektorWinkel winkel = new VektorWinkel();
        winkel.angle = angle;
        winkel.length = length;
        VektorKoord result = VektorCalc.WinkelZuKoord(winkel);
        System.out.println(result.x + " " + result.y);
    }


    private static void MultWinkelGet() {                                                           //Method to get user input to Calculate MultWinkel (1.c)
        // same as Method above

        Scanner in = new Scanner(System.in);
        double angle = 0;
        int multiplier = 0;

        do {
            System.out.println("Please enter your angle");
            try {
                angle = in.nextDouble();
                if (Double.isNaN(angle)) {
                    throw new InputMismatchException(" 'NaN' has been entered ");
                }
            } catch (InputMismatchException a) {
                System.out.println("This is not a viable angle. Example : 26");
                in.nextLine();
            }
        } while (angle == 0 || Double.isNaN(angle));             // CHECKING FOR INPUT = "NaN"

        do {
            System.out.println("Please enter the multiplier");
            try {
                multiplier = in.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("Please enter a positive multiplier. Maybe 5 ?");
                in.nextLine();
            }
        } while (multiplier <= 0);
        VektorWinkel winkel = new VektorWinkel();
        winkel.angle = angle;
        VektorWinkel result = VektorCalc.MultWinkel(winkel, multiplier);
        System.out.println(result.angle);
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int ch = 0;

        System.out.println("Welcome to my Vector Calculation Program! \nPlease pick an option by entering the corresponding number.");         // Input Menu
        System.out.println("1. Angle from Vector");
        System.out.println("2. Vector from Angle and length");
        System.out.println("3. MultiAngle/ Angle * Multiplier");
        System.out.println("4. Quit.");

        do
        {                                                                                                                         // looping the try-catch block
            try {                                                                                                                   // try-catch to check for an INT as input
                ch = in.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("Invalid choice. Please choose one of the options between 1. and 4.");
                ch = 0;
                in.nextLine();
            }
        } while (ch == 0);
        // TODO : LOOP FAILURE if incorrect input VVVVVVVVVV

        do {

            switch (ch) {
                case 1: {                                                                                            // lambda to make cases prettier
                    System.out.println("You chose to get the angle from your Coordinates!");
                    KoordZuWinkelGet();                                                                                 // Using Method for 1.a)
                    break;
                }
                case 2: {
                    System.out.println("You chose to get vector coordinates from an angle and vector length !");
                    WinkelZuKoordGet();                                                                                 // Using Method for 1.b)
                    break;
                }
                case 3: {
                    System.out.println("You chose to multiply an angle !");
                    MultWinkelGet();                                                                                    // Using Method for 1.c)
                    break;
                }
                default: {
                    System.out.println("Invalid Choice.");
                }
            }
            System.out.println("Please pick an option by entering the corresponding number.");
            System.out.println("1. Angle from Vector");
            System.out.println("2. Vector from Angle and length");
            System.out.println("3. MultiAngle/ Angle * Multiplier");
            System.out.println("4. Quit.");

            do {
                try {
                    ch = in.nextInt();
                } catch (InputMismatchException a) {
                    System.out.println("Invalid choice. Please choose one of the options between 1. and 4.");
                    ch = 0;
                    in.nextLine();
                }
            } while (ch == 0);
        } while (ch != 4);

    }
}