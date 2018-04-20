package ESA_DUD;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris Merscher
 * @version 1.0, 19.04.2018
 */

public class TestKlasse {

    public static void main(String args[]) throws IOException {


        //Variablen für Verzeichniserstellung

        String parentPfad = "/";
        String os;
        String benutzer;
        boolean pruefer = false;



        //Neues Scanner-Objekt für sämtliche Abfragen im Verlauf des Programms

        Scanner scanner = new Scanner(System.in);


        //Verzeichnis erstellen

        while (!pruefer) {

            //Abfrage des Betriebssystems, da unter UNIX nicht im root (/) ohne admin-Rechte geschrieben werden kann.
            System.out.print("Arbeiten Sie auf einem UNIX- oder einem Windows-basiertem Betriebssystem? (U oder W eingeben): ");
            os = scanner.next();


            //UNIX...
            if (os.equals("U") || os.equals("u")) {

                System.out.print("Bitte geben Sie den Benutzernamen des aktuellen Benutzers ein: ");
                benutzer = scanner.next();
                parentPfad = "/Users/" + benutzer + "/";

                File temp = new File(parentPfad);

                if (temp.exists()) {
                    System.out.println("Die Verzeichnisstruktur wird in Ihrem Benutzerordner '" + benutzer + "' erstellt!");
                    pruefer = true;
                } else System.out.println("Fehler! Mglw. falscher Benutzername?"); //Prüfen, ob Benutzerordner existiert

                //WINDOWS...
            } else if (os.equals("W") || os.equals("w")) {
                parentPfad = "C:/";

                File temp = new File(parentPfad);

                if (temp.mkdir()) {
                    System.out.println("Die Verzeichnisstruktur wird auf Ihrem Systemlaufwerk (i.d.R. 'C:' erstellt!");
                    pruefer = true;
                } else System.out.println("Fehler! Mglw. kein Windows-System?"); //Prüfen, ob C:/ existiert
            }
        }

        pruefer = false; //pruefer für später wieder auf false setzten


        File pfad = new File(parentPfad + "Dateimanagement//");

        //Auufruf der Klasse VerzErst
        VerzErst.erstellen(pfad.toString());
        VerzErst.erstellen(pfad + "/Dokumente/");
        VerzErst.erstellen(pfad + "/Graphik/");
        VerzErst.erstellen(pfad + "/Java/");

        String entscheidung;

        //Soll noch ein Ordner angelegt werden?
        do {
            System.out.print("Wollen Sie einen weiteren Ordner auf Ihrem Rechner anlegen? (J oder N): ");
            entscheidung = scanner.next();


            if (entscheidung.equals("J") || entscheidung.equals("j")) {
                VerzErst.erstellen(VerzErst.eingeben("Bitte vollständigen Pfad des neuen Ordners inkl. Ordnernamen angeben: "));
                System.out.println("Verzeichniserstellung abgeschlossen!");
                pruefer = true;

            } else if (entscheidung.equals("N") || entscheidung.equals("n")) {
                System.out.println("Verzeichniserstellung abgeschlossen!");
                pruefer = true;

            } else
                System.out.println("Fehler! Falscher Buchstabe?");
        } while (!pruefer);


        pruefer = false; //pruefer für später wieder auf false setzten

        //Kopierteil...

        System.out.println("Kommen wir nun zum Kopieren.");

        System.out.print("Bitte geben Sie den Pfad an, in dem die Graphik, das Java- und das HTML-Dokument aktuell gespeichert sind: ");
        String kopierPfad;
        kopierPfad = scanner.next();

        System.out.print("Bitte den vollständigen Namen des HTML-Dokuments (inkl. Dateiendung) ein: ");
        String html;
        html = scanner.next();

        System.out.print("Bitte den vollständigen Namen der Graphik (inkl. Dateiendung) ein: ");
        String graphik;
        graphik = scanner.next();

        System.out.print("Bitte den vollständigen Namen des Java-Dokuments (inkl. Dateiendung) ein: ");
        String java;
        java = scanner.next();

        try {
            DatKop.kopieren(kopierPfad + html, pfad + "/Dokumente/" + html);
            DatKop.kopieren(kopierPfad + graphik, pfad + "/Graphik/" + graphik);
            DatKop.kopieren(kopierPfad + html, pfad + "/Java/" + java);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Datei-Info-Teil

        File htmlFile = new File(pfad + "/Dokumente/" + html);
        File graphikFile = new File(pfad + "/Graphik/" + graphik);
        File javaFile = new File(pfad + "/Java/" + java);
        String janein;

        System.out.println("Nun sind wir bei den Dateiinfos angekommen");

        do {

            System.out.println(" Wählen Sie, welche Information für die Dateien angezeigt werden soll:\n " +
                    "Dateigröße 1;\n" +
                    " Verzeichnis oder Datei 2;\n" +
                    " Letzter Tag der Änderung 3;\n" +
                    " Schreib- und Lesezugriff erlaubt ja/nein 4 ");
            entscheidung = scanner.next();

            switch (entscheidung) {
                case "1": {
                    DatInfo.groesseAusgeben(htmlFile);
                    DatInfo.groesseAusgeben(graphikFile);
                    DatInfo.groesseAusgeben(javaFile);

                    System.out.println("Weitere Infos? ja/nein: ");
                    janein = scanner.next();

                    if (janein.equals("ja"))
                        break;
                    else {
                        pruefer = true;
                        break;
                    }
                }

                case "2": {
                    DatInfo.dateiOderVerzeichnis(htmlFile);
                    DatInfo.dateiOderVerzeichnis(graphikFile);
                    DatInfo.dateiOderVerzeichnis(javaFile);

                    System.out.println("Weitere Infos? ja/nein: ");
                    janein = scanner.next();

                    if (janein.equals("ja"))
                        break;
                    else {
                        pruefer = true;
                        break;
                    }
                }

                case "3": {
                    DatInfo.aenderungAusgeben(htmlFile);
                    DatInfo.aenderungAusgeben(graphikFile);
                    DatInfo.aenderungAusgeben(javaFile);

                    System.out.println("Weitere Infos? ja/nein: ");
                    janein = scanner.next();

                    if (janein.equals("ja"))
                        break;
                    else {
                        pruefer = true;
                        break;
                    }
                }

                case "4": {
                    DatInfo.lesenSchreiben(htmlFile);
                    DatInfo.lesenSchreiben(graphikFile);
                    DatInfo.lesenSchreiben(javaFile);

                    System.out.println("Weitere Infos? ja/nein: ");
                    janein = scanner.next();

                    if (janein.equals("ja"))
                        break;
                    else {
                        pruefer = true;
                        break;
                    }
                }

            }
        } while (!pruefer);

        //Eingabestrom schließen
        scanner.close();
    }
}
