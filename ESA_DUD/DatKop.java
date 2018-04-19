package ESA_DUD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Chris Merscher
 * @version 1.0, 18.04.2018
 */


public class DatKop {


    //Kopiert eine Datei von quelle nach ziel und gibt eine Statusmeldung auf der Standardausgabe über den Erfolg aus.
    public static void main (String args[]) throws IOException{
        kopieren("/Users/Chris/test/test.txt","/Users/Chris/hallo/test.txt");
    }

    protected static void kopieren(String quelle, String ziel) throws IOException{

        // Ein- und Ausgabeströme öffnen
        FileInputStream fi = new FileInputStream(quelle);
        FileOutputStream fo = new FileOutputStream(ziel);

        long dateiLaenge = (new File(quelle)).length();

        // Byte-Array, in das Daten eingelesen werden sollen, erzeugen
        byte[] zielArray = new byte[(int) dateiLaenge];
        int len;

        // Daten aus Quelldatei einlesen und in Zieldatei schreiben
        while ((len = fi.read(zielArray)) > 0) {
            fo.write(zielArray, 0, len);
        }

        //Ein- und Ausgabeströme schliessen
        fo.close();
        fi.close();

        // Ausgabe
        System.out.println("Datei '" + quelle + "' wurde nach '" + ziel + "' kopiert.");
    }
}
