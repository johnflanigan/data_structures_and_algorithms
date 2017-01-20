package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/29/16.
 */
public class ShortestCycleThroughAGivenEdge {
    /*

    public static void shortestCycleThroughAGivenEdge() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_cte.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();

        for (int i = 0; i < numberOfGraphs; i++) {

            int V = s.nextInt();
            int E = s.nextInt();

            Graph graph = new Graph(V, E);
            int src, dest, weight;
            int begin, end;

            // Given edge
            begin = s.nextInt() - 1;
            end = s.nextInt() - 1;
            weight = s.nextInt();
            graph.addEdge(begin, end, weight);

            for (int j = 0; j < E - 1; j++) {
                src = s.nextInt() - 1;
                dest = s.nextInt() - 1;
                weight = s.nextInt();
                graph.addEdge(src, dest, weight);
            }

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
                weight = currentEdge.weight;
                distance[src][dest] = weight;
            }

            for (int z = 0; z < V; z++) {
                for (int x = 0; x < V; x++) {
                    for (int y = 0; y < V; y++) {
                        if (distance[x][y] > distance[x][z] + distance[z][y])
                            distance[x][y] = distance[x][z] + distance[z][y];
                    }
                }
            }

            if (distance[begin][end] == 10000 || distance[end][begin] == 10000) {
                System.out.print("-1 ");
            } else {
                int result = distance[begin][end] + distance[end][begin];
                System.out.print(result + " ");
            }
        }
    }
    */
}
