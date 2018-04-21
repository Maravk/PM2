package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    /**
     * Tests the MathUtils.exp function
     */
    @Test
    void exp() {
        complexMutable x1;
        for(int i = 0; i < 100; i++){
            x1 = MathUtils.exp(new complexMutable(i, i));
            assertEquals(Math.exp(i) * Math.cos(i), x1.getReal());
            assertEquals(Math.exp(i) * Math.sin(i), x1.getImaginary());
        }
    }

    /**
     * Tests the MathUtils.sin function
     */
    @Test
    void sin() {
        complexMutable x1;
        for(int i = 0; i < 100; i++){
            x1 = MathUtils.sin(new complexImmutable(i, i));
            complexMutable result = MathUtils.exp(new complexImmutable(i, i));
            result.sub(MathUtils.exp(new complexImmutable(i, -i)));
            result.divide(new complexImmutable(0, 2));
            assertEquals(result, x1);
        }
    }

    /**
     * Tests the MathUtils.cos function
     */
    @Test
    void cos() {
        complexMutable x1;
        for(int i = 0; i < 100; i++){
            x1 = MathUtils.cos(new complexImmutable(i, i));
            complexMutable result = MathUtils.exp(new complexImmutable(i, i));
            result.add(MathUtils.exp(new complexImmutable(i, -i)));
            result.divide(new complexImmutable(2, 0));
            assertEquals(result, x1);
        }
    }
}