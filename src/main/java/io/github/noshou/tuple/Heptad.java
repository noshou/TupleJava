package io.github.noshou.tuple;

/**
 * A {@code Heptad} is a fixed-size tuple of 7 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Heptad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Heptad(
            I item1,
            I item2,
            I item3,
            I item4,
            I item5,
            I item6,
            I item7
    ) {
        super(
                7,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        item7
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 6)) {
            throw new IndexOutOfBoundsException("A heptad contains 7 elements!");
        }
        return super.fetch(idx);
    }
}
