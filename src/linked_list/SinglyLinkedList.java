package linked_list;

public class SinglyLinkedList<E> implements Cloneable {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SinglyLinkedList other = (SinglyLinkedList) obj;
        if (size != other.size) return false;
        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
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

    @Override
    protected SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        var other = (SinglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        var sll = new SinglyLinkedList<Integer>();
        sll.addLast(5);
        sll.addLast(7);
        sll.addLast(9);
        var sll2 = sll.clone();
        System.out.println(sll2.first());
        System.out.println(sll2.last());
    }

}
