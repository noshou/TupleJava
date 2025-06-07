public class Doublet<I extends Comparable<I>> extends Multiplet<I>  {

    @SuppressWarnings("unchecked")
    public Doublet(I item1, I item2) {
        super(2, (I[]) new Comparable[]{item1, item2});
    }

    @Override
    public I fetch(int idx) {
        if ((0<idx) || (idx>1)) {
            throw new IndexOutOfBoundsException();
        }
        return super.fetch(idx);
    }

    public static void main(String[] args) {
        try {
            Doublet<Integer> d = new Doublet<>(5, 3);

            if (d.fetch(0) != 5 && d.fetch(1) != 3 &&
                    d.fetchSmallest() != 3 && d.fetchLargest() != 5) {
                throw new AssertionError("fetch or min/max logic failed");
            }

            try {
                d.fetch(2);
                throw new AssertionError("Expected IndexOutOfBoundsException not thrown");
            } catch (IndexOutOfBoundsException expected) {
                // OK
            }

            d.sortNatural();
            if (d.fetch(0) != 3 || d.fetch(1) != 5) {
                throw new AssertionError("Natural sort failed");
            }

            d.sortReverseNatural();
            if (d.fetch(0) != 5 || d.fetch(1) != 3) {
                throw new AssertionError("Reverse sort failed");
            }

            d.toString(); // allowed to run silently

            // Regression comparison test
            Doublet<Integer> d2 = new Doublet<>(5, 3);
            if (d.compareTo(d2) != 0) {
                throw new AssertionError("compareTo mismatch");
            }

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
