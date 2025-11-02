package seedu.address.model.position;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s position name matches the given position name (case-insensitive).
 */
public class FilterByPositionPredicate implements Predicate<Person> {
    public static final FilterByPositionPredicate ALWAYS_TRUE = new FilterByPositionPredicate("");
    private final String positionName;

    /**
     * Constructs a FilterByPositionPredicate.
     */
    public FilterByPositionPredicate(String positionName) {
        requireNonNull(positionName);
        this.positionName = positionName;
    }

    @Override
    public boolean test(Person person) {
        requireNonNull(person);
        if (positionName.isEmpty()) {
            return true;
        }
        return person.getPosition().getName().equalsIgnoreCase(positionName);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterByPositionPredicate)) {
            return false;
        }

        FilterByPositionPredicate otherFilterByPositionPredicate = (FilterByPositionPredicate) other;
        return positionName.equals(otherFilterByPositionPredicate.positionName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("position name", positionName).toString();
    }

    public String getPositionName() {
        return positionName;
    }
}
