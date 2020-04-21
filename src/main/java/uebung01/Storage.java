package uebung01;

/**
 * Improved class uebung01.uebung01.Storage.
 *
 * @author Sven Bergmann
 * @version 31.03.2020
 */
public class Storage<T> {
    private T[] speicher = (T[]) new Object[10];
    // Counter for saving the number of elements stored.
    private int count = 0;

    /**
     * Method for checking if the storage is empty.
     *
     * @return true, if it is empty,
     * false, otherwise.
     */
    public boolean isEmpty() {
        return speicher.length == 0;
    }

    /**
     * Method for adding an element to the storage.
     * If the array stored as attribute in storage is not big enough,
     * the old array will be copied to a new one with the old length times two.
     *
     * @param item the item to add
     */
    public void add(T item) {
        if (!isEmpty()) {
            if (count == speicher.length) {
                T[] tempArray = (T[]) new Object[speicher.length * 2];

                for (int i = 0; i < speicher.length; i++) {
                    tempArray[i] = speicher[i];
                }
                speicher = tempArray;
            }
            speicher[count] = item;
            count++;
        } else {
            speicher = (T[]) new Object[speicher.length + 1];
            speicher[0] = item;
        }
    }

    /**
     * Method for getting the requested element with the given index.
     *
     * @param index the index of the element
     * @return the element at the given index
     */
    public T get(int index) {
        if (index >= 0 && index < speicher.length) {
            return speicher[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Couldn't find index!");
        }
    }

    /**
     * A toString method which returns a String like for example:
     * "Index 1: one "
     *
     * @return a String
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("Index " + i + ": " + speicher[i].toString() + " ");
        }
        return stringBuilder.toString();
    }

    /**
     * Main method for testing the class.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Storage<String> st = new Storage<>();
        for (int i = 0; i < 30; i++) {
            st.add("Test" + i + 1);
            System.out.println(st);
        }
    }
}
