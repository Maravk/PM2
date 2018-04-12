package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.*;

class complexImmutableTest {

    @org.junit.jupiter.api.Test
    void add() {
        complexImmutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexImmutable(i, i);
            x2 = new complexImmutable(i, i);
            assertEquals(i*2, x1.add(x2).getReal());
            assertEquals(i*2, x1.add(x2).getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void sub() {
        complexImmutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexImmutable(i, i);
            x2 = new complexImmutable(i, i);
            assertEquals(i-i, x1.sub(x2).getReal());
            assertEquals(i-i, x1.sub(x2).getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        complexImmutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexImmutable(i, i);
            x2 = new complexImmutable(i, i);
            assertEquals((i*i) - (i*i), x1.multiply(x2).getReal());
            assertEquals((i*i) + (i*i), x1.multiply(x2).getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void divide() {
        complexImmutable x1, x2;
        for(int i = 1; i < 100; i++){
            x1 = new complexImmutable(i, i);
            x2 = new complexImmutable(i, i);
            assertEquals(((i*i) + (i*i)) / ((i*i) + (i*i)), x1.divide(x2).getReal());
            assertEquals(((i*i) - (i*i)) / ((i*i) + (i*i)), x1.divide(x2).getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void polar() {
        complexImmutable x1;
        for(int i = 0; i < 360; i++){
            x1 = complexImmutable.polar(1, i);
            assertEquals(1 * cos(i), x1.getReal());
            assertEquals(1 * sin(i), x1.getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void immutable(){
        complexImmutable x1 = new complexImmutable(1, 2);
        x1.conjugate();
        assertEquals(new complexImmutable(1, 2), x1);
    }
}