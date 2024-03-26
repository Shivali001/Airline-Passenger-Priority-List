

/**
 * This class represents a singly linked list implementation.
 *
 * @param <E> the type of elements stored in the linked list
 */
public class SinglyLinkedList<E> {
    /**
     * This private static class represents a node in the singly linked list.
     *
     * @param <E> the type of elements stored in the node
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;

        /**
         * Constructs a node with the given element and reference to the next node.
         *
         * @param e the element to be stored in this node
         * @param n the reference to the next node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        /**
         * Returns the element stored in this node.
         *
         * @return the element stored in this node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the reference to the next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param n the reference to the next node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /**
     * Constructs an empty singly linked list.
     */
    public SinglyLinkedList() {
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return the number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element of the linked list.
     *
     * @return the first element of the linked list, or null if the linked list is empty
     */
    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    /**
     * Returns the last element of the linked list.
     *
     * @return the last element of the linked list, or null if the linked list is empty
     */
    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    /**
     * Adds an element to the beginning of the linked list.
     *
     * @param e the element to be added to the beginning of the linked list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param e the element to be added to the end of the linked list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    /**
     * Removes and returns the first element of the linked list.
     *
     * @return the first element of the linked list, or null if the linked list is empty
     */
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return a string representation of the linked list
     */
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        Node<E> current = head;
        sb1.append("[");
        while (current != null) {
            sb1.append(current.getElement() + " ,");
            current = current.getNext();
        }
        sb1.append("]");
        return sb1.toString();
    }
}
