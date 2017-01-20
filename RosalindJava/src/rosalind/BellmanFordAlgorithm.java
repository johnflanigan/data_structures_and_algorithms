package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class BellmanFordAlgorithm {

    public static void bellmanFordAlgorithm() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_bf.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size = s.nextInt();

        int[][] adjacenceMatrix = new int[size][size];

        int numberOfEdges = s.nextInt();
        int to, from, weight;
        for (int i = 0; i < numberOfEdges; i++) {
            to = s.nextInt() - 1;
            from = s.nextInt() - 1;
            weight = s.nextInt();
            adjacenceMatrix[to][from] = weight;
        }

        int[] distance = new int[size];

        for (int i = 0; i < size; i++) {
            distance[i] = 100000;
        }

        distance[0] = 0;

        // Repeat for number of vertices
        for (int i = 0; i < size; i++) {
            // Check all vertices in matrix
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjacenceMatrix[u][v] != 0) {
                        int w = adjacenceMatrix[u][v];
                        if (distance[u] + w < distance[v] && distance[u] != 100000) {
                            distance[v] = distance[u] + w;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (distance[i] != 100000) {
                System.out.print(distance[i] + " ");
            } else {
                System.out.print("x ");
            }
        }
    }
}
