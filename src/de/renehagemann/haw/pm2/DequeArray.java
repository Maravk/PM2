package de.renehagemann.haw.pm2;

import de.renehagemann.haw.ad.ArrayList;
import de.renehagemann.haw.ad.I_list;

/**
 * @author René Hagemann
 */

public class DequeArray<E> implements I_Deque<E> {

    I_list<E> array;
    int elem = 0;

    public DequeArray(){
        this.array = new ArrayList<>();
    }

    public void push(E element){
        if (element != null) {
            this.array.insert(this.elem, element);
            this.elem++;
        }
    }

    public void pop(){
        this.elem--;
        this.array.delete(this.elem);
    }

    public E peekLast() throws IllegalAccessException{
        if (this.elem == 0){
            throw new IllegalAccessException("Deque is empty");
        }
        return this.array.get(this.elem - 1);
    }

    public void enqueue(E element){
        if (element != null) {
            this.array.insert(0, element);
            this.elem++;
        }
    }

    public void dequeue(){
        this.array.delete(0);
        this.elem--;
    }
    public E peekFirst() throws IllegalAccessException{
        if (this.elem == 0){
            throw new IllegalAccessException("Deque is empty");
        }
        return this.array.get(0);
    }

    public boolean isEmpty(){
        return this.elem == 0;
    }
}
