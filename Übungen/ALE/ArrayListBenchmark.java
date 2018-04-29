package Übungen.ALE;

import java.util.ArrayList;

/**
 * Demoprogramm Vergleich Array - ArrayList.
 *
 * Anpassungen GJV: System.nanotime() verwenden fuer die Zeitmessung,
 * System.gc() aufrufen am Anfang (und Ende) eines Testfalles damit der Garbage
 * weg ist, zwei getrennte Methoden definiert damit die internen Datenstrukturen
 * anschliessend geloescht werden, Erstellen der Datenstruktur innerhalb der
 * Zeitmessung, Wiederholung der Tests, damit die JVM "aufgewaermt" wird
 *
 * @author gjv
 * @version 3.1, 18 Apr 2011
 *
 * @author skalt
 * @version 3.0, 09/2009
 */
public class ArrayListBenchmark {

    /** Elementanzahl die in der ArrayList bzw. im Array vorhanden sein soll */
    private static final int SIZE = 9999999;

    /** Anzahl der Testlaeufe */
    private static final int TEST_CNT = 1;

    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     */
    public static void main(String args[]) {
        for (int i = 0; i < TEST_CNT; i++) {
            testArray();
            testArrayList();
        }
    }


    /**
     * Prueft die Laufzeit fuer ein Array.
     */
    private static void testArray() {
        /** Startzeit der Messung */
        long start;

        System.gc(); // Garbage Collector explizit aufraeumen lassen

        /* Array fuellen */
        start = System.nanoTime();

        Integer a[] = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[i] = new Integer(i);
        }

        System.out.println("Zuweisen der Arrayelemente dauerte "
                + (System.nanoTime() - start) + " ns");

        /* auf Array-Elemente zugreifen */
        start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            a[i] = new Integer(a[i].intValue() + 1);
            // a[i] = a[i] + 1; // mit (un)boxing!
        }

        System.out.println("Zugriff auf Arrayelemente dauerte "
                + (System.nanoTime() - start) + " ns");
    }

    /**
     * Prueft die Laufzeit fuer ein ArrayList.
     */
    private static void testArrayList() {
        /** Startzeit der Messung */
        long start;

        System.gc(); // Garbage Collector explizit aufraeumen lassen

        /* Array fuellen */
        start = System.nanoTime();
        ArrayList<Integer> aList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            aList.add(new Integer(i));
        }

        System.out.println("Zuweisen der ArrayList-Elemente dauerte "
                + (System.nanoTime() - start) + " ns");

        /* auf Array-Elemente zugreifen */
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            /*
             * aktuellen Wert des Elements um 1 inkrementieren und dem selben
             * Element in der ArrayList neu zuweisen
             */
            aList.set(i, aList.get(i).intValue() + 1);
            // aList.set(i, (aList.get(i)) + 1); // mit (un)boxing
        }

        System.out.println("Zugriff auf ArrayList-Elemente dauerte "
                + (System.nanoTime() - start) + " ns");
    }

}
