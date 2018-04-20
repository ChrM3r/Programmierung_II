package ESA_DUD;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Chris Merscher
 * @version 1.0, 16.04.2018
 */

public class HtmlConv {

    public static void main(String[] args) throws IOException {
        String htmlOriginal = "datei1702_vor.html";
        String htmlGean = "datei1702_nach.html";
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

        //Zeilenweise...
        for (String zeileInListe : dateiInListe) {

            if (zeileInListe.contains("ü")) {                                   //auf ü prüfen...
                zeileInListe = zeileInListe.replace("ü", "&uuml");     //und ggf. ersetzen.
            }

            if (zeileInListe.contains("Ü")) {                                    //auf Ü prüfen...
                zeileInListe = zeileInListe.replace("Ü", "&Uuml");     //und ggf. ersetzen.

            }
            if (zeileInListe.contains("ö")) {                                    //auf ö prüfen...
                zeileInListe = zeileInListe.replace("ö", "&ouml");     //und ggf. ersetzen.

            }
            if (zeileInListe.contains("Ö")) {                                    //auf Ö prüfen...
                zeileInListe = zeileInListe.replace("Ö", "&Ouml");     //und ggf. ersetzen.

            }
            if (zeileInListe.contains("ä")) {                                    //auf ä prüfen...
                zeileInListe = zeileInListe.replace("ä", "&auml");     //und ggf. ersetzen.

            }
            if (zeileInListe.contains("Ä")) {                                    //auf Ä prüfen...
                zeileInListe = zeileInListe.replace("Ä", "&Auml");     //und ggf. ersetzen.

            }
            if (zeileInListe.contains("ß")) {                                    //auf ß prüfen...
                zeileInListe = zeileInListe.replace("ß", "&szlig");    //und ggf. ersetzen.
            }
            neueListe.add(zeileInListe);
        }

        // neue Datei erzeugen - Ausgabestroeme öffnen
        FileOutputStream foStream = new FileOutputStream(htmlGeand);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(foStream, "ISO8859_1"));

        // Zeilen in neue Datei speichern
        for (String zeileInListe : neueListe) {
            bw.write(zeileInListe);
        }

        // Inhalt aus internem Puffer in den FileOutputStream schreiben
        bw.flush();
        //Ausgabestrom schließen
        bw.close();

        // Benutzerausgabe
        System.out.println("Geändertes HTML-Dokument wurde in die Datei '" + htmlGeand + "' gespeichert.");

    }
}
