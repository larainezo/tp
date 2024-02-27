package seedu.address.model.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class RoomNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomNumber(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidRoomNumber = "";
        assertThrows(IllegalArgumentException.class, () -> new RoomNumber(invalidRoomNumber));
    }

    @Test
    public void isValidRoomNumber() {
        // null room number
        assertThrows(NullPointerException.class, () -> RoomNumber.isValidRoomNumber(null));

        // invalid room number
        assertFalse(RoomNumber.isValidRoomNumber("")); // empty string
        assertFalse(RoomNumber.isValidRoomNumber(" ")); // spaces only

        // valid room number
        assertTrue(RoomNumber.isValidRoomNumber("01-01"));
    }

    @Test
    public void equals() {
        RoomNumber roomNumber = new RoomNumber("02-02");

        // same values -> returns true
        assertTrue(roomNumber.equals(new RoomNumber("02-02")));

        // same object -> returns true
        assertTrue(roomNumber.equals(roomNumber));

        // null -> returns false
        assertFalse(roomNumber.equals(null));

        // different types -> returns false
        assertFalse(roomNumber.equals(5.0f));

        // different values -> returns false
        assertFalse(roomNumber.equals(new RoomNumber("01-01")));
    }
}
