package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/28/16.
 */
public class SemiConnectedGraph {
    /*

    public static void semiConnectedGraph() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_sc.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();

        outerloop:
        for (int i = 0; i < numberOfGraphs; i++) {

            int V = s.nextInt();
            int E = s.nextInt();

            Graph graph = new Graph(V, E);

            int to, from;
            for (int j = 0; j < E; j++) {
                to = s.nextInt() - 1;
                from = s.nextInt() - 1;
                graph.addEdge(to, from, 1);
            }

            int src, dest;
            Graph.Edge currentEdge;

            int[][] distance = new int[V][V];
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    distance[j][k] = 10000;
                }
            }
            for (int j = 0; j < V; j++) {
                distance[j][j] = 0;
            }
            for (int j = 0; j < E; j++) {
                currentEdge = graph.edges.get(j);
                src = currentEdge.src;
                dest = currentEdge.dest;
                distance[src][dest] = 1;
            }

            for (int z = 0; z < V; z++) {
                for (int x = 0; x < V; x++) {
                    for (int y = 0; y < V; y++) {
                        if (distance[x][y] > distance[x][z] + distance[z][y])
                            distance[x][y] = distance[x][z] + distance[z][y];
                    }
                }
            }

            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (distance[j][k] == 10000 && distance[k][j] == 10000) {
                        System.out.print("-1 ");
                        continue outerloop;
                    }
                }
            }
            System.out.print("1 ");
        }
    }
    */
}
