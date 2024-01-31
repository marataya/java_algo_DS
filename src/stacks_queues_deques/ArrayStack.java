package stacks_queues_deques;

import java.util.IllegalFormatException;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
    private static final int CAPACITY = 1000;

    private E[] data;
    private int t = -1; // idx of a top element in stack

    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }


    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;  //increment before storing new item
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collector
        t--;
        return answer;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<Integer>();
        s.push(5);
        s.push(7);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.top());
    }

}
