package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

public class MathUtils {
    /**
     * Calculates the natural logarithm of a complex number
     * @param num a complex number
     * @return The natural logarithm of the complex number
     */
    public static complexMutable exp(A_complex num){
        double a = Math.exp(num.getReal()) * Math.cos(num.getImaginary());
        double b = Math.exp(num.getReal()) * Math.sin(num.getImaginary());
        return new complexMutable(a, b);
    }

    /**
     * Calculates the sinus of a complex number
     * @param num a complex number
     * @return The sinus of the complex number
     */
    public static complexMutable sin(A_complex num){
        complexMutable result = exp(num);
        result.sub(exp(num.conjugate()));
        result.divide(new complexImmutable(0, 2));
        return result;
    }

    /**
     * Calculates the cosinus of a complex number
     * @param num a complex number
     * @return The cosinus of the complex number
     */
    public static complexMutable cos(A_complex num){
        complexMutable result = exp(num);
        result.add(exp(num.conjugate()));
        result.divide(new complexImmutable(2, 0));
        return result;
    }
}
