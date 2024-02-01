package linked_list;

public class SinglyLinkedList<E> {
    //-----------------nested Node class-------------------
    private static class Node<E> {

        private E element;
        private Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
//-----------------end of nested Node class----------------

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.element;
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.element;
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty())
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

}
