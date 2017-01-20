package rosalind;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class Graph {
    // Number of vertices
    public int V;
    // Number of edges
    public int E;
    // Array  of lists for Adjacency List Representation
    public LinkedList<Edge> adj[];

    // Constructor
    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adj[src].add(new Edge(src, dest));
    }
    void addEdge(int src, int dest, int weight) {
        adj[src].add(new Edge(src, dest, weight));
    }

    // Reverse graph, useful for finding strongly connected components
    Graph reverseGraph() {
        Graph reversedGraph = new Graph(this.V, this.E);
        int src, dest, weight;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                src = adj[i].get(j).src;
                dest = adj[i].get(j).dest;
                weight = adj[i].get(j).weight;
                reversedGraph.addEdge(dest, src, weight);
            }
        }
        return reversedGraph;
    }

    class Edge {
        int src, dest, weight;
        // For use in unweighted graph
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            this.weight = 1;
        }
        // For use in weighted graph
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
