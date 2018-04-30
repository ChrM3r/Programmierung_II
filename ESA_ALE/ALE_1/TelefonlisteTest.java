package ESA_ALE.ALE_1;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TelefonListTest with three test cases ")
class TelefonlisteTest {

    private Telefonliste telefonlist = new Telefonliste();

    @AfterEach
    public void clearList() {
        telefonlist.clear();
    }

    @Nested
    @DisplayName("empty list")
    class TelefonlisteTestEmptyList {

        @Test
        public void testAddEntry() {
            telefonlist.addEntry("Max", "987654321");
            //can be handy to check visually when the test fails
            System.out.println(telefonlist);
            assertEquals(1, telefonlist.size());
        }

        @Test
        public void testModifyEntry() {
            assertFalse(telefonlist.modifyEntry("Frieda", "123456789", "Frieda Mustermann", "012345678"));

        }

        @Test
        public void testRemoveEntry() {
            telefonlist.removeEntry("Frieda", "123456789");
            assertEquals(0, telefonlist.size());
        }

        @Test
        public void testSearchByName() {
            assertNotEquals("Name: Frieda Nummer: 123456789", telefonlist.searchByName("Frieda"));
        }

        @Test
        public void testSearchNameByNumber() {
            assertNotEquals("Name: Frieda Nummer: 123456789", telefonlist.searchNameByNumber("123456789"));
        }
    }

    @Nested
    @DisplayName("list with one entry")
    class TelefonlisteTestOneEntry {

        @BeforeEach
        public void init() {
            telefonlist.addEntry("Frieda", "123456789");
        }

        @Test
        public void testAddEntry() {
            telefonlist.addEntry("Max", "987654321");
            //can be handy to check visually when the test fails
            System.out.println(telefonlist);
            assertEquals(2, telefonlist.size());
        }

        @Test
        public void testModifyEntry() {
            assertTrue(telefonlist.modifyEntry("Frieda", "123456789", "Frieda Mustermann", "012345678"));
        }

        @Test
        public void testRemoveEntry() {
            telefonlist.removeEntry("Frieda", "123456789");
            assertEquals(0, telefonlist.size());
        }

        @Test
        public void testSearchByName() {
            assertEquals("Name: Frieda Nummer: 123456789", telefonlist.searchByName("Frieda"));
        }

        @Test
        public void testSearchNameByNumber() {
            assertEquals("Name: Frieda Nummer: 123456789", telefonlist.searchNameByNumber("123456789"));
        }
    }

    @Nested
    @DisplayName("list with many entries")
    class TelefonlisteTestMultiEntries {

        @BeforeEach
        public void init() {
            telefonlist.addEntry("Liza", "123014585");
            telefonlist.addEntry("Frieda", "123456789");
            telefonlist.addEntry("John", "987654321");
        }

        @Test
        public void testAddEntry() {
            telefonlist.addEntry("Max", "987654321");
            assertEquals(4, telefonlist.size());
        }

        @Test
        public void testModifyEntry() {
            assertTrue(telefonlist.modifyEntry("Frieda", "123456789", "Frieda Mustermann", "012345678"));
        }

        @Test
        public void testRemoveEntry() {
            telefonlist.removeEntry("Frieda", "123456789");
            assertEquals(2, telefonlist.size());
        }

        @Test
        public void testSearchByName() {
            assertEquals("Name: Frieda Nummer: 123456789", telefonlist.searchByName("Frieda"));
        }

        @Test
        public void testSearchNameByNumber() {
            assertEquals("Name: Frieda Nummer: 123456789", telefonlist.searchNameByNumber("123456789"));
        }
    }
}

