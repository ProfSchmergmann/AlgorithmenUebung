package uebung02;

/**
 * Class QNode to store a queue entry.
 * This QNode is a linked list node.
 *
 * @param <T> the generic to store
 * @author Sven Bergmann
 * @version 06.04.2020
 */
public class QNode<T> {
    private T key;
    private QNode<T> next;

    /**
     * Constructor for creating a new linked list node.
     *
     * @param key the key to store of the type T
     */
    public QNode(T key) {
        this.key = key;
        this.next = null;
    }

    public T getKey() {
        return key;
    }

    public QNode<T> getNext() {
        return next;
    }

    public void setNext(QNode<T> next) {
        this.next = next;
    }
}
