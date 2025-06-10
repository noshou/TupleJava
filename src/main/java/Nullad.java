/**
 * A {@code Nullad} is a zero-length {@link Tuple}.
 * It represents an empty tuple (like Unit in some functional languages).
 *
 * @param <I> the (unused) type parameter
 */
public class Nullad<I extends Comparable<I>> extends Tuple<I> {

    @SuppressWarnings("unchecked")
    public Nullad() {
        super(0, (I[]) new Comparable[0]);
    }

    @Override
    public I fetch(int idx) {
        throw new IndexOutOfBoundsException("A nullad contains no elements!");
    }
}