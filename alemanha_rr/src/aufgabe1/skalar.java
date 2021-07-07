package aufgabe1;

import java.util.Scanner;

public class skalar {

    public static void main (String args[]){

        double vector_input1 = 0.0;   // Initializing input Vektor x axis
        double vector_input2 = 0.0;   // Initializing input Vektor y axis

        double vector_ex1 = 1.0;  // Initializing X - Coordinate of Vector on X-axis
        double vector_ex2 = 0.0;  // Initializing Y - Coordinate of Vector on X-axis


        // INPUT

        Scanner in = new Scanner(System.in);                                                    // Scanner initializing

        System.out.println("Please enter the x - coordinate of your vector.");                  // prompting user to input x coordinate



        while(true) {                                                                                   // while(true) loop to be able to input indefinitely until conditions are met
            if (in.hasNextDouble()) {                                                                   // if/else to check whether input is double
                vector_input1 = in.nextDouble();                                                        // assigning user input to vector x-axis variable

                System.out.println("The x - coordinate is " + vector_input1);                           // confirming assignment

                System.out.println("Please enter the y - coordinate of your vector");                   // prompting user to input y coordinate

                break;
            } else {
                System.out.println("Please enter a valid number. For example : 2");
                in.nextLine();
            }
        }

        // System.out.println("Please enter the y - coordinate of your vector");                   // prompting user to input y coordinate


        // TODO : //while(true) {
        if (in.hasNextDouble()) {                                                                   // if/else to check whether input is double
            vector_input2 = in.nextDouble();                                                        // assigning user input to vector y-axis variable
            System.out.println("The y - coordinate is " + vector_input2);                           // confirming assignment
        } else {
            System.out.println("Please enter a valid number. For example : 2");
            in.nextLine();

        }
        //   }


        // CALCULATION
        double temp_angle = ((vector_input1 * vector_ex1) + (vector_input2 * vector_ex2)) / ((Math.sqrt((vector_input1*vector_input1)+(vector_input2*vector_input2))) * Math.sqrt((vector_ex1*vector_ex1)+(vector_ex2*vector_ex2)));
        // ^ calculation of vectors

        double angle_cos = Math.acos(temp_angle); // calculation of arcus cosinus ( cos^-1) of vectors and assigning it to "angle_cos"

        double angle = Math.toDegrees(angle_cos); // converting arcus cosinus to degrees and assigning it to "angle"


        // OUTPUT

        System.out.println("angle = " + angle); // output of angle

    }



}
