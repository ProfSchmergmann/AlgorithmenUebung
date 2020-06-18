package uebung12;

import java.util.ArrayList;

public class NFA {

    private int startknoten;
    private int zielknoten;
    private ArrayList<Kante>[] adjazenzliste;


    public NFA(int knotenanzahl, int startknoten, int zielknoten) {
        adjazenzliste = new ArrayList[knotenanzahl + 1];  //Knoten 0 ist Dummy
        for (int i = 0; i <= knotenanzahl; i++) {
            adjazenzliste[i] = new ArrayList<>();
        }
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;
    }

    public void addKante(int start, int ziel, char zeichen) {
        adjazenzliste[start].add(new Kante(zeichen, ziel));
    }

    public boolean testString(String s) {
        boolean[] besetzt = new boolean[adjazenzliste.length];
        boolean[] besetztTemp = new boolean[adjazenzliste.length];
        besetzt[startknoten] = true;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            for (int j = 1; j < besetzt.length; j++) {
                if (besetzt[j]) {
                    for (int k = 0; k < adjazenzliste[j].size(); k++) {
                        if (adjazenzliste[j].get(k).c == temp) {
                            besetztTemp[adjazenzliste[j].get(k).ziel] = true;
                        }
                    }
                    besetzt[j] = false;
                }
            }
            for (int k = 0; k < besetzt.length; k++) {
                if (besetztTemp[k]) {
                    besetzt[k] = true;
                }
                besetztTemp[k] = false;
            }
        }
        return besetzt[zielknoten];
    }

    public static void main(String[] args) {
        NFA nfa_test = new NFA(3, 1, 3);
        nfa_test.addKante(1, 2, 'a');
        nfa_test.addKante(1, 3, 'a');
        nfa_test.addKante(2, 2, 'a');
        nfa_test.addKante(2, 2, 'b');
        nfa_test.addKante(2, 3, 'a');
        System.out.println(nfa_test.testString("abba")); // true
        System.out.println(nfa_test.testString("a")); // true
        System.out.println(nfa_test.testString("ab")); // false

    }
}

class Kante {
    public char c;
    public int ziel;

    public Kante(char c, int ziel) {
        this.c = c;
        this.ziel = ziel;
    }
}
