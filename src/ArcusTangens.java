/* Organisation: Hochschule München, Fakultät 07
 * Project: Praktikum Softwareentwicklung 1 Frau Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, bauman21@hm.edu
 * Study group: IF3A
 * Date: 26. Oktober 2016
 * Purpose: Lösung "Praktikumsinheit 02", Aufgabe Arcus Tangens
 * Software: Oracle Java SE JDK 1.8.0_101, Windows 10 x86_64
 * Hardware: Intel Core i5-6300 @ 2.40 GHz 2.50 GHz, 2 Cores, 4096 MB RAM
 */

public class ArcusTangens {

    // Konstante für Rechengenauigkeit
    private static final double EPSILON = 1E-16;

    public static void main(String[] args) {

        // Definition der benötigten Variablen
        double x = Double.parseDouble(args[0]); 			// x-Wert des Benutzers, von dem der Arcus Tangens berechnet werden soll
        double sn = x;										// Variable zum speichern der berechneten Partialsumme
        double an = x;										// Variable zum speichern von einem Summanden an
        double anPlusOne = x;								// Variable zum speichern des nächsten Summanden an+1, berechnet an+1 ausgehend von an (rekursiv)
        int n = 1;									// Zählvariable, wird in der Schleife benutzt
        int twoN;									// Variable zum Speichern des Wertes von (2n), da dieser Wert in der Berechnung von sn oft benötigt wird


        // Berechnung des Arcus Tangens mittels einer while-Schleife
        while (Math.abs(anPlusOne) > EPSILON) {

            twoN = 2 * n;
            an = Math.pow(-1, n) * ((Math.pow(x, twoN + 1) / (twoN + 1)));
            anPlusOne = (-((twoN + 1.0) / (twoN + 3.0)) * x * x) * an;
            sn += an;
            n++;

        }

        // Ausgabe des von meinem Programm berechneten Wertes Arcus Tangens von x
        System.out.println(sn);
        // Ausgabe des von Math.atan berechneten Vergleichswerts des Arcus Tangens von x
        System.out.println(Math.atan(x));

    }
}
