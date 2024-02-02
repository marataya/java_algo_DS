package stacks_queues_deques;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 20;
    private E[] data;
    private int f;  // index of the front element
    private int size = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) throw new IllegalStateException("The queue is full");
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E first() {
        return null;
    }

    public static void main(String[] args) {
        var aq = new ArrayQueue<Integer>();
        aq.enqueue(5);
        aq.enqueue(7);
        aq.enqueue(9);
        System.out.println(Arrays.toString(aq.data));
    }
}
