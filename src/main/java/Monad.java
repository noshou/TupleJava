/**
 * A {@code Monad} is a fixed-size tuple of 1 {@link Comparable} element.
 *
 * @param <I> the type of the element in this tuple; must implement {@link Comparable}
 */
public class Monad<I extends Comparable<I>> extends Tuple<I> {

    @SuppressWarnings("unchecked")
    public Monad(I item) {
        super(1, (I[]) new Comparable[]{item});
    }

    @Override
    public I fetch(int idx) {
        if (idx != 0) {
            throw new IndexOutOfBoundsException("A monad contains 1 element!");
        }
        return super.fetch(idx);
    }
}