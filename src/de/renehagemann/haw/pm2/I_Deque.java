package de.renehagemann.haw.pm2;

/**
 * @author René Hagemann
 */

public interface I_Deque<E> {
    void push(E element);

    void pop();

    E peekLast() throws IllegalAccessException;

    E peekFirst() throws IllegalAccessException;

    void enqueue(E element);

    void dequeue();

    boolean isEmpty();
}
