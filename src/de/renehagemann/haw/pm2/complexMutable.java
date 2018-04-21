package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class complexMutable extends A_complex implements I_complexMutable {
    @Override
    public void add(A_complex num) {
        super.real += num.getReal();
        super.imaginary += num.getImaginary();
    }

    @Override
    public void sub(A_complex num) {
        super.real -= num.getReal();
        super.imaginary -= num.getImaginary();
    }

    @Override
    public void multiply(A_complex num) {
        double a = real * num.getReal() - imaginary * num.getImaginary();
        double b = real * num.getImaginary() + imaginary * num.getReal();
        real = a;
        imaginary = b;
    }

    @Override
    public void divide(A_complex num) {
        double a = real * num.getReal() + imaginary * num.getImaginary();
        a = a / (num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary());
        double b = imaginary * num.getReal() - real * num.getImaginary();
        b = b / (num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary());
        real = a;
        imaginary = b;
    }

    /**
     * Creates a new mutable complex number
     * @param a real part of the number
     * @param b imaginary part of the number
     */
    public complexMutable(double a, double b){
        super(a, b);
    }

    /**
     * Creates a new mutable complex number from polar coordinates
     * @param r value of the number
     * @param phi angle of the number
     * @return new complex number
     */
    public static complexMutable polar(double r, double phi){
        double a = r * cos(phi);
        double b = r * sin(phi);
        return new complexMutable(a, b);
    }
}
