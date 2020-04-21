package uebung01;

/**
 * Class for the interpolation search algorithm.
 *
 * @author Sven Bergmann
 * @version 31.03.2020
 */
public class InterpolationSearch {

    /**
     * Static method for searching an element in a given, sorted array.
     *
     * @param arr the sorted array
     * @param x   the element
     * @return -1, if the element is not present in the given array,
     * the position, if the element was found
     */
    public static int interpolationSearch(int arr[], int x) {

        // Initializing the right and left variable of the array.
        int left = 0, right = (arr.length - 1);

        // While the element is still in range do stuff.
        while (left <= right && x >= arr[left] && x <= arr[right]) {
            if (left == right) {
                if (arr[left] == x) {
                    return left;
                }
                return -1;
            }

            // Calculate the position variable like in the wikipedia article.
            int pos = left + (((right - left) /
                    (arr[right] - arr[left])) * (x - arr[left]));

            // Return position variable if the element is found.
            if (arr[pos] == x) {
                return pos;
            }

            // If the element is not found manipulate the right and left variable.
            if (arr[pos] < x) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        // If the code hasn't returned any variable yet, return -1 for element not found.
        return -1;
    }
}
