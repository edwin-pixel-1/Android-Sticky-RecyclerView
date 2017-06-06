package timothypaetz.com.recyclersectionheader;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by paetztm on 2/6/2017.
 */

public class Person implements Comparable<Person> {
    private final CharSequence firstName;
    private final CharSequence lastName;
    private final String birthdayDate;
    private static final String NAME_DISPLAY = "%s, %s";

    public Person(@NonNull CharSequence firstName, @NonNull CharSequence lastName, @NonNull Calendar birthdayCalendar) {
        this.firstName = firstName;
        this.lastName = lastName;

        final SimpleDateFormat format = new SimpleDateFormat("MMM-yyyy");
        this.birthdayDate = format.format(birthdayCalendar.getTime());
    }

    public CharSequence getLastName() {
        return lastName;
    }

    public CharSequence getFirstName() {
        return firstName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getFullName() {
        return String.format(Locale.getDefault(),
                             NAME_DISPLAY,
                             getLastName(),
                             getFirstName());
    }

    @Override
    public int compareTo(@NonNull Person person) {
        /*return getLastName().toString()
                            .compareTo(person.getLastName()
                                             .toString());*/
        return getBirthdayDate()
                            .compareTo(person.getBirthdayDate());
    }
}
