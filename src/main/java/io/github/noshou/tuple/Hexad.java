package io.github.noshou.tuple;

/**
 * A {@code Hexad} is a fixed-size tuple of 6 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Hexad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Hexad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6
    ) {
        super(
                6,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 5)) {
            throw new IndexOutOfBoundsException("A hexad contains 6 elements!");
        }
        return tuple.get(idx);
    }

}
