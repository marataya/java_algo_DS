package stacks_queues_deques;

import linked_list.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedQueue() {    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }

    public static void main(String[] args) {
        var lq = new LinkedQueue<>();
        lq.enqueue(5);
        lq.enqueue(7);
        lq.enqueue(9);
        System.out.println(lq.size());
        System.out.println(lq.first());
    }
}
