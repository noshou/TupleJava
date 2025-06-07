public class Singlet<I extends Comparable<I>> extends Multiplet<I> {

    @SuppressWarnings("unchecked")
    public Singlet(I item) {
        super(1, (I[]) new Comparable[]{item});
    }

    @Override
    public I fetch(int idx) {
        if (idx != 0) {
            throw new IndexOutOfBoundsException();
        }
        return super.fetch(idx);
    }

    public static void main(String[] args) {

        // Test 1: fetchSmallest and fetchLargest should both return the single item
        Singlet<Integer> singletInt = new Singlet<>(42);
        if (singletInt.fetchSmallest() != 42) {
            System.out.println("Test 1 failed: fetchSmallest");
        }
        if (singletInt.fetchLargest() != 42) {
            System.out.println("Test 1 failed: fetchLargest");
        }

        // Test 2: toString contains the element and proper brackets
        Singlet<String> singletStr = new Singlet<>("hello");
        String str = singletStr.toString();
        if (!str.contains("hello") || !str.startsWith("⟨") || !str.endsWith("⟩")) {
            System.out.println("Test 2 failed: toString");
        }

        // Test 3: compareTo returns 0 for two singlets (both size 1)
        Singlet<Integer> s1 = new Singlet<>(5);
        Singlet<Integer> s2 = new Singlet<>(10);
        if (s1.compareTo(s2) != 0) {
            System.out.println("Test 3 failed: compareTo");
        }

        // Test 4: sortNatural should not throw and keep element intact
        try {
            singletInt.sortNatural();
            if (singletInt.fetchSmallest() != 42) {
                System.out.println("Test 4 failed: sortNatural value changed");
            }
        } catch (Exception e) {
            System.out.println("Test 4 failed: sortNatural threw exception");
        }
    }
}