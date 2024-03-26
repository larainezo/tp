package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's free time in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidFreeTime(String)}
 */
public class FreeTime {


    public static final String MESSAGE_CONSTRAINTS = "Free Time Tag should be Mon-Sun:HHmm-HHmm (24hr format)";

    public static final String VALIDATION_REGEX =
            "^(Mon|Tue|Wed|Thu|Fri|Sat|Sun):(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])-(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])$";
    public final String value;
    public final String dayValue;
    public final String timeValue;

    /**
     * Constructs a {@code FreeTime}.
     *
     * @param freeTime A valid freeTime.
     */
    public FreeTime(String freeTime) {
        requireNonNull(freeTime);
        requireNonNull(freeTime);
        checkArgument(isValidFreeTime(freeTime), MESSAGE_CONSTRAINTS);
        value = freeTime;
        dayValue = freeTime.substring(0, 3);
        timeValue = freeTime.substring(4);
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidFreeTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getDayValue() {
        return dayValue;
    }

    public String getTimeValue() {
        return timeValue;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FreeTime)) {
            return false;
        }

        FreeTime otherFreeTime = (FreeTime) other;
        return value.equals(otherFreeTime.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
