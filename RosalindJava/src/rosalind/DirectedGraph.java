package rosalind;

import java.util.ArrayList;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class DirectedGraph {
    int[] vertices;

    public DirectedGraph(int size) {
        this.vertices = new int[size];
    }

    class Node {
        int value;
        int predecessor;
        int distance;
        ArrayList<Integer> edges;

        Node(int value) {
            this.value = value;
            distance = 1000;
            predecessor = -1;



        }
    }
}
