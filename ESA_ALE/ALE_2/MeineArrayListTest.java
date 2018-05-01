package ESA_ALE.ALE_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeineArrayListTest {

    private MeineArrayList meineAL = new MeineArrayList(0, 0);

  //  @AfterEach
  //  public void clearList() {
  //      meineAL.clear();
  //  }


@Nested
    @DisplayName("Typ int")
    class MeineArrayListTestTypInt {

        @Test
        public void testAdd() {


            meineAL.add(1);
            meineAL.add(2);
            meineAL.add(3);
            assertEquals(3, meineAL.size());
        }

        @Test
        public void testRemove() {
            meineAL.add(1);
            meineAL.add(2);
            meineAL.add(3);

            assertTrue(meineAL.remove(1));
            assertEquals(2, meineAL.size());

        }

        @Test
        public void testClear() {
            meineAL.clear();
            assertEquals(0, meineAL.size());
        }

        @Test
        public void TestToString() {
            meineAL.add(1);
            meineAL.add(2);
            meineAL.add(3);

            assertEquals("[1, 2, 3]", meineAL.toString());
        }

    }

}