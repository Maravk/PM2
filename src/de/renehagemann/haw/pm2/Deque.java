package de.renehagemann.haw.pm2;

import de.renehagemann.haw.ad.DoubleLinkList;
import de.renehagemann.haw.ad.I_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author René Hagemann
 */

public class Deque<E> implements I_Deque<E>{
    I_list<E> stack;
    int elem = 0;

    public Deque(){
        this.stack = new DoubleLinkList<>();
    }

    public void push(E element){
        if (element != null) {
            this.stack.insert(this.elem, element);
            this.elem++;
        }
    }

    public void pop(){
        this.elem--;
        this.stack.delete(this.elem);
    }

    public E peekLast() throws IllegalAccessException{
        if (this.elem == 0){
            throw new IllegalAccessException("Deque is empty");
        }
        return this.stack.get(this.elem - 1);
    }

    public void enqueue(E element){
        if (element != null) {
            this.stack.insert(0, element);
            this.elem++;
        }
    }

    public void dequeue(){
        this.stack.delete(0);
        this.elem--;
    }
    public E peekFirst() throws IllegalAccessException{
        if (this.elem == 0){
            throw new IllegalAccessException("Deque is empty");
        }
        return this.stack.get(0);
    }

    public boolean isEmpty(){
        return this.elem == 0;
    }
}
