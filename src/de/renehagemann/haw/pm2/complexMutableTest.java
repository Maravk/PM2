package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.*;

class complexMutableTest {

    @org.junit.jupiter.api.Test
    void add() {
        complexMutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexMutable(i, i);
            x2 = new complexMutable(i, i);
            x1.add(x2);
            assertEquals(i+i, x1.getReal());
            assertEquals(i+i, x1.getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void sub() {
        complexMutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexMutable(i, i);
            x2 = new complexMutable(i, i);
            x1.sub(x2);
            assertEquals(i-i, x1.getReal());
            assertEquals(i-i, x1.getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        complexMutable x1, x2;
        for(int i = 0; i < 100; i++){
            x1 = new complexMutable(i, i);
            x2 = new complexMutable(i, i);
            x1.multiply(x2);
            assertEquals((i*i) - (i*i), x1.getReal());
            assertEquals((i*i) + (i*i), x1.getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void divide() {
        complexMutable x1, x2;
        for(int i = 1; i < 100; i++){
            x1 = new complexMutable(i, i);
            x2 = new complexMutable(i, i);
            x1.divide(x2);
            assertEquals(((i*i) + (i*i)) / ((i*i) + (i*i)), x1.getReal());
            assertEquals(((i*i) - (i*i)) / ((i*i) + (i*i)), x1.getImaginary());
        }
    }

    @org.junit.jupiter.api.Test
    void polar() {
        complexMutable x1;
        for(int i = 0; i < 360; i++){
            x1 = complexMutable.polar(1, i);
            assertEquals(1 * cos(i), x1.getReal());
            assertEquals(1 * sin(i), x1.getImaginary());
        }
    }
}