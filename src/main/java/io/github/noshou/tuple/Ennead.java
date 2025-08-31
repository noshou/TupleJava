package io.github.noshou.tuple;

/**
 * An {@code Ennead} is a fixed-size tuple of 9 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Ennead<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Ennead(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6,
            I item7,
            I item8,
            I item9
    ) {
        super(
                9,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        item7,
                        item8,
                        item9
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 8)) {
            throw new IndexOutOfBoundsException("An ennead contains 9 elements!");
        }
        return tuple.get(idx);
    }
}
