package io.github.noshou.tuple;

/**
 * A {@code Tetrakaidecad} is a fixed-size tuple of 14 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Tetrakaidecad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Tetrakaidecad(
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
            I item13,
            I item14
    ) {
        super(
                14,
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
                        item13,
                        item14
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 13)) {
            throw new IndexOutOfBoundsException("A tetrakaidecad contains 14 elements!");
        }
        return super.fetch(idx);
    }
}
