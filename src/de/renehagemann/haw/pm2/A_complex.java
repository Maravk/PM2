package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

import java.util.Objects;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.acos;

public abstract class A_complex {
    protected double real;
    protected double imaginary;

    /**
     * Creates a new complex number
     * @param a real part of the number
     * @param b imaginary part of the number
     */
    public A_complex(double a, double b){
        real = a;
        imaginary = b;
    }

    //public static abstract A_complex polar(double r, double phi);

    /**
     * Returns the real portion of the number
     * @return real part of the number
     */
    public double getReal(){
        return real;
    }

    /**
     * Returns the imaginary portion of the number
     * @return imaginary part of the number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Returns the value of the polar coordinate
     * @return value of the polar coordinate
     */
    public double getPolarR(){
        return sqrt(real * real + imaginary * imaginary);
    }

    /**
     * Returns the angle of the polar coordinate
     * @return angle of the poloar coordinate
     */
    public double getPolarPhi(){
        return acos(real / sqrt(real * real + imaginary * imaginary));
    }

    /**
     * Returns the absolute value of the number
     * @return absolute value of the number
     */
    public double getValue(){
        return sqrt(real * real + imaginary * imaginary);
    }

    /**
     * Conjugate the number
     */
    public A_complex conjugate(){
        imaginary = imaginary * -1;
        return new complexImmutable(real, imaginary);
    }

    /**
     * Prints the complex number
     * @return {realpart} i{imaginarypart}
     */
    @Override
    public String toString() {
        return Double.toString(real) + " i" + Double.toString(imaginary);
    }

    /**
     * Creates a hash of the number
     * @return hashvalue
     */
    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    /**
     * Checks for equal
     * @param obj to compare with
     * @return Result of the comparision
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof A_complex)) return false;

        A_complex num = (A_complex) obj;
        return real == num.getReal() && imaginary == num.getImaginary();
    }

    /*public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        A_complex a_complex = (A_complex) object;
        return Double.compare(a_complex.real, real) == 0 &&
                Double.compare(a_complex.imaginary, imaginary) == 0;
    }

    public int hashCode() {

        return java.util.Objects.hash(super.hashCode(), real, imaginary);
    }*/
}
