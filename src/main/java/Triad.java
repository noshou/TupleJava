/**
 * A {@code Triad} is a fixed-size tuple of 3 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Triad<I extends Comparable<I>> extends Tuple<I> {
    @SuppressWarnings("unchecked")
    public Triad(
            I item1,
            I item2,
            I item3
    ) {
        super(
                3,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                        item3
                }
        );
    }

    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 2)) {
            throw new IndexOutOfBoundsException("A triad contains 3 elements!");
        }
        return super.fetch(idx);
    }
}
