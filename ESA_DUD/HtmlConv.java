package ESA_DUD;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Chris Merscher
 * @version 1.1, 29.04.2018
 */

public class HtmlConv {


    public static void main(String[] args) throws IOException {
        String htmlOriginal = "/Users/Chris/Downloads/test.html";
        String htmlGean = "/Users/Chris/Downloads/datei1702_nach.html";
        umlauteFiltern(htmlOriginal, htmlGean);
    }

    private static void umlauteFiltern(String htmlOriginal, String htmlGeand) throws IOException {
        // Datei einlesen - Eingabestroeme oeffnen
        FileInputStream fiStream = new FileInputStream(htmlOriginal);
        BufferedReader br = new BufferedReader(new InputStreamReader(fiStream, "ISO8859_1")); //Zeichencodierung, damit die Umlaute vernünftig eingelesen werden

        // Array-List bis zum Dokumentende zeilenweise befüllen

        ArrayList<String> dateiInListe = new ArrayList<>();
        String zeile;
        while ((zeile = br.readLine()) != null) dateiInListe.add(zeile + "\n");

        // Eingabestrom schliessen
        br.close();

        //Arry-List für den geänderten Inhalt
        ArrayList<String> neueListe = new ArrayList<>();

        //Stream und Lambda zum ersetzen
        dateiInListe
                .forEach(s -> neueListe.add(s.replace("ü","&uuml;")
                .replace("Ü","&Uuml;")
                .replace("ö","&ouml;")
                .replace("Ö","&Ouml;")
                .replace("ä","&auml;")
                .replace("Ä","&Auml;")
                .replace("ß","&szlig;")));


        // neue Datei erzeugen - Ausgabestroeme öffnen
        FileOutputStream foStream = new FileOutputStream(htmlGeand);
        OutputStreamWriter ow = new OutputStreamWriter(foStream, "ISO8859_1");

        // Zeilen in neue Datei speichern
        for (String zeileInListe : neueListe) {
            ow.write(zeileInListe);
        }

        // Inhalt aus internem Puffer in den FileOutputStream schreiben
        ow.flush();
        //Ausgabestrom schließen
        ow.close();

        // Benutzerausgabe
        System.out.println("Geändertes HTML-Dokument wurde in die Datei '" + htmlGeand + "' gespeichert.");

    }
}
