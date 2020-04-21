package uebung01;

/**
 * Class uebung01.uebung01.Tuple for saving two elements with the given generic.
 *
 * @param <K> the given key
 * @param <V> the given value
 * @author Sven Bergmann
 * @version 31.03.2020
 */
public class Tuple<K, V> {
    private final K k;
    private final V v;

    public Tuple(K key, V value) {
        k = key;
        v = value;
    }

    public String toString() {
        return String.format("KEY: '%s', VALUE: '%s'", k, v);
    }

    /**
     * Getter for k.
     *
     * @return K k
     */
    public K getK() {
        return k;
    }

    /**
     * Getter for v.
     *
     * @return V v
     */
    public V getV() {
        return v;
    }
}
