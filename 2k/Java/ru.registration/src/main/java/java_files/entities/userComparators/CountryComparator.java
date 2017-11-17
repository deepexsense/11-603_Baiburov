package java_files.entities.userComparators;

import java_files.entities.User;

import java.util.Comparator;

public class CountryComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getCountry().compareTo(o2.getCountry());
    }
}
