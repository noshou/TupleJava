package io.github.noshou.tuple;
import java.util.*;

/**
 * Abstract class representing a generic tuple of comparable items.
 * Stores the items in a LinkedHashMap keyed by their position.
 * @param <I> the type of items in the tuple; must implement Comparable
 */
public abstract class Tuple<I extends Comparable<I>>
        implements Comparable<Tuple<I>>, Iterable<I>  {

    /**
     * The map storing the tuple elements, keyed by their index.
     */
    private final Map<Integer, I> tuple;
    private int size;


    /**
     * Constructs a Tuple with the given size and initializes it
     * with the provided array of items.
     *
     * @param size the size of the tuple
     * @param items the items to initialize the tuple with
     */
    protected Tuple(int size, I[] items) {
        if (items.length != size) {
            throw new IndexOutOfBoundsException();
        }
        this.tuple = new LinkedHashMap<>();
        int incr = 0;
        for (I item : items) {
            this.tuple.put(incr, item);
            incr++;
        }
        this.size = size;
    }



    /**
     * Fetches the item at the given index from the tuple.
     *
     * @param idx the index of the item to fetch
     * @return the item at the specified index
     */
    protected I fetch(int idx) {
        return this.tuple.get(idx);
    }

    /**
     * Returns the number of elements in this {@code Tuple}.
     *
     * @return the number of items in this tuple
     */
    public int fetchSize() {
        return this.size;
    }

    /**
     * Returns True if empty (nullad)
     *
     * @return True if nullad, else False
     */
    public boolean isEmpty() {
        return this.fetchSize() == 0;
    }

    /**
     * Finds and returns the smallest item in the tuple according
     * to their natural ordering.
     *
     * @return the smallest item in the tuple
     */
    public I fetchSmallest() {
        I smallest = this.tuple.get(0);
        for (int i = 1; i < this.fetchSize(); i++) {
            if (this.tuple.get(i).compareTo(smallest) < 0) {
                smallest = this.tuple.get(i);
            }
        }
        return smallest;
    }

    /**
     * Finds and returns the largest item in the tuple according
     * to their natural ordering.
     *
     * @return the largest item in the tuple
     */
    public I fetchLargest() {
        I largest = this.tuple.get(0);
        for (int i = 1; i < this.fetchSize(); i++) {
            if (this.tuple.get(i).compareTo(largest) > 0) {
                largest = this.tuple.get(i);
            }
        }
        return largest;
    }

    /**
     * Sorts the tuple in ascending natural order of the items.
     * Reassigns the keys to match the new order (0-based).
     */
    public void sortNatural() {
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.tuple.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        this.tuple.clear();
        int idx = 0;
        for (Map.Entry<Integer, I> entry : entries) {
            this.tuple.put(idx, entry.getValue());
            idx++;
        }
    }

    /**
     * Sorts the tuple in descending natural order of the items.
     * Reassigns the keys to match the new order (0-based).
     */
    public void sortReverseNatural() {
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.tuple.entrySet());
        entries.sort(Comparator.comparing(Map.Entry<Integer, I>::getValue).reversed());
        this.tuple.clear();
        int idx = 0;
        for (Map.Entry<Integer, I> entry : entries) {
            this.tuple.put(idx, entry.getValue());
            idx++;
        }
    }

    /**
     * Returns the contents of the tuple as an array.
     *
     * @return an array containing the tuple items in order
     */
    public I[] toList() {
        // Warning: this will need to be fixed because of type erasure issues
        I[] list = (I[]) new Comparable[this.tuple.size()];
        for (int i = 0; i < this.fetchSize(); i++) {
            list[i] = this.fetch(i);
        }
        return list;
    }

    /**
     * Compares this {@code Tuple} to another {@code Tuple} using
     * <a href="https://en.wikipedia.org/wiki/Lexicographical_order">lexicographical order</a>.
     * <p>
     * The comparison proceeds element by element, starting from index {@code 0},
     * using each element's {@link Comparable#compareTo(Object) natural ordering}.
     * If all compared elements are equal, the shorter tuple is considered smaller.
     *
     * @param other the other {@code Tuple} to compare to
     * @return {@code -1} if this tuple is lexicographically smaller,
     *         {@code 1} if it is greater,
     *         or {@code 0} if both tuples are equal
     * @throws NullPointerException if {@code other} is {@code null}
     */
    @Override
    public int compareTo(Tuple<I> other) {

        // get sizes
        int this_size = this.fetchSize();
        int other_size = other.fetchSize();

        // special case: this.tuple is nullad (no elements)
        if (this_size == 0) {

            // case 1: this.tuple and other.tuple are both nullads
            if (other_size == 0) {
                return 0;
            }

            // case 2: this.tuple is nullad, other is an N-Tuple
            else {
                return -1;
            }
        }

        // iterate thru arrays and compare
        // compare each element and stop at first non equal comparison
        // if reached end, ensures all elements in each tuple from 0->i are equal
        I this_item;
        I other_item;
        for (int i = 0; i < Math.min(this_size, other_size); i++) {

            this_item = this.fetch(i);
            other_item = other.fetch(i);

            // case 3: this.tuple > other.tuple
            if (this_item.compareTo(other_item) > 0) {
                return 1;
            }

            // case 4: this.tuple < other.tuple
            else if (this_item.compareTo(other_item) < 0) {
                return -1;
            }
        }
        // all elements in this.tuple and other.tuple
        // are equal from 0->i, therefore if
        // this.size > other.size, return 1;
        // this.size < other.size, return -1;
        // this.size == other.size, return 0

        // case 5: this.tuple > other.tuple
        if (this_size > other_size) {
            return 1;
        }

        // case 6: this.tuple < other.tuple
        else if (this_size < other_size) {
            return -1;
        }

        // case 7: this.tuple == other.tuple
        else {
            return 0;
        }
    }

    /**
     * Returns a string representation of the Tuple.
     * The format is: ⟨elem1, elem2, elem3, ...⟩
     * where each element is the string representation of the values
     * in the tuple, ordered by their keys starting from 0.
     *
     * @return a string representation of the tuple values enclosed in angle brackets
     */
    @Override
    public String toString() {
        StringBuilder tupleStr = new StringBuilder();
        tupleStr.append("⟨");
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.tuple.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            tupleStr.append(entries.get(i).getValue().toString());
            if (i < entries.size() - 1) {
                tupleStr.append(", ");
            }
        }

        tupleStr.append("⟩");
        return tupleStr.toString();
    }

    /**
     * Returns an iterator over the elements in this tuple in proper sequence.
     * This allows the tuple to be used in enhanced for-loops (for-each).
     *
     * @return an {@link Iterator} over the items of the tuple
     */
    @Override
    public Iterator<I> iterator() {
        return tuple.values().iterator();
    }

    /**
     * Computes the hash code for this tuple.
     * The hash code is based on the internal map of elements, ensuring that
     * equal tuples produce the same hash code.
     *
     * @return the hash code value for this tuple
     */
    @Override
    public int hashCode() {
        return Objects.hash(tuple);
    }

    /**
     * Compares this tuple to the specified object for equality.
     * Two tuples are considered equal if they are of the same class and
     * contain the same elements in the same order.
     *
     * @param obj the object to compare to
     * @return {@code true} if the specified object is equal to this tuple;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple<?> other = (Tuple<?>) obj;
        return Objects.equals(this.tuple, other.tuple);
    }
}
