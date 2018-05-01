package ESA_ALE.ALE_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


/**
 * @author Chris Merscher
 * @version 1.0, 01.05.2018
 */


@DisplayName("MeineArrayListTest mit drei unterschiedlichen Testszenarieen")
class MeineArrayListTest {

    private MeineArrayList meineAL = new MeineArrayList(0, 0);

    @Nested
    @DisplayName("Leeres Array")
    private class MeineArrayListTestLeeresArray {

        @AfterEach
        private void clearList() {
            meineAL.clear();
        }

        @Test
        private void testAdd() {

            meineAL.add(1);
            meineAL.add(2);
            meineAL.add(3);
            assertEquals(3, meineAL.size());
        }

        @Test
        private void testRemove() {

            assertFalse(meineAL.remove(1));
            assertEquals(0, meineAL.size());
        }

        @Test
        private void testClear() {
            meineAL.clear();
            assertEquals(0, meineAL.size());
        }

        @Test
        private void TestToString() {

            assertEquals("", meineAL.toString());
        }

    }

    @Nested
    @DisplayName("Ein Eintrag")
    class MeineArrayListTestEinEintrag {

        @BeforeEach

        private void listeFüllen() {
            meineAL.add("Hallo");
        }

        @Test
        private void testAdd() {
            meineAL.add(1);
            assertEquals(2, meineAL.size());
        }

        @Test
        private void testRemove() {

            assertTrue(meineAL.remove(0));
            assertEquals(0, meineAL.size());
        }

        @Test
        private void testClear() {
            meineAL.clear();
            assertEquals(0, meineAL.size());
        }

        @Test
        private void TestToString() {

            assertEquals("Hallo", meineAL.toString());
        }

    }

    @Nested
    @DisplayName("Mehrere Einträge")
    class MeineArrayListTestMehrereEintraege {

        @BeforeEach
        private void listeFuellen() {
            meineAL.add("Hallo");
            meineAL.add(2);
            meineAL.add('z');
            meineAL.add(1.90802);
        }

        @Test
        private void testAdd() {
            meineAL.add("fünfter Eintrag");
            assertEquals(5, meineAL.size());
        }

        @Test
        private void testRemove() {

            assertTrue(meineAL.remove(3));
            assertEquals(3, meineAL.size());
        }

        @Test
        private void testClear() {
            meineAL.clear();
            assertEquals(0, meineAL.size());
        }

        @Test
        private void TestToString() {

            assertEquals("Hallo, 2, z, 1.90802", meineAL.toString());
        }
    }
}