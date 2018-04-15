package ESA_DUD;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Bytes werden aus Bild-Datei gelesen; einzelne Bytes werden veraendert und
 * wieder in Datei gespeichert.
 *
 * @author skalt
 * @version 2.0 07/2009
 */
public class BinaerDatenManipulieren {

    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Dateiname des Originalbildes
        String bildDateiOriginal = "AbbWurfparabel.jpg";
        // Dateigroesse - Angabe wichtig fuer Laenge des Byte-Arrays
        int dateiGroesse = (int) new File(bildDateiOriginal).length(); //die Dateigroesse ist klein genug um in ein int zu passen
        // Dateiname des Bildes mit den manipulierten Bytes
        String bildDateiGeand = "AbbWurfparabel_new.jpg";
        // Methode zum Manipulieren von Bytes im Originalbild aufrufen
        manipuliereBytesInBild(bildDateiOriginal, bildDateiGeand, dateiGroesse);
    }

    /**
     * Methode zum Manipuliere einzelner Bytes in einem Bild. Das manipulierte
     * Bild wird unter dem uebergebenen neuen Dateinamen abgespeichert.
     *
     * @param bildDateiOriginal
     *            Dateiname des Originalbildes
     * @param bildDateiGeand
     *            Dateiname des Bildes mit den manipulierten Bytes
     * @param int dateiGroesse Dateigroesse des Originalbildes in Byte
     * @throws IOException
     */
    public static void manipuliereBytesInBild(String bildDateiOriginal,
                                              String bildDateiGeand, int dateiGroesse) throws IOException {
        // Datei einlesen - Eingabestroeme oeffnen
        FileInputStream fiStream = new FileInputStream(bildDateiOriginal);
        DataInputStream diStream = new DataInputStream(fiStream);

        // Byte-Array entsprechend der Dateigroesse des Originalbilds erzeugen
        byte[] byteA = new byte[dateiGroesse];
        // Bytes mittels read() in das Byte-Array einlesen
        diStream.read(byteA);
        // Eingabestrom schliessen
        diStream.close();

        // Bytes an einzelnen Positionen aendern
        byteA[60] = -126;
        byteA[1060] = 126;
        byteA[1400] = -112;

        byteA[40000] = 1;
        byteA[40001] = 1;
        byteA[40002] = 1;
        byteA[40003] = 1;
        byteA[40004] = 1;
        byteA[40005] = 1;
        byteA[40006] = 1;
        byteA[40007] = 1;
        byteA[40008] = 1;
        byteA[40009] = 1;
        byteA[40010] = 1;
        byteA[40011] = 1;
        byteA[40012] = 1;

        // neue Datei erzeugen - Ausgabestroeme oeffnen
        FileOutputStream foStream = new FileOutputStream(bildDateiGeand);
        DataOutputStream doStream = new DataOutputStream(foStream);

        // Bytes in neue Datei speichern
        doStream.write(byteA);
        // Bytes aus internem Puffer in den FileOutputStream schreiben
        doStream.flush();
        // Ausgabestrom schliessen
        doStream.close();

        // Benutzerausgabe
        System.out.println("Ge‰ndertes Bild wurde in die Datei '"
                + bildDateiGeand + "' gespeichert.");
    }
}