package de.renehagemann.haw.pm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GenerateNumbersTest {
    @org.junit.jupiter.api.Test
    void testSorting(){
        ArrayList<complexImmutable> list1 = new ArrayList<>();
        ArrayList<complexImmutable> list2 = new ArrayList<>();
        complexImmutable[] array1 = new complexImmutable[5];
        complexImmutable[] array2 = new complexImmutable[5];

        list1.add(new complexImmutable(5, 6));
        list1.add(new complexImmutable(4, 6));
        list1.add(new complexImmutable(3, 6));
        list1.add(new complexImmutable(2, 6));
        list1.add(new complexImmutable(1, 6));

        array1[0] = new complexImmutable(5, 6);
        array1[1] = new complexImmutable(4, 6);
        array1[2] = new complexImmutable(3, 6);
        array1[3] = new complexImmutable(2, 6);
        array1[4] = new complexImmutable(1, 6);

        list2.add(new complexImmutable(1, 6));
        list2.add(new complexImmutable(2, 6));
        list2.add(new complexImmutable(3, 6));
        list2.add(new complexImmutable(4, 6));
        list2.add(new complexImmutable(5, 6));

        array2[0] = new complexImmutable(1, 6);
        array2[1] = new complexImmutable(2, 6);
        array2[2] = new complexImmutable(3, 6);
        array2[3] = new complexImmutable(4, 6);
        array2[4] = new complexImmutable(5, 6);

        list1.sort(Comparator.comparingDouble(A_complex::getValue));
        Arrays.sort(array1, Comparator.comparingDouble(A_complex::getValue));

        assertEquals(list2, list1);
        assertArrayEquals(array2, array1);
    }
}