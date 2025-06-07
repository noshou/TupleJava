import java.util.*;

/**
 * Abstract class representing a generic multiplet of comparable items.
 * Stores the items in a LinkedHashMap keyed by their position.
 *
 * @param <I> the type of items in the multiplet; must implement Comparable
 */
public abstract class Multiplet<I extends Comparable<I>> implements Comparable<Multiplet<I>> {

    /**
     * The map storing the multiplet elements, keyed by their index.
     */
    private final Map<Integer, I> multiplet;

    /**
     * Constructs a Multiplet with the given size and initializes it
     * with the provided array of items.
     *
     * @param size the size of the multiplet
     * @param items the items to initialize the multiplet with
     */
    protected Multiplet(int size, I[] items) {
        if (items.length != size) {
            throw new IndexOutOfBoundsException();
        }
        this.multiplet = new LinkedHashMap<>();
        int incr = 0;
        for (I item : items) {
            this.multiplet.put(incr, item);
            incr++;
        }
    }

    /**
     * Fetches the item at the given index from the multiplet.
     *
     * @param idx the index of the item to fetch
     * @return the item at the specified index
     */
    protected I fetch(int idx) {
        return this.multiplet.get(idx);
    }

    /**
     * Finds and returns the smallest item in the multiplet according
     * to their natural ordering.
     *
     * @return the smallest item in the multiplet
     */
    public I fetchSmallest() {
        I smallest = this.multiplet.get(0);
        for (int i = 1; i < this.multiplet.size(); i++) {
            if (this.multiplet.get(i).compareTo(smallest) < 0) {
                smallest = this.multiplet.get(i);
            }
        }
        return smallest;
    }

    /**
     * Finds and returns the largest item in the multiplet according
     * to their natural ordering.
     *
     * @return the largest item in the multiplet
     */
    public I fetchLargest() {
        I largest = this.multiplet.get(0);
        for (int i = 1; i < this.multiplet.size(); i++) {
            if (this.multiplet.get(i).compareTo(largest) > 0) {
                largest = this.multiplet.get(i);
            }
        }
        return largest;
    }

    /**
     * Sorts the multiplet in ascending natural order of the items.
     * Reassigns the keys to match the new order (0-based).
     */
    public void sortNatural() {
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.multiplet.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        this.multiplet.clear();
        int idx = 0;
        for (Map.Entry<Integer, I> entry : entries) {
            this.multiplet.put(idx, entry.getValue());
            idx++;
        }
    }

    /**
     * Sorts the multiplet in descending natural order of the items.
     * Reassigns the keys to match the new order (0-based).
     */
    public void sortReverseNatural() {
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.multiplet.entrySet());
        entries.sort(Comparator.comparing(Map.Entry<Integer, I>::getValue).reversed());
        this.multiplet.clear();
        int idx = 0;
        for (Map.Entry<Integer, I> entry : entries) {
            this.multiplet.put(idx, entry.getValue());
            idx++;
        }
    }

    /**
     * Returns the contents of the multiplet as an array.
     *
     * @return an array containing the multiplet items in order
     */
    public I[] toList() {
        // Warning: this will need to be fixed because of type erasure issues
        I[] list = (I[]) new Comparable[this.multiplet.size()];
        for (int i = 0; i < this.multiplet.size(); i++) {
            list[i] = this.fetch(i);
        }
        return list;
    }

    /**
     * Compares this multiplet with another multiplet based on their sizes.
     *
     * @param other the other multiplet to compare to
     * @return -1 if this multiplet is smaller, 1 if larger, 0 if equal size
     */
    @Override
    public int compareTo(Multiplet<I> other) {
        if (this.multiplet.size() < other.multiplet.size()) {
            return -1;
        } else if (this.multiplet.size() > other.multiplet.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns a string representation of the Multiplet.
     * The format is: ⟨elem1, elem2, elem3, ...⟩
     * where each element is the string representation of the values
     * in the multiplet, ordered by their keys starting from 0.
     *
     * @return a string representation of the multiplet values enclosed in angle brackets
     */
    @Override
    public String toString() {
        StringBuilder multipletStr = new StringBuilder();
        multipletStr.append("⟨");
        List<Map.Entry<Integer, I>> entries = new ArrayList<>(this.multiplet.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            multipletStr.append(entries.get(i).getValue().toString());
            if (i < entries.size() - 1) {
                multipletStr.append(", ");
            }
        }

        multipletStr.append("⟩");
        return multipletStr.toString();
    }
}