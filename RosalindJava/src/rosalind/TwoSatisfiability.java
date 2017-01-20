package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by johnflanigan on 11/30/16.
 */
public class TwoSatisfiability {

    Stack<Integer> stack;
    boolean[] visited;
    LinkedList<Integer>[] components;

    public void twoSatisfiability() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_2sat.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();

        for (int k = 0; k < numberOfGraphs; k++) {

            int n, m;
            n = s.nextInt();
            m = s.nextInt();

            TwoSatGraph graph = new TwoSatGraph(n, m);

            int src, dest;
            for (int i = 0; i < graph.m; i++) {
                src = s.nextInt();
                dest = s.nextInt();
                graph.addEdge(src, dest);
            }

            visited = new boolean[graph.V];
            stack = new Stack<Integer>();

            int current = 0;
            for (int i = 0; i < graph.V; i++) {
                if (!visited[i]) {
                    visit(graph, i);
                }
            }

            TwoSatGraph reversedGraph = graph.reverseGraph();
            for (int i = 0; i < reversedGraph.V; i++) {
                visited[i] = false;
            }

            components = new LinkedList[reversedGraph.V];
            int index = 0;
            while (!stack.isEmpty()) {
                current = stack.pop();
                if (!visited[current]) {
                    components[index] = new LinkedList<>();
                    assign(current, components[index], reversedGraph);
                    index++;
                }
            }

            // Check components for positive and negative
            boolean isSatisfied = true;
            for (int i = 0; i < index; i++) {
                for (int j = 1; j < graph.n; j++) {
                    if (components[i].contains(j) && components[i].contains(-j)) {
                        isSatisfied = false;
                    }
                }
            }

            boolean[] truth = new boolean[reversedGraph.V];
            for (int i = 0; i < reversedGraph.V; i++) {
                visited[i] = false;
                truth[i] = false;
            }

            ArrayList<Integer> unsorted = new ArrayList<Integer>();
            ArrayList<Integer> sorted = new ArrayList<Integer>();
            if (isSatisfied) {
                for (int i = index - 1; i >= 0; i--) {
                    // If this component has not been visited
                    current = graph.getIndex(components[i].get(0));
                    if (!visited[current]) {
                        for (int j = 0; j < components[i].size(); j++) {
                            // Set all members to true
                            current = graph.getIndex(components[i].get(j));
                            visited[current] = true;
                            truth[current] = true;
                            // Set complement to false
                            int complement = graph.getComplementIndex(current);
                            visited[complement] = true;
                            truth[complement] = false;
                        }
                    }
                }
                System.out.print("1 ");
                for (int i = 0; i < truth.length; i++) {
                    if (truth[i]) {
                        unsorted.add(graph.getValue(i));
                    }
                }
                while (!unsorted.isEmpty()) {
                    // Find absolute value min
                    int minIndex = 0;
                    int currentMin, toCompare;
                    for (int i = 0; i < unsorted.size(); i++) {
                        currentMin = Math.abs(unsorted.get(minIndex));
                        toCompare = Math.abs(unsorted.get(i));
                        if (toCompare < currentMin) {
                            minIndex = i;
                        }
                    }
                    int smallest = unsorted.get(minIndex);
                    unsorted.remove(minIndex);
                    sorted.add(smallest);
                }
                for (int i = 0; i < sorted.size(); i++) {
                    System.out.print(sorted.get(i) + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("0\n");
            }
        }
    }

    public void visit(TwoSatGraph graph, int u) {
        int v;
        if (!visited[u]) {
            visited[u] = true;
            for (int i = 0; i < graph.adj[u].size(); i++) {
                v = graph.adj[u].get(i);
                if (!visited[v]) {
                    visit(graph, v);
                }
            }
            stack.push(u);
        }
    }

    public void assign(int u, LinkedList<Integer> list, TwoSatGraph reversedGraph) {
        int value;
        if (!visited[u]) {
            visited[u] = true;
            value = reversedGraph.getValue(u);
            list.add(value);
            int v;
            for (int i = 0; i < reversedGraph.adj[u].size(); i++) {
                v = reversedGraph.adj[u].get(i);
                assign(v, list, reversedGraph);
            }
        }
    }

    class TwoSatGraph {
        // Number of variables
        public int n;
        // Number of clauses
        public int m;
        // Number of vertices
        public int V;
        // Number of edges
        public int E;
        // Array of adjacent vertices.
        public LinkedList<Integer> adj[];

        // Constructor
        TwoSatGraph(int n, int m) {
            this.n = n;
            this.m = m;
            this.V = n * 2;
            this.E = m * 2;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList();
            }
        }

        int getIndex(int value) {
            if (value < 0) {
                return value + n;
            } else {
                return value + n - 1;
            }
        }

        int getValue(int index) {
            int value = index - n;
            if (value >= 0) {
                value++;
            }
            return value;
        }

        int getComplementIndex(int index) {
            int temp = getValue(index);
            int result = getIndex(-temp);
            return result;
        }

        // Function to add an edge into the graph. Input is by value.
        void addEdge(int src, int dest) {
            int u, v;
            // Add edge from src to dest
            u = getIndex(-src);
            v = getIndex(dest);
            adj[u].add(v);
            // Add edge from -dest to src
            u = getIndex(-dest);
            v = getIndex(src);
            adj[u].add(v);
        }

        // Reverse graph, useful for finding strongly connected components
        TwoSatGraph reverseGraph() {
            TwoSatGraph reversedGraph = new TwoSatGraph(this.n, this.m);
            int src, dest;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    src = i;
                    dest = adj[i].get(j);
                    reversedGraph.adj[dest].add(src);
                }
            }
            return reversedGraph;
        }
    }
}
