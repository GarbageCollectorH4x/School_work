import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    Door dr;
    @BeforeEach
    void setUp() {
        dr = new Door();
    }

    @Test
    void isPermaLocked() {
        dr.setLock(true);
        assertFalse(dr.isPermaLocked());

        dr.setLock(false);
        assertTrue(dr.isPermaLocked());
    }

    @Test
    void canInteract() {
        assertTrue(dr.canInteract());

        dr.setLock(false);
        assertFalse(dr.canInteract());
    }

    @Test
    void isLocked() {
        assertTrue(dr.isLocked());

        dr.setLock(true);

        assertFalse(dr.isLocked());
    }
}