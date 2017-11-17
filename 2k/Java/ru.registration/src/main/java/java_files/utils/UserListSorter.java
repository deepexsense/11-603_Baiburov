package java_files.utils;

import java_files.entities.userComparators.CountryComparator;
import java_files.entities.userComparators.GenderComparator;
import java_files.entities.User;
import java_files.entities.userComparators.EmailComparator;
import java_files.entities.userComparators.NameComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserListSorter {
    public static List<User> sortByName(List<User> users) {
        Comparator<User> comparator = new NameComparator();
        return sort(users, comparator);
    }

    public static List<User> sortByEmail(List<User> users) {
        Comparator<User> comparator = new EmailComparator();
        return sort(users, comparator);
    }

    public static List<User> sortByCountry(List<User> users) {
        Comparator<User> comparator = new CountryComparator();
        return sort(users, comparator);
    }

    public static List<User> sortByGender(List<User> users) {
        Comparator<User> comparator = new GenderComparator();
        return sort(users, comparator);
    }

    private static List<User> sort(List<User> users, Comparator<User> comparator) {
        List<User> sortedList = new ArrayList<>();
        sortedList.addAll(users);
        sortedList.sort(comparator);
        return sortedList;
    }
}
