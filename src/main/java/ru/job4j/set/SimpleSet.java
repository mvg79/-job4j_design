package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean rst = false;
        if (!contains(value)) {
            set.add(value);
            rst = true;
        }
        return rst;
    }

    @Override
    public boolean contains(T value) {
        boolean rst = false;
        for (T st: set) {
            if (Objects.equals(st, value)) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}