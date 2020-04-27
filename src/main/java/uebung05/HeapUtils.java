package uebung05;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapUtils {

    public static int[] getLargestKElements(int[] list, int k) {
        // Constructor of q which creates a new PriorityQueue
        // The elements in this queue are sorted by the biggest element at the top
        // You could change it by using y-x
        PriorityQueue<Integer> q = new PriorityQueue<>((Integer x, Integer y) -> x - y);
        // This loop fills the queue q with the element from the given list
        for (int i = 0; i < k; i++) {
            q.add(list[i]);
        }
        // After this loop the k biggest element remain inside the queue
        for (int i = k; i < list.length; i++) {
            if (list[i] > q.peek()) {
                q.poll();
                q.add(list[i]);
            }
        }
        // The method then returns an array which is created out of a stream which was mapped to int values
        return q.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] test = new int[20];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(getLargestKElements(test, 3)));
    }

}

/**
 * The add Method of PriorityQueue provides O(Log(n)) time complexity.
 * The poll Method also provides O(Log(n)) time complexity.
 * The peek method provides constant time complexity.
 * So all in all the time complexity of this algorithm is O( k + (n-k)(Log(k) + (k)Log(k) )
 */
