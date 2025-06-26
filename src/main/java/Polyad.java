package com.oson.tuple;
/**
 * A {@code Polyad} is a fixed-size tuple of n {@link Comparable} elements.
 *
 * @param <I> the type of the element in this tuple; must implement {@link Comparable}
 */
public class Polyad<I extends Comparable<I>> extends Tuple<I> {

    /**
     * Constructs a {@code Polyad} from an array of elements.
     *
     * @param items an array of elements of type {@code I}
     */
    @SuppressWarnings("unchecked")
    public Polyad(I[] items) {
        super(items.length, items);
    }

    /**
     * Returns the element at the specified position in this tuple.
     *
     * @param idx the index of the element to return (0-based)
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public I fetch(int idx) {
        if (idx < 0 || idx >= super.fetchSize()) {
            throw new IndexOutOfBoundsException("Polyad indexed out of bounds!");
        }
        return super.fetch(idx);
    }
}