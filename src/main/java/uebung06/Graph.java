package uebung06;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    // Speicherung als Adjazenzliste
    private ArrayList<Integer>[] adj;
    // Anzahl der Knoten
    private int vertexCount;
    // Anzahl der Kanten
    private int edgeCount;

    /**
     * Erzeugt leeren Graph mit den angegebenen Anzahl von Knoten
     *
     * @param v
     *            die Anzahl der Knoten
     */
    public Graph(int v) {
        adj = new ArrayList[v + 1];
        // Gleich die Eintraege belegen
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        vertexCount = v;
    }

    /**
     * Erzeugt Graph mit v Knoten und e zufaelligen Kanten
     *
     * @param v
     *            die Anzahl der Knoten
     * @param e
     *            die Anzahl der zufaelligen Kanten
     */
    public Graph(int v, int e) {
        this(v);
        for (int i = 0; i < e; i++) {
            int k1 = 0;
            int k2 = 0;
            do {
                k1 = (int) (Math.random() * v) + 1;
                k2 = (int) (Math.random() * v) + 1;
            } while (adj[k1].contains(k2));
            adj[k1].add(k2);
        }
        vertexCount = v;
        edgeCount = e;
    }

    /**
     * Erzeugt Graph aus der angegebenen Knotenliste
     *
     * @param list   die Knotenliste
     */
    public Graph(int[] list) {
        this(list[0]);
        for (int i = 0; i < list[1]; i++) {
            adj[list[2 + i * 2]].add(list[3 + i * 2]);
        }
        vertexCount = list[0];
        edgeCount = list[1];
    }

    /**
     * Erzeugt Graph aus der Adjazanzliste aus dem angegebenen InputStream Die
     * Eintraege in einer Zeile muessen durch Whitespaces getrennt sein.
     *
     * @param in
     *            InputStream fuer die Adjazenzmatrix
     */
    public Graph(InputStream in) {
        ArrayList<String> zeilen = new ArrayList<String>();
        Scanner sc = new Scanner(in);
        while (sc.hasNextLine()) {
            zeilen.add(sc.nextLine());
        }
        vertexCount = zeilen.size();
        adj = new ArrayList[vertexCount + 1];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new ArrayList<Integer>();
            String[] kanten = zeilen.get(i).split("\\s*");
            for (int j = 0; i < kanten.length; j++) {
                adj[i].add(Integer.parseInt(kanten[j]));
            }
            edgeCount += kanten.length;
        }
    }

    /**
     * Gibt die Anzahl der Knoten zurueck
     *
     * @return die Anzahl der Knoten
     */
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * Gibt die Anzahl der Kanten zurueck
     *
     * @return die Anzahl der Kanten
     */
    public int getEdgeCount() {
        return edgeCount;
    }

    /**
     * Fuegt eine Kante hinzu
     *
     * @param from
     *            Ausgangspunkt der Kante
     * @param to
     *            Zielpunkt der Kante
     */
    public void addEdge(int from, int to) {
        adj[from].add(to);
        edgeCount++;
    }

    /**
     * Gibt eine Liste mit allen direkten Nachfolgern des angegebenen Knotens
     * zurueck
     *
     * @param v
     *            der Knoten
     * @return die Liste der direkten Nachfolger der Knotens
     */
    public ArrayList<Integer> getAdjacent(int v) {
        return (ArrayList<Integer>) adj[v].clone();
    }

    public String toString() {
        String ret = "[";
        for (int i = 1; i < adj.length; i++) {
            ret = ret + adj[i];
        }
        ret = ret + "]";
        return ret;
    }

    /**
     * Durchläuft den Graphen mit Breitensuche und gibt die Elemente in der
     * durchlaufenen Reihenfolge zurueck.
     *
     * @param start
     *            Der Startknoten für die Breitensuche
     * @return Die Liste der durchlaufenen Knoten
     */
    public ArrayList<Integer> bfs(int start) {
        boolean[] visited = new boolean[this.vertexCount];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start]=true;
        /*Diese Funktion ist eine Hausaufgabe. Sie wird anschließend nachgereicht.
         */
        return null;
    }

    public static void main(String[] args) {
        int[] vlist = { 6, 10, 1, 5, 1, 4, 2, 3, 2, 6, 3, 4, 3, 5, 4, 5, 4, 6,
                5, 6, 6, 4 };
        Graph g = new Graph(vlist);
        System.out.println(g);
        g = new Graph(5, 20);
        System.out.println(g);
        g.bfs(1);
    }
}
