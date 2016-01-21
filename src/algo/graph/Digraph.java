package algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed graph.
 */
public class Digraph {

    private final int V;
    private int E;

    private List<Integer>[] adj;

    public Digraph(int v) {
        this.V=v;
        this.adj = (ArrayList<Integer>[]) new List[V];

        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /*
    Add edge.
    */
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        E++;
    }

    /*
    Return adjacent vertices
    */
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /*
    Reverse a graph
    */
    public void reverse(){
        //TODO: Implement
    }

    public String toString() {
        //TODO: Implement
        return null;
    }
}
