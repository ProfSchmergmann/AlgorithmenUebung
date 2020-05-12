package uebung07;

import java.util.Arrays;

public class GraphTest {

    public static void main(String[] args) {
        int[] vlist = {6, 10, 1, 5, 1, 4, 2, 3, 2, 6, 3, 4, 3, 5, 4, 5, 4, 6,
                5, 6, 6, 4};
        System.out.println("Eingabe:");
        System.out.println(Arrays.toString(vlist));
        Graph g = new Graph(vlist);
        System.out.println("Graph mit toString Methode:");
        System.out.println(g);
        System.out.println("Kantenliste:");
        System.out.println(g.getEdgeList());
        System.out.println("Knotenliste:");
        System.out.println(g.getVertexList());
        System.out.println("Adjazenzmatrix:");
        final int[][] matrix = g.getAdjacencyMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int x = 1; x < 3; x++) {
            System.out.println("Liste der Breitensuche ab " + x + ":");
            System.out.println(g.bfs(x));
            System.out.println("Liste der Tiefensuche ab " + x + ":");
            System.out.println(g.dfs(x));
            System.out.println("Liste der unerreichbaren Knoten ab " + x + ":");
            System.out.println(g.getUnreachableVertices(x));
            System.out.println("Liste der Entfernungen der Knoten von " + x + ":");
            System.out.println(Arrays.toString(g.getDistances(x)));
        }
        System.out.println("Der Graph ist " + (g.isDirected() ? "gerichtet" : "ungerichtet") + ".");
        System.out.println();
        System.out.println("Neuer zufaelliger Graph:");
        g = new Graph(5, 20);
        System.out.println(g);
        g.bfs(1);

    }

}
