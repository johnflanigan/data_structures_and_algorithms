package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/29/16.
 */
public class SquareInAGraph {

    public static void squareInAGraph() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_sq.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();

        outerloop:
        for (int i = 0; i < numberOfGraphs; i++) {

            int V = s.nextInt();
            int E = s.nextInt();

            int[][] matrix = new int[V][V];
            int u, v;

            for (int j = 0; j < E; j++) {
                u = s.nextInt() - 1;
                v = s.nextInt() - 1;

                matrix[u][v] = 1;
                matrix[v][u] = 1;
            }

            // Check all pairs of vertices
            for (u = 0; u < V; u++) {
                for (v = u + 1; v < V; v++) {

                    // For a square in a graph, they must share to adjacent nodes
                    // Examine nodes adjacent to u
                    int shared = 0;
                    for (int j = 0; j < V; j++) {
                        if (matrix[u][j] == 1 && matrix[v][j] == 1) {
                            shared++;
                        }
                    }
                    if (shared == 2) {
                        System.out.print("1 ");
                        continue outerloop;
                    }
                }
            }
            System.out.print("-1 ");
        }
    }
}
