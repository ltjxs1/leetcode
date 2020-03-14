package cn.jzp.leetcode.pratice.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {

    private Object[] container;
    private volatile int index = 0;

    public ArrayStack(int size) {
        container = new Object[size];
    }

    public ArrayStack() {
    }

    @Override
    public synchronized void push(T t) {
        if(index < container.length){
            index ++;
            container[index] = t;
        }else{
            throw new RuntimeException("stack is full");
        }
    }

    @Override
    public synchronized T pop() {
        if(index == 0){
            throw new RuntimeException("stack is empty");
        }else{
            index --;
            @SuppressWarnings("unchecked")
            T t = (T) container[index];
            container[index] = null;
            return t;
        }
    }
}
