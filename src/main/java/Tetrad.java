package com.oson.tuple;

/**
 * A {@code Tetrad} is a fixed-size tuple of 4 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Tetrad<I extends Comparable<I>> extends Tuple<I> {

    @SuppressWarnings("unchecked")
    public Tetrad(
            I item1,
            I item2,
            I item3,
            I item4
    ) {
        super(
                4,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 3)) {
            throw new IndexOutOfBoundsException("A tetrad contains 4 elements!");
        }
        return super.fetch(idx);
    }

}
