package ru.job4j.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        Assertions.assertTrue(set.add(1));
        Assertions.assertTrue(set.contains(1));
        Assertions.assertFalse(set.add(1));
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        Assertions.assertTrue(set.add(null));
        Assertions.assertTrue(set.contains(null));
        Assertions.assertFalse(set.add(null));
    }

    @Test
    void whenAddDuplicate() {
        Set<Integer> set = new SimpleSet<>();
        Assertions.assertTrue(set.add(1));
        Assertions.assertTrue(set.add(2));
        Assertions.assertTrue(set.add(3));
        Assertions.assertTrue(set.add(4));
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
        Assertions.assertTrue(set.contains(4));
        Assertions.assertFalse(set.add(1));
        Assertions.assertFalse(set.add(2));
        Assertions.assertFalse(set.add(3));
        Assertions.assertFalse(set.add(4));
    }
}