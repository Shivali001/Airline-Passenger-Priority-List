
import java.util.Comparator;

/**
 * An abstract base class providing some functionality of the PriorityQueue interface.
 *
 * @param <K> The type of keys stored in the priority queue.
 * @param <V> The type of values stored in the priority queue.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    /**
     * Inner class representing entries in the priority queue.
     *
     * @param <K> The type of keys.
     * @param <V> The type of values.
     */
    protected static class PQEntry<K, V> implements Entry<K, V> {

        private K k;
        private V v;

        /**
         * Constructs a PQEntry with the given key and value.
         *
         * @param key   The key of the entry.
         * @param value The value of the entry.
         */
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        protected void setKey(K key) {
            k = key;
        }

        protected void setValue(V value) {
            v = value;
        }

        public String toString() {
            return getValue().toString();
        }
    }

    private Comparator<K> comp;

    /**
     * Constructs a priority queue with the given comparator.
     *
     * @param c The comparator to use for ordering keys.
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Constructs a priority queue with a default comparator.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Compares two entries based on their keys.
     *
     * @param a The first entry.
     * @param b The second entry.
     * @return A negative integer if a < b, zero if a equals b, or a positive integer if a > b.
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Checks if the given key is compatible with the comparator.
     *
     * @param key The key to check.
     * @return true if the key can be compared to itself using the comparator, false otherwise.
     * @throws IllegalArgumentException if the key is incompatible with the comparator.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);  // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}