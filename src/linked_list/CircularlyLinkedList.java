package linked_list;

public class CircularlyLinkedList<E> implements Cloneable{
    public CircularlyLinkedList() {    }

    class Node<E> {

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

    private Node<E> tail = null;
    private int size = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CircularlyLinkedList other = (CircularlyLinkedList) obj;
        if (size != other.size) return false;
        Node walkA = tail.getNext();
        Node walkB = other.tail.getNext();
        int counter = 0;
        while (counter < size) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
            counter++;
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
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (!isEmpty()) {
            tail = tail.getNext();
        }

    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link tail to itself in case size == 0
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    @Override
    protected CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        var other = (CircularlyLinkedList<E>) super.clone();
        if (size > 0) {
            other.tail = new Node<>(tail.getElement(), null);
            Node<E> walk = tail.getNext();
            Node<E> otherTail = other.tail;
            int counter = 0;
            while (counter < size) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
                counter++;
            }
        }
        return other;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(head == tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        var cll = new CircularlyLinkedList<>();
        cll.addLast(5);
        cll.addLast(7);
        cll.addLast(9);
        System.out.println(cll.first());
        System.out.println(cll.last());
        System.out.println(cll.size());
        var cll2 = cll.clone();
        System.out.println(cll2.first());
        System.out.println(cll2.last());
        System.out.println(cll2.size());

        System.out.println(cll.equals(cll2));

        cll2.rotate();
        System.out.println(cll2.first());
        System.out.println(cll2.last());
        System.out.println(cll2.size());

        System.out.println(cll.equals(cll2));

    }

}

