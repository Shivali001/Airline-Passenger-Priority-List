
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Dynamic ArrayQueue Class that implements Iterable interface
 * Name Simranjeet singh Sidhu
 * Student id 3143986
 */
public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 4;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int cap) {
        data = (E[]) new Object[cap];
    }

    /**
     * Returns the size of the Queue
     * 
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the Queue is empty.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns but does not remove the first element of the Queue. Null if Queue is
     * empty.
     * 
     * @return E
     */
    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    /**
     * Returns and removes the first element of the Queue. Null if empty.
     * 
     * @return E
     */
    public E dequeue() {
        if (isEmpty())
            return null;
        E ans = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return ans;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) {
            System.out.println("....Resizing array....");
            resize(3* data.length);
        }
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    // Add the enqueue method

    // Add the resize method
    private void resize(int cap)throws IllegalArgumentException {
      E[] newArr = (E[]) new Object[cap];
        int currentIndex = f;
        for (int i = 0; i < size; i++) {
            currentIndex = (currentIndex + 1) % data.length;
            newArr[i] = data[currentIndex];
          
        }
        this.data = newArr;
       currentIndex=f=0;
    }

    // Add the toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[(f + i) % data.length]);
        }
        sb.append("]");
        return sb.toString();
    }
    

    public void clear() {

        f = 0;
        size = 0;
    }
    // Add the clear method

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;

        public boolean hasNext() {
            return j < size;
        }

        // Add the next method with the following signature

        public E next() throws NoSuchElementException {
            if (j==size) {
                throw new NoSuchElementException("No next element");
            }
            E element= data[(f+j++)%data.length];
            return element;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}