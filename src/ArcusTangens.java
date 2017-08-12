/**
 * Organisation: University of applied sciences Munich, faculty 07
 * Project: lab to class software developement 1 Mrs. Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, sebastian_baumann@gmx.net
 * Study group: IF3A
 * Date: 26. Oktober 2016
 * Purpose: solution to lab Arcus Tangens
 */
public class ArcusTangens {

    /**
     * Constant value EPSILON which stores the accuracy with which the arctangent is computed.
     */
    private static final double EPSILON = 1E-16;

    /**
     * Main method to compute the arctangent.
     * @param args - variable number of arguments handeld over from the terminal.
     */
    public static void main(String[] args) {

        // Definition of all used variable values in the formula.
        double x = Double.parseDouble(args[0]); 			// value the user wants to compute the arctangent of
        double sn = x;										// variable to store the computed partial sum
        double an;										    // variable to store the computed operand an
        double anPlusOne = x;								// variable to store the operand an+1 (recursive with an as the beginning)
        int n = 1;									        // counter used in the while loop


        // While loop to compute the arctangent of x with an accuracy of EPSILON.
        while (Math.abs(anPlusOne) > EPSILON) {

            an = Math.pow(-1, n) * ((Math.pow(x, 2 * n + 1) / (2 * n + 1)));
            sn += an;
            anPlusOne = (-((2 * n + 1.0) / (2 * (n + 1) + 1)) * x * x) * an;
            n++;

        }


        // Output of the arctangent of x computed with my algorithm.
        System.out.printf("Arctangent of %.1f computed with my algorithm:  %.16f\n", x, sn);

        // Output of the arctangent of x computed with the java MATH library function Math.atan(x).
        System.out.printf("Arctangent of %.1f computed with Math function: %.16f", x, Math.atan(x));

    }
}
