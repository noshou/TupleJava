package com.oson.tuple;

/**
 * An {@code Octad} is a fixed-size tuple of 8 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Octad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Octad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6,
            I item7,
            I item8
    ) {
        super(
                8,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        item7,
                        item8
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 7)) {
            throw new IndexOutOfBoundsException("An octad contains 8 elements!");
        }
        return super.fetch(idx);
    }
}
