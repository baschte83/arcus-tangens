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
     * Constant value THREE is just a workaround to not use a "magic number" in the formula to compute the series.
     */
    private static final double EPSILON = 1E-16;
    private static final double THREE = 3.0;

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
        int twoN;									        // variable to store the value of the operation 2*n used in the formula


        // While loop to compute the arctangent of x with an accuracy of EPSILON.
        while (Math.abs(anPlusOne) > EPSILON) {

            twoN = 2 * n;
            an = Math.pow(-1, n) * ((Math.pow(x, twoN + 1) / (twoN + 1)));
            anPlusOne = (-((twoN + 1.0) / (twoN + THREE)) * x * x) * an;
            sn += an;
            n++;

        }


        // Output of the arctangent of x computed with my algorithm.
        System.out.println(sn);

        // Output of the arctangent of x computed with the java MATH library function Math.atan(x).
        System.out.println(Math.atan(x));

    }
}
