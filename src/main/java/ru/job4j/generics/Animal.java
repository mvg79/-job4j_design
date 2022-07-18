package ru.job4j.generics;

public class Animal {
    private String clas;
    private int age;

    public Animal(String clas, int age) {
        this.clas = clas;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "clas='" + clas + '\''
                + ", age=" + age
                + '}';
    }
}
