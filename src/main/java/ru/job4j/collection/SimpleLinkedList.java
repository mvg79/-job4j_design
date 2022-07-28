package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int modCount;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> node = new Node<E>(value, null);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E val = node.item;
                node = node.next;
                return val;
            }
        };
    }
}