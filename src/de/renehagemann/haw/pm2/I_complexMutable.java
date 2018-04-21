package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

public interface I_complexMutable {
    /**
     * Mutable add function
     * @param num The complex number to add to the current
     */
    void add(A_complex num);

    /**
     * Mutable subtraction function
     * @param num The complex number to subtract from the current
     */
    void sub(A_complex num);

    /**
     * Mutable multiply function
     * @param num The complex number to multiply with the current
     */
    void multiply(A_complex num);

    /**
     * Mutable division function
     * @param num The complex number to divide the current with
     */
    void divide(A_complex num);
}
