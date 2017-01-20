package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/27/16.
 */
/*
public class NegativeWeightCycle {

    public void negativeWeightCycle() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_nwc.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();

        for (int k = 0; k < numberOfGraphs; k++) {

            int numberOfVertices = s.nextInt();
            int numberOfEdges = s.nextInt();
            Graph graph = new Graph(numberOfVertices, numberOfEdges);

            int src, dest, weight;
            for (int i = 0; i < numberOfEdges; i++) {
                src = s.nextInt() - 1;
                dest = s.nextInt() - 1;
                weight = s.nextInt();
                graph.edge[i].src = src;
                graph.edge[i].dest = dest;
                graph.edge[i].weight = weight;
            }

            int[] distance = new int[numberOfVertices];
            boolean[] visited = new boolean[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                distance[i] = 100000;
            }
            distance[0] = 0;

            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfEdges; j++) {
                    src = graph.edge[j].src;
                    dest = graph.edge[j].dest;
                    weight = graph.edge[j].weight;
                    if (distance[src] + weight < distance[dest]) {
                        distance[dest] = distance[src] + weight;
                    }
                }
            }

            boolean negativeCycle = false;
            for (int i = 0; i < numberOfEdges; i++) {
                src = graph.edge[i].src;
                dest = graph.edge[i].dest;
                weight = graph.edge[i].weight;
                if (distance[src] + weight < distance[dest]) {
                    System.out.print("1 ");
                    negativeCycle = true;
                    break;
                }
            }
            if (!negativeCycle) {
                System.out.print("-1 ");
            }
        }
    }
}
*/
