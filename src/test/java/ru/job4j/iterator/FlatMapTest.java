package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class FlatMapTest {
   @Test
    void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.next()).isEqualTo(1);
        assertThat(flat.next()).isEqualTo(2);
        assertThat(flat.next()).isEqualTo(3);
    }

    @Test
    void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.next()).isEqualTo(1);
        assertThat(flat.next()).isEqualTo(2);
        assertThat(flat.next()).isEqualTo(3);
    }

    @Test
    void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.hasNext()).isTrue();
        assertThat(flat.hasNext()).isTrue();
    }

    @Test
    void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.next()).isEqualTo(1);
        assertThat(flat.hasNext()).isFalse();
    }

    @Test
    void whenEmptyInteger() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThatThrownBy(flat::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenSeveralEmptyAndNotEmpty() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty,
                empty,
                empty,
                List.of(1).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.hasNext()).isTrue();
        assertThat(flat.next()).isEqualTo(1);
    }

    @Test
    void whenSeveralEmptyThenReturnFalse() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty,
                empty,
                empty
        ).iterator();
        FlatMap flat = new FlatMap(data);
        assertThat(flat.hasNext()).isFalse();
    }
}