package de.renehagemann.haw.pm2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void andAll() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list1.add(i);
            list2.add(i);
        }

        Predicate<Integer> bigger10 = (Integer i) -> (i > 10);
        Predicate<Integer> even = (Integer i) -> (i%2 == 0);
        Predicate<Integer> smaller50 = (Integer i) -> (i < 50);

        Predicate<Integer>[] predicates = new Predicate[3];
        predicates[0] = even;
        predicates[1] = bigger10;
        predicates[2] = smaller50;

        list1.removeIf(new Filter<Integer>().andAll(predicates));

        list2.removeIf(even.and(bigger10).and(smaller50));

        assertEquals(list2, list1);
    }

    @Test
    void orAny() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list1.add(i);
            list2.add(i);
        }

        Predicate<Integer> bigger10 = (Integer i) -> (i > 10);
        Predicate<Integer> even = (Integer i) -> (i%2 == 0);
        Predicate<Integer> smaller50 = (Integer i) -> (i < 50);

        Predicate<Integer>[] predicates = new Predicate[3];
        predicates[0] = even;
        predicates[1] = bigger10;
        predicates[2] = smaller50;

        list1.removeIf(new Filter<Integer>().orAny(predicates));

        list2.removeIf(even.or(bigger10).or(smaller50));

        assertEquals(list2, list1);
    }
}