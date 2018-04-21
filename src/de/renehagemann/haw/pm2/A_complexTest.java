package de.renehagemann.haw.pm2;

import static org.junit.jupiter.api.Assertions.*;

class A_complexTest {
    @org.junit.jupiter.api.Test
    void equals(){
        double a, b, c, d;
        complexMutable x1, x2;
        for(int i = 0; i < 100000000; i++){
            a = Math.random();
            b = Math.random();
            c = Math.random();
            d = Math.random();
            x1 = new complexMutable(a, b);
            x2 = new complexMutable(c, -d);
            x1.add(new complexMutable(c, d));
            x2.conjugate();
            x2.add(new complexMutable(a, b));
            assertEquals(x1, x2);
            assertEquals(x1.hashCode(), x2.hashCode());
        }
    }
}