/**
 * A {@code Dyad} is a fixed-size tuple of 2 {@link Comparable} elements.
 *
 * @param <I> the type of elements in this tuple; must implement {@link Comparable}
 */
public class Dyad<I extends Comparable<I>> extends Tuple<I>  {

    @SuppressWarnings("unchecked")
    public Dyad(
            I item1,
            I item2
    ) {
        super(
                2,
                (I[]) new Comparable[]{
                        item1,
                        item2,
                }
        );
    }
    @Override
    public I fetch(int idx) {
        if ((idx < 0) || (idx > 1)) {
            throw new IndexOutOfBoundsException("A dyad contains two elements!");
        }
        return super.fetch(idx);
    }
}
