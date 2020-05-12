package uebung07;

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
     * @param v die Anzahl der Knoten
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
     * @param v die Anzahl der Knoten
     * @param e die Anzahl der zufaelligen Kanten
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
     * Erzeugt Graph aus der angegebenen Kantenliste
     *
     * @param list die Kantenliste
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
     * @param in InputStream fuer die Adjazenzmatrix
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
     * @param from Ausgangspunkt der Kante
     * @param to   Zielpunkt der Kante
     */
    public void addEdge(int from, int to) {
        adj[from].add(to);
        edgeCount++;
    }

    /**
     * Gibt eine Liste mit allen direkten Nachfolgern des angegebenen Knotens
     * zurueck
     *
     * @param v der Knoten
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
     * Gibt den Graphen als Kantenliste zurueck
     *
     * @return Graph als Kantenliste
     */
    public ArrayList<Integer> getEdgeList() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(vertexCount);
        integerArrayList.add(edgeCount);
        for (int i = 1; i < adj.length; i++) {
            if (!adj[i].isEmpty()) {
                for (int j : adj[i]) {
                    integerArrayList.add(i);
                    integerArrayList.add(j);
                }
            }
        }
        return integerArrayList;
    }

    /**
     * Gibt den Graphen als Knotenliste zurueck
     *
     * @return Graph als Knotenliste
     */
    public ArrayList<Integer> getVertexList() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(vertexCount);
        integerArrayList.add(edgeCount);
        for (int i = 1; i < adj.length; i++) {
            if (!adj[i].isEmpty()) {
                integerArrayList.add(adj[i].size());
                integerArrayList.addAll(adj[i]);
            } else {
                integerArrayList.add(0);
                integerArrayList.add(0);
                integerArrayList.add(0);
            }
        }
        return integerArrayList;
    }

    /**
     * Gibt den Graphen als Adjazenzmatrix zurueck.
     *
     * @return Graph als Adjazenzmatrix
     */
    public int[][] getAdjacencyMatrix() {
        // Initialize temp array with zeros.
        int[][] temp = new int[vertexCount][vertexCount];
        for (int i = 1; i < adj.length; i++) {
            if (!adj[i].isEmpty()) {
                for (int j : adj[i]) {
                    temp[i - 1][j - 1] = 1;
                }
            }
        }
        return temp;
    }

    /**
     * Durchläuft den Graphen mit Breitensuche und gibt die Elemente in der
     * durchlaufenen Reihenfolge zurueck.
     *
     * @param start Der Startknoten für die Breitensuche
     * @return Die Liste der durchlaufenen Knoten
     */
    public ArrayList<Integer> bfs(int start) {
        boolean[] visited = new boolean[this.vertexCount + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.pollFirst();
            if (!visited[temp]) {
                queue.addAll(adj[temp]);
                integerArrayList.add(temp);
                visited[temp] = true;
            }
        }
        return integerArrayList;
    }

    /**
     * Durchlaeuft den Graphen mit Tiefensuche und gibt eine Liste der
     * Knoten in durchlaufener Reihenfolge zurueck.
     *
     * @param start Startknoten
     * @return Die Liste der durchlaufenen Knoten
     */
    public ArrayList<Integer> dfs(int start) {
        boolean[] visited = new boolean[this.vertexCount + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.peek();
            if (!visited[temp]) {
                integerArrayList.add(temp);
                if (!adj[temp].isEmpty()) {
                    for (int i : adj[temp]) {
                        if (!visited[i]) {
                            queue.add(i);
                            break;
                        }
                    }
                }
                visited[temp] = true;
            } else {
                queue.poll();
            }
        }
        return integerArrayList;
    }

    /**
     * Gibt die Liste aller Knoten zurueck, die vom Knoten start aus
     * nicht erreichbar sind.
     * Benutzt dafuer die Breitensuche.
     *
     * @param start der Startknoten
     * @return Die Liste der unereichbaren Knoten
     */
    public ArrayList<Integer> getUnreachableVertices(int start) {
        ArrayList<Integer> bfs = this.bfs(start);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        boolean[] temp = new boolean[vertexCount + 1];
        for (int i : bfs) {
            temp[i] = true;
        }
        for (int i = 1; i < temp.length; i++) {
            if (!temp[i]) {
                integerArrayList.add(i);
            }
        }
        return integerArrayList;
    }

    /**
     * Gibt zurueck, ob der Graph gerichtet (true) oder ungerichtet (false) ist.
     * Die Methode prueft die Matrix auf Symmetrie und gibt true zurueck,
     * falls die Matrix symmetrisch und der Graph damit ungerichtet ist.
     *
     * @return true oder false
     */
    public boolean isDirected() {
        int[][] temp = this.getAdjacencyMatrix();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] != temp[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gibt ein Feld mit den Entfernungen aller Knoten zum Start-Knoten zurueck.
     * Das Feldelement 0 (Dummy-Knoten) soll den Wert -2 erhalten.
     * Alle nicht erreichbaren Knoten erhalten den Wert -1.
     * Der Startknoten selbst erhält den Wert 0.
     * Alle anderen Feldelemente erhalten die Anzahl der Kanten
     * der kürzesten Wegstrecke vom Startknoten zum entsprechenden Knoten.
     *
     * @param start der Startknoten
     * @return die Distanz aller Knoten zum Startknoten in einem int Array
     */
    public int[] getDistances(int start) {
        int[] temp = new int[vertexCount + 1];
        temp[0] = -2;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = this.getDistanceWithBfs(start, i);
        }
        temp[start] = 0;
        return temp;
    }

    /**
     * Methode fuer die Berechnung der Distanz mit der Breitensuche.
     *
     * @param start der Startknoten
     * @param end   der Endknoten
     * @return die Distanz in int
     */
    private int getDistanceWithBfs(int start, int end) {
        boolean[] visited = new boolean[this.vertexCount + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int distance = 0;
        while (!queue.isEmpty()) {
            int temp = queue.pollFirst();
            if (!visited[temp]) {
                queue.addAll(adj[temp]);
                visited[temp] = true;
                distance++;
            }
            if (temp == end) {
                return distance;
            }
        }
        return -1;
    }

    /**
     * Versucht, den Graphen in zwei Farben einzufärben (1 und 2),
     * wobei angrenzende Knoten nicht in derselben Farbe eingefärbt sein dürfen.
     * Falls das nicht möglich ist (der Graph ist nicht bipartit),
     * wird null zurückgegeben.
     * Für die Kürze hat der Code eine beachtliche Schachtelungstiefe.
     *
     * @return int-Feld
     */
    public int[] getColours() {
        int[] ret = new int[this.getVertexCount() + 1];
        for (int k = 1; k < ret.length; k++) {                  //Schleife 1
            if (ret[k] == 0) {
                ret[k] = 1;
                for (int i = 1; i < ret.length - 1; i++) {      //Schleife 2
                    boolean changed = false;
                    for (int j = 0; j < ret.length; j++) {      //Schleife 3
                        if (ret[j] > 0) {
                            int other = 3 - ret[j];
                            for (int next : adj[j]) {           //Schleife 4
                                if (ret[next] == 0) {
                                    ret[next] = other;
                                    changed = true;
                                } else if (ret[next] != other) {
                                    return null;
                                }
                            }
                        }
                    }
                    if (!changed) break;
                }
            }
        }
        return ret;
    }

}
