package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Mihail", 1, new GregorianCalendar(1979, 5, 25));
        User user2 = new User("Mihail", 1, new GregorianCalendar(1979, 5, 25));
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        System.out.println(map);
    }
}
