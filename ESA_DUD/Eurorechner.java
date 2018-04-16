package ESA_DUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Chris Merscher
 * @version 1.0, 16.04.2018
 */

public class Eurorechner {

    private static final double KURS = 1.29535;

    public static void main(String[] args) throws IOException {
    umrechnen();
    }

    /**
     * Text von der Konsole einlesen und zurueckgeben.
     *
     *            Bezeichnung welcher Wert eingegeben werden soll
     * @return von Konsole eingelesener Wert
     * @throws IOException
     */
    public static void umrechnen() throws IOException {

        // Eingabestroeme erzeugen und miteinander verbinden
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        // Datenfluss: Programm <-- bReader <-- InputStreamReader <-- Standardeingabe

        String betrag;
        double betragAlsDouble;
        double betragum;
        String entscheidung;
        String richtung;

        do {
            //Währung einlesen
            System.out.print("Eingabe der Ausgangswaehrung (E)uro oder (U)S Dollar?: ");
            richtung = bReader.readLine();

            //Betrag einlesen
            System.out.print("Eingabe des Betrags: ");
            betrag = bReader.readLine();

            //Eingabe in Double umwandeln. Falss keine Zahl, Ausnhame werfen
            try {
                betragAlsDouble = Double.parseDouble(betrag);

                //Wenn EUR zu USD, dann...
                if (richtung.equals("E") || richtung.equals("e")) {
                    betragum = EurZuUsd(betragAlsDouble);                                    //Funktion ausführen...
                    System.out.printf("%.2f EUR sind %.2f USD! \n", betragAlsDouble, betragum);   //...und ausgeben!
                }

                //Wenn USD zu EUR, dann...
                else if (richtung.equals("U") || richtung.equals("u")) {
                    betragum = UsdZuEur(betragAlsDouble);                                    //Funktion ausführen...
                    System.out.printf("%.2f USD sind %.2f EUR! \n", betragAlsDouble, betragum);   //...und ausgeben!
                }
                else System.out.println("Falsche Eingabe! Bitte nochmal!");
            }
            //Falls eingegebener Betrag keine Zahl...
            catch (NumberFormatException e)
            {
                System.out.println("Falsche Eingabe! Bitte nochmal!");
            }

            // Abfrage ob Benutzer weitere Daten eingeben will
            System.out.print("Wollen Sie noch einmal? (ja = j, nein = n): ");
            entscheidung = bReader.readLine();

        } while (entscheidung.equals("j") || entscheidung.equals("ja"));
    }

    //Methode zur Umrechnung EUR zu USD
    private static double EurZuUsd (double betrag){
        return betrag * KURS;
    }
    //Methode zur Umrechnung USD zu EUR
    private static double UsdZuEur (double betrag){
        return betrag / KURS;
    }
}
