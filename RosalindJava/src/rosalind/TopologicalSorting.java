package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/29/16.
 */
public class TopologicalSorting {

    public static void topologicalSorting() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_ts.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int V, E;
        V = s.nextInt();
        E = s.nextInt();

        int[][] adjacent = new int[V][V];

        int src, dest;
        for (int i = 0; i < E; i++) {
            src = s.nextInt() - 1;
            dest = s.nextInt() - 1;
            adjacent[src][dest] = 1;
        }

        ArrayList<Integer> L = new ArrayList<Integer>();
        ArrayList<Integer> S = new ArrayList<Integer>();

        // Find source nodes
        int count;
        for (int u = 0; u < V; u++) {
            count = 0;
            for (int v = 0; v < V; v++) {
                if (adjacent[v][u] == 1) {
                    count++;
                }
            }
            if (count == 0) {
                S.add(u);
            }
        }

        int n;
        while (!S.isEmpty()) {
            n = S.remove(0);
            L.add(n);
            for (int m = 0; m < V; m++) {
                if (adjacent[n][m] == 1) {
                    count = 0;
                    adjacent[n][m] = 0;
                    for (int i = 0; i < V; i++) {
                        if (adjacent[i][m] == 1) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        S.add(m);
                    }
                }
            }
        }

        int current;
        while (!L.isEmpty()) {
            current = L.remove(0) + 1;
            System.out.print(current + " ");
        }
    }
}