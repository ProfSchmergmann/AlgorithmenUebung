package uebung04;

import org.apache.commons.collections4.list.TreeList;

import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        final long timeStart = System.currentTimeMillis();

        List<Integer> x = new TreeList<>();

        for (int i = 0; i < 1000000; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
            }
            x.add((x.size()) / 2, i);
        }

        final long timeEnd = System.currentTimeMillis();

        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek.");
    }

}
