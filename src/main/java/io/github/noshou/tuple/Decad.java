package io.github.noshou.tuple;

/**
 * A {@code Decad} is a fixed-size tuple of 10 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Decad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Decad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6,
            I item7,
            I item8,
            I item9,
            I item10
    ) {
        super(
                10,
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
                        item10
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 9)) {
            throw new IndexOutOfBoundsException("A decad contains 10 elements!");
        }
        return super.fetch(idx);
    }
}
