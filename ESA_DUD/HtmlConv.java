package ESA_DUD;

import java.io.*;
import java.util.ArrayList;


public class HtmlConv {

    public static void main(String[] args) throws IOException {
        String htmlOriginal = "datei1702_vor.html";
        String htmlGean = "datei1702_nach.html";
        umlauteFiltern(htmlOriginal, htmlGean);
    }

    private static void umlauteFiltern(String htmlOriginal, String htmlGeand) throws IOException {
        // Datei einlesen - Eingabestroeme oeffnen
        FileInputStream fiStream = new FileInputStream(htmlOriginal);
        BufferedReader br = new BufferedReader(new InputStreamReader(fiStream, "ISO8859_1"));

        // Array-List bis zum Dokumentende zeilenweise befüllen

        ArrayList<String> dateiInListe = new ArrayList<>();
        String zeile;
        while ((zeile = br.readLine()) != null) dateiInListe.add(zeile);

        // Eingabestrom schliessen
        br.close();

        //Arry-List für den geänderten Inhalt
        ArrayList<String> neueListe = new ArrayList<>();

        //String zum zwischenspeichern der geänderten Zeile
        String temp;

        //Zeilenweise...
        for (String zeileInListe :  dateiInListe) {
            temp = zeileInListe + "\n"; //...den Inhalt in die temp-Variable speichern...

            if (temp.contains("ü")) {                                   //auf ü prüfen...
                temp =temp.replace("ü", "&uuml");     //und ggf. ersetzen.
            }
            if (temp.contains("Ü")) {                                    //auf Ü prüfen...
                temp = temp.replace("Ü", "&Uuml");     //und ggf. ersetzen.

            }
            if (temp.contains("ö")) {                                    //auf ö prüfen...
                temp = temp.replace("ö", "&ouml");     //und ggf. ersetzen.

            }
            if (temp.contains("Ö")) {                                    //auf Ö prüfen...
                temp = temp.replace("Ö", "&Ouml");     //und ggf. ersetzen.

            }
            if (temp.contains("ä")) {                                    //auf ä prüfen...
                temp = temp.replace("ä", "&auml");     //und ggf. ersetzen.

            }
            if (temp.contains("Ä")) {                                    //auf Ä prüfen...
                temp = temp.replace("Ä", "&Auml");     //und ggf. ersetzen.

            }
            if (temp.contains("ß")) {                                    //auf ß prüfen...
                temp = temp.replace("ß", "&szlig");    //und ggf. ersetzen.
            }
            neueListe.add(temp);
        }

        // neue Datei erzeugen - Ausgabestroeme oeffnen
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
