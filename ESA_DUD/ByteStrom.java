package ESA_DUD;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Klasse zum Schreiben von Daten aus einem Byte-Datenstrom in eine Datei.
 *
 * @author skalt
 * @version 2.0, 07/2009
 */
public class ByteStrom {

    /**
     * Methode zum Testen eines Ausgabestroms.
     *
     * @param dateiName
     *            Name der Datei in die Daten geschrieben werden
     * @param bA
     *            zu schreibendes byte-Array
     * @throws IOException
     */
    public static void testeAusgabeStrom(String dateiName, byte[] bA)
            throws IOException {

        // Ausgabestroeme erzeugen
        FileOutputStream foStream = new FileOutputStream(dateiName);
        DataOutputStream doStream = new DataOutputStream(foStream);

        // Schleife ueber byte-Array
        for (int i = 0; i < bA.length; i++) {
            doStream.write(bA[i]); // in Ausgabestrom schreiben
            System.out.print(bA[i] + ", ");
        }

        // Ausgabestrom schliessen
        doStream.close();
        // Dateigroesse auf der Konsole ausgeben
        System.out.println("\nDateigroesse: " + doStream.size() + " Bytes");
    }


    /**
     * Methode zum Testen eines Eingabestroms.
     *
     * @param dateiName
     *            Name der Datei aus der Daten gelesen werden
     * @throws IOException
     */
    public static void testeEingabeStrom(String dateiName) throws IOException {

        // Eingabestrom oeffnen
        FileInputStream fiStream = new FileInputStream(dateiName);
        DataInputStream diStream = new DataInputStream(fiStream);

        // Gesamtgroesse des Datenstroms ermitteln
        int gesamt = diStream.available();
        System.out.println("Der Datenstrom enthaelt: " + gesamt + " Bytes.");

        // Array fuer die Gesamtgroesse des Datenstroms erzeugen
        byte[] b = new byte[gesamt];

        // die Methode read(b, 3, 2) liest 2 Bytes aus einem Datenstrom in das
        // Array byte[] b ein und speichert diese an den Indizes b[3] und b[4].
        int ausgabe = diStream.read(b, 3, 2);

        // Inhalt des Array byte[] b ausgeben
        System.out.println("\nDas Array byte[] b enthaelt jetzt die folgenden "
                + "Elemente:");
        // Schleife ueber byte-Array
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", ");
        }
        System.out.println("\n" + ausgabe + " Bytes wurden eingelesen.\n");

        // Gibt die Anzahl der noch zum Lesen verfuegbaren Bytes zurueck.
        int restGesamt = diStream.available();
        System.out.println("Der Datenstrom enthaelt noch: " + restGesamt
                + " Bytes.");

        // Die Methode read(b) liest die restliche Daten aus dem Datenstrom in
        // das Array byte[] b ein
        if (restGesamt == diStream.read(b)) {
            System.out.println("Die restlichen Bytes wurden eingelesen.");
        } else {
            System.out.println("Ich habe weniger erhalten als erwartet.");
        }

        // Inhalt des Array byte[] b ausgeben
        System.out.println("\nDas Array byte[] b enthaelt jetzt die folgenden "
                + "Elemente:");
        // Schleife ueber byte-Array
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", ");
        }

        // Eingabestrom schliessen
        diStream.close();
    }

    /**
     * Methode zum Testen eines Eingabestroms mit ueberspringen von Bytes.
     *
     * @param dateiName
     *            Name der Datei aus der Daten gelesen werden
     * @throws IOException
     */
    public static void testeEingabeStrom2(String dateiName) throws IOException {
        // Eingabestrom oeffnen
        FileInputStream fiStream = new FileInputStream(dateiName);
        DataInputStream diStream = new DataInputStream(fiStream);

        // Die Methode skipBytes() ueberspringt n Bytes im Eingabestrom und
        // liefert die Anzahl der uebersprungenen Bytes zurueck. Sie loest keine
        // EOFException aus.
        if (diStream.skipBytes(3) != 3) {
            System.out.println("Ich habe weniger uebersprungen als erwartet.");
        }

        // Schleife solange noch Daten zum Einlesen vorhanden sind
        while (diStream.available() > 0) {
            // Die Methode readByte() liest ein Byte von einem Datenstrom und
            // gibt den eingelesenen Wert des Bytes zurueck.
            byte einByte = diStream.readByte();
            System.out.print(einByte + " ");
        }

        // Eingabestrom schliessen
        diStream.close();
    }

    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Variablen deklarieren
        byte[] bA = { 10, 20, 30, 40, 50, 60 };
        String dateiName = "ByteAusgabeStromDatei";

        testeAusgabeStrom(dateiName, bA);
        testeEingabeStrom(dateiName);
        testeEingabeStrom2(dateiName);
    }

}
