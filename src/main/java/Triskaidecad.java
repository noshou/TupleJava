package com.oson.tuple;

/**
 * A {@code Triskaidecad} is a fixed-size tuple of 13 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Triskaidecad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Triskaidecad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6,
            I item7,
            I item8,
            I item9,
            I item10,
            I item11,
            I item12,
            I item13
    ) {
        super(
                13,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        item7,
                        item8,
                        item9,
                        item10,
                        item11,
                        item12,
                        item13
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 12)) {
            throw new IndexOutOfBoundsException("A triskaidecad contains 12 elements!");
        }
        return super.fetch(idx);
    }
}