package uebung02;

import java.util.ArrayList;

/**
 * Class HashSet with a improved hashCode method.
 *
 * @param <T>
 * @author Sven Bergmann
 * @version 07.04.2020
 */
public class MyHashSet<T> {

    // Initial size for the HashSet = 5.
    private ArrayList<T>[] hash = new ArrayList[5];

    // Counter for the number of elements
    private int count = 0;


    /**
     * This method adds a new element to the HashSet.
     *
     * @param element the new element
     */
    public void add(T element) {

        if (!contains(element)) {
            count++;
        }

        // If the fill level is bigger than 2, resort the field.
        if (((double) count / hash.length) > 2) {
            ArrayList<T>[] temp = new ArrayList[hash.length * 2];
            for (ArrayList<T> arrayList : hash) {
                if (arrayList != null) {
                    for (T t : arrayList) {
                        addInternal(t, temp);
                    }
                }
            }
            hash = temp;
        }

        // Add the new element.
        addInternal(element, hash);
    }

    /**
     * Method for not duplicating code in the add method.
     *
     * @param element   the element to be saved
     * @param arrayList the list in which the element should be saved
     */
    private void addInternal(T element, ArrayList<T>[] arrayList) {
        // Get the hashCode
        int x = getHash(element);

        // Create a new ArrayList if the bucket is empty.
        if (arrayList[x] == null) {
            arrayList[x] = new ArrayList<T>();
        }

        // Just add the element if the HashTable not already contains it.
        if (!arrayList[x].contains(element)) {
            arrayList[x].add(element);
        }
    }

    /**
     * Method for calculating the HashCode.
     *
     * @param element the element
     * @return the hash
     */
    private int getHash(T element) {
        return Math.abs(element.hashCode() % hash.length);
    }

    /**
     * Method for deleting an element in this HashSet.
     *
     * @param element the element to be deleted
     * @return true, if the HashSet contained the element, false otherwise
     */
    public boolean delete(T element) {
        int x = getHash(element);
        if (hash[x] == null) {
            return false;
        } else {
            return hash[x].remove(element);
        }
    }

    /**
     * Method for checking if the HashSet contains the element.
     *
     * @param element the element to check
     * @return true, if it contains it, false otherwise
     */
    public boolean contains(T element) {
        int x = getHash(element);
        if (hash[x] == null) {
            return false;
        } else {
            return hash[x].contains(element);
        }
    }

    /**
     * A toString method for returning a String like [element1, element2, ...].
     *
     * @return the String
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (ArrayList<T> arrayList : hash) {
            if (arrayList != null) {
                for (T t : arrayList) {
                    stringBuilder.append(t.toString());
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public static void hashTest() {
        MyHashSet<Integer> h = new MyHashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 10);
            h.add(x);
            System.out.println(x + ": " + h);
        }
        MyHashSet<Double> t = new MyHashSet<Double>();

        long zeit = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            t.add(Math.random());
        }
        System.out.println("Zeit[s]: " + (System.nanoTime() - zeit) / 1000000000.);

    }

    public static void main(String[] args) {
        hashTest();
    }


}
