package stacks_queues_deques;

public interface Queue<E> {
    int size();
    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E first();
}
