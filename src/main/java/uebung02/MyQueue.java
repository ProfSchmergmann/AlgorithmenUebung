package uebung02;

/**
 * This class represents a linked-list implementation of a queue.
 *
 * @param <T> the generic to be stored in this queue.
 * @author Sven Bergmann
 * @version 06.04.2020
 */
public class MyQueue<T> {
    private QNode<T> front;
    private QNode<T> rear;

    /**
     * Constructor creates an empty queue.
     */
    public MyQueue() {
        this.front = this.rear = null;
    }

    /**
     * This method adds a key to the queue.
     *
     * @param key the key of type T
     */
    public void enqueue(T key) {

        // Create a new LL node
        QNode<T> temp = new QNode<>(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.setNext(temp);
        this.rear = temp;
    }

    /**
     * This method removes the key and returns it.
     *
     * @return the removed key
     */
    public QNode<T> dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null) {
            return null;
        }

        // Store previous front and move front one node ahead
        QNode<T> temp = this.front;
        this.front = this.front.getNext();

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
        }
        return temp;
    }

    /**
     * This method should delete the entries of the queue.
     * Hint: Garbage collector is working.
     */
    public void clear() {
        this.front = this.rear = null;
    }

    /**
     * This method returns a String representation of the elements stored in this queue.
     *
     * @return a String
     */
    public String toString() {

        // If queue is empty, return NULL.
        if (this.front == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        QNode<T> temp = this.front;
        do {
            stringBuilder.append(temp.getKey().toString() + ", ");
            temp = temp.getNext();
        } while (temp != null);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * This method puts an element at the front of the queue.
     *
     * @param key the new key
     */
    public void enqueueAtFront(T key) {
        QNode<T> temp = this.front;
        this.front = new QNode<T>(key);
        this.front.setNext(temp);
    }

}
