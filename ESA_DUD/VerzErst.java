package ESA_DUD;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * @author Chris Merscher
 * @version 1.0, 19.04.2018
 */

public class VerzErst {

    //Fordert zur Eingabe eines Strings (hier: Pfad) auf und liefert diesen zurück
    protected static String eingeben(String text) throws IOException {

        //Scanner zum Einlesen von Daten über die Konsole
        Scanner scanner = new Scanner(System.in);

        //eingelesener String
        String pfadAlsString;

        //Pfad einlesen
        System.out.println(text);
        pfadAlsString = scanner.next();

        //Eingabestrom schließen
        scanner.close();

        return pfadAlsString;

    }

    protected static void erstellen(String verz) {

        // Dateiobjekt mit entsprechendem Namen erzeugen
        File ordner = new File(verz);

        //Abfrage: Wenn Pfad nicht existiert...
        if (!ordner.exists()) {

            //Wenn Ordner erstellt wurde...
            if (ordner.mkdir())
                System.out.println("Es wurde ein Ordner im Pfad '" + verz + "' erstellt.");
            else
                System.out.println("Der Ordner in Pfad '" + verz + "' konnte nicht erstellt werden.");
        } else System.out.println("Der Ordner in Pfad '" + verz + "' existiert bereits.");


    }

    //Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen
    public static void main(String[] args) throws IOException {

        erstellen(eingeben("Bitte geben Sie den vollständigen Pfad an, der erstellt werden soll:"));

    }
}
