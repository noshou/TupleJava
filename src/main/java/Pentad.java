package com.oson.tuple;

/**
 * A {@code Pentad} is a fixed-size tuple of 5 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Pentad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Pentad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5
    ) {
        super(
                5,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 4)) {
            throw new IndexOutOfBoundsException("A pentad contains 5 elements!");
        }
        return super.fetch(idx);
    }
}
