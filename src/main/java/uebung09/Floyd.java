package uebung09;


public class Floyd {

    public static int U = Integer.MAX_VALUE / 3;

    public static void main(String[] args) {

        int[][] a = {
                {0, 2, 3, U},
                {2, 0, 5, 1},
                {3, 5, 0, 7},
                {U, 1, 7, 0}};

        int[][] a2a = {
                {0, 4, 1, 9},
                {4, 0, 8, 1},
                {1, 8, 0, 1},
                {9, 1, 1, 0}};

        int[][] a2b = {
                {U, 5, 7, 1},
                {5, U, 1, 3},
                {7, 1, U, 9},
                {1, 3, 9, U}};

        int[][] a2c = {
                {U, 2, 6, 9},
                {9, U, 1, U},
                {6, U, U, 4},
                {1, 6, 8, U}};

        int[][] a2d = {
                {U, 8, U, -2},
                {U, U, 9, -4},
                {3, 3, U, U},
                {0, 8, U, U}};

        // floyd(a);
         floyd(a2a);
        // floyd(a2b);
        // floyd(a2c);
        // floyd(a2d);


    }

    /**
     * Funktion zur Ausgabe des Floyd-Algorithmus.
     * Die Funktion gibt nach jeder äußeren Schleife die P-Matrix zu dieser veränderten Matrix darunter aus.
     *
     * @param a die Matrix für den Floyd-Algorithmus
     */
    public static void floyd(int[][] a) {
        int[][] p = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (a[j][k] > a[j][i] + a[i][k]) {
                        a[j][k] = a[j][i] + a[i][k];
                        // i + 1 , damit zwischen keiner Veränderung und der 1 unterschieden werden kann
                        p[j][k] = i + 1;
                    }
                }
            }
            ausgabeFloydMatrix(a);
            System.out.println();
            ausgabeFloydMatrix(p);
            System.out.println();
        }
    }

    private static void ausgabeFloydMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == U) {
                    System.out.print(" ---");
                } else {
                    System.out.printf("%4d", a[i][j]);
                }
            }
            System.out.println();
        }
    }

}
