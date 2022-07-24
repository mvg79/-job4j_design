package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void increase() {
        int length = container.length == 0 ? 1 : container.length * 2;
        container = Arrays.copyOf(container, length);
        modCount++;
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
           increase();
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T old = container[index];
        container[index] = newValue;
        return old;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T old = container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[container.length - 1] = null;
        modCount++;
        size--;
        return old;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }

        };
    }
}