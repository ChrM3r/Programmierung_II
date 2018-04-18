package ESA_DUD;

import java.io.IOException;
import java.io.File;
import java.util.Date;

public class DatInfo {


    //Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen
    public static void main(String[] args) throws IOException {

        File test = new File("/Users/Chris/hallo/test.txt");

        aenderungAusgeben(test);
        dateiOderVerzeichnis(test);
        existiert(test);
        groesseAusgeben(test);
        lesenSchreiben(test);
        pfadAusgeben(test);


    }

    //Gibt die letzte Änderung der übergebenen Datei auf der Standardausgabe aus.
    private static void aenderungAusgeben(File eingabe) {

        Date datum = new Date(eingabe.lastModified());

        System.out.println("Letzte Änderung: " + datum);
    }


    //Gibt auf der Standardausgabe aus, ob das übergebene File eine Datei oder ein Verzeichnis ist.
    private static void dateiOderVerzeichnis(File eingabe) {

        if (eingabe.isDirectory())
            System.out.println("Es ist ein Verzeichnis!");
        else
            System.out.println("Es ist eine Datei!");
    }


    //Prüft, ob die übergebene Datei existiert und gibt das Ergebnis als Boolean zurück
    private static boolean existiert(File eingabe) {

        return eingabe.exists();
    }


    //Gibt die Größe der übergebenen Datei auf der Standardausgabe aus.
    private static void groesseAusgeben(File eingabe) {

        System.out.println("Dateigröße: " + eingabe.length() + " Byte");
    }


    //Gibt die Zugriffsrechte der übergebenen Datei auf der Standardausgabe aus.
    private static void lesenSchreiben(File eingabe) {

        System.out.println("Zugriffsrechte für aktuellen Benutzer: \n" +
                "Ausführbar: " + eingabe.canExecute() + "\n" +
                "Lesbar: " + eingabe.canRead() + "\n" +
                "Änderbar: " + eingabe.canWrite());
    }


    //Gibt den Pfad der übergebenen Datei auf der Standardausgabe aus.
    private static void pfadAusgeben(File eingabe) {

        System.out.println("Verzeichnis der Datei:  " + eingabe.getParent() + "/"); // der '/' nur bei UNIX-Systemen :)
    }


}
