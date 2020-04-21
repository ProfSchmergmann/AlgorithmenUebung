package uebung02;

/**
 * Class for testing the queue class.
 *
 * @author Sven Bergmann
 * @version 06.04.2020
 */
public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();
        integerMyQueue.enqueue(10);
        integerMyQueue.enqueue(20);
        integerMyQueue.enqueue(30);
        integerMyQueue.enqueue(40);
        integerMyQueue.enqueue(50);
        integerMyQueue.enqueueAtFront(2134);
        System.out.println(integerMyQueue.toString());
        integerMyQueue.dequeue();
        System.out.println(integerMyQueue.toString());
        integerMyQueue.clear();
        System.out.println(integerMyQueue.toString());

        MyQueue<String> stringMyQueue = new MyQueue<>();
        stringMyQueue.enqueue("10");
        stringMyQueue.enqueue("20");
        stringMyQueue.enqueue("30");
        stringMyQueue.enqueue("40");
        stringMyQueue.enqueue("50");
        stringMyQueue.enqueueAtFront("2134");
        System.out.println(stringMyQueue.toString());
        stringMyQueue.dequeue();
        System.out.println(stringMyQueue.toString());
        stringMyQueue.clear();
        System.out.println(stringMyQueue.toString());
    }
}
