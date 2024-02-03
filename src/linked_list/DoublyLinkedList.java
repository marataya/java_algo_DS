package linked_list;

import stacks_queues_deques.Deque;

public class DoublyLinkedList<E> implements Deque<E> {

    private static class Node<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    private Node<E> header;

    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int getSize() {
        return size;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    //    update methods
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private E remove(Node<E> node) {
        var predecessor = node.getPrev();
        var successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        return node.getElement();
    }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public static void main(String[] args) {
        var dll = new DoublyLinkedList<Integer>();
        dll.addFirst(5);
        dll.addLast(7);
        System.out.println(dll.getSize());
        System.out.println(dll.first());
        System.out.println(dll.last());

    }
}
