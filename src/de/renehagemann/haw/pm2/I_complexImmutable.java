package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

public interface I_complexImmutable {
    /**
     * Immutable add function
     * @param num The complex number to add to the current
     * @return The result
     */
    A_complex add(A_complex num);

    /**
     * Immutable subtraction function
     * @param num The complex number to subtract from the current
     * @return The result
     */
    A_complex sub(A_complex num);

    /**
     * Immutable multiply function
     * @param num The complex number to multiply with the current
     * @return The result
     */
    A_complex multiply(A_complex num);

    /**
     * Immutable division function
     * @param num The complex number to divide the current with
     * @return
     */
    A_complex divide(A_complex num);
}
