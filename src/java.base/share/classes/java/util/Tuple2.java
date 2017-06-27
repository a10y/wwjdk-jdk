package java.util;

/**
 * Type representing a pair of elements.
 * Now I'm hacking the JDK, this is AWESOME.
 *
 * @author Andrew Duffy
 * @since 9
 */
public class Tuple2<A, B> {
    private A a;
    private B b;

    private Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Retrieves the first element of the pair.
     *
     * @return The left element in the pair.
     */
    public A first() {
        return a;
    }

    /**
     * Retrieves the second element of the pair.
     *
     * @return The right element in the pair.
     */
    public B second() {
        return b;
    }

    /**
     * Generates a hash code for this type so it can be stored in hashed data structures.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    /**
     * Check equality with another Object. Equality occurs when the other object is also a Pair
     * and both pair elements are equal according to their types.
     *
     * @return Whether this object is equal to the other.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Tuple2)
            && ((Tuple2) o).a.equals(a)
            && ((Tuple2) o).b.equals(b);
    }

    /**
     * Create a new pair of the specified type.
     *
     * @param <A> The type of the first element.
     * @param <B> The type of the second element.
     * @param a The first element.
     * @param b The second element.
     * @return The resultant 2-tuple.
     */
    public static <A, B> Tuple2<A, B> of(A a, B b) {
        return new Tuple2<>(a, b);
    }

}
