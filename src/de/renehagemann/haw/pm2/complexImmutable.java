package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class complexImmutable extends A_complex implements I_complexImmutable {
    @Override
    public A_complex add(A_complex num) {
        double a = real + num.getReal();
        double b= imaginary + num.getImaginary();
        return new complexImmutable(a, b);
    }

    @Override
    public A_complex sub(A_complex num) {
        double a = real - num.getReal();
        double b = imaginary - num.getImaginary();
        return new complexImmutable(a, b);
    }

    @Override
    public A_complex multiply(A_complex num) {
        double a = real * num.getReal() - imaginary * num.getImaginary();
        double b = real * num.getImaginary() + imaginary * num.getReal();
        return new complexImmutable(a, b);
    }

    @Override
    public A_complex divide(A_complex num) {
        double a = real * num.getReal() + imaginary * num.getImaginary();
        a = a / (num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary());
        double b = imaginary * num.getReal() - real * num.getImaginary();
        b = b / (num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary());
        return new complexImmutable(a, b);
    }

    /**
     * Creates a new immutable complex number
     * @param a real part of the number
     * @param b imaginary part of the number
     */
    public complexImmutable(double a, double b){
        super(a, b);
    }

    /**
     * Create a new immutable complex number from polar coordinates
     * @param r value of the number
     * @param phi angle of the number
     * @return new complex number
     */
    public static complexImmutable polar(double r, double phi){
        double a = r * cos(phi);
        double b = r * sin(phi);
        return new complexImmutable(a, b);
    }
}
