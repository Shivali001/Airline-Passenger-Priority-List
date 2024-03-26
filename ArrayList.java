
 
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of the List interface using an array-based data structure.
 * <p>
 * This class provides methods to manipulate a list of elements stored in an array.
 * It supports dynamic resizing of the underlying array as needed.
 * </p>
 *
 * @param <E> The type of elements stored in the list.
 */
public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 4;
    private E[] data;
    private int size;

    /**
     * Constructs an empty ArrayList with the default initial capacity.
     */
    public ArrayList() {
        this(CAPACITY);
    }

    /**
     * Constructs an empty ArrayList with the specified initial capacity.
     *
     * @param size The initial capacity of the ArrayList.
     */
    public ArrayList(int size) {
        this.size = size;
        data = (E[]) new Object[size];
    }

    /**
     * Checks if the ArrayList is empty.
     *
     * @return true if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if this ArrayList is equal to another object.
     *
     * @param o The object to compare with this ArrayList.
     * @return true if the ArrayList is equal to the specified object, false otherwise.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        ArrayList other = (ArrayList) o;

        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the element at the specified index in this ArrayList.
     *
     * @param i The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E get(int i) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Array is Empty");
        }
        validateIndex(i);
        return data[i];
    }

    /**
     * Validates the given index.
     *
     * @param i The index to validate.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    protected void validateIndex(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Wrong index: " + i);
        }
    }

    /**
     * Returns the size of the ArrayList.
     *
     * @return The size of the ArrayList.
     */
    public int size() {
        return size;
    }

    /**
     * Replaces the element at the specified position in this ArrayList with the specified element.
     *
     * @param i The index of the element to replace.
     * @param e The new element to be stored at the specified position.
     * @return The element previously at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        validateIndex(i);
        E temp;
        temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Appends the specified element to the end of this ArrayList.
     *
     * @param e The element to be appended to this ArrayList.
     */
    public void add(E e) {
        add(size, e);
    }

    /**
     * Inserts the specified element at the specified position in this ArrayList.
     *
     * @param i The index at which the specified element is to be inserted.
     * @param e The element to be inserted.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
        validateIndex(i);

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }

    /**
     * Removes the element at the specified position in this ArrayList.
     *
     * @param i The index of the element to be removed.
     * @return The element that was removed from the ArrayList.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        validateIndex(i);
        E temp = data[i];

        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;

        if (size <= data.length / 4) {
            resize(data.length / 2);
        }
        return temp;
    }

    /**
     * Resizes the underlying array to the specified capacity.
     *
     * @param capacity The new capacity of the underlying array.
     */
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    /**
     * An iterator over the elements in this ArrayList.
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return true if there are more elements, false otherwise.
         */
        public boolean hasNext() {
            return j < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return The next element in the iteration.
         * @throws NoSuchElementException if there are no more elements to iterate over.
         */
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element.");
            }
            removable = true;
            return data[j++];
        }

        /**
         * Removes the last element returned by the iterator from the underlying ArrayList.
         *
         * @throws IllegalStateException if there are no elements to remove or if the remove operation is not supported.
         */
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("Nothing to remove.");
            }
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }

    /**
     * Returns an iterator over the elements in this ArrayList.
     *
     * @return An iterator over the elements in this ArrayList.
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }


    public String toString() {

        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(data[i]);
        }
        sb.append(")");
        sb.append(" size: " + size);
        return sb.toString();
    }
}