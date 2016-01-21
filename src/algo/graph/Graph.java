package algo.graph;

/**
 * Graph data structure with E edges and V vertices.
 */

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int V;

    private int E;

    private List<Integer>[] adj;

    public Graph(int v) {
        this.V=v;
        this.E=0;

        this.adj=(List<Integer>[]) new List[v];

        for(int i=0;i<V;i++){
            this.adj[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);

        this.E++;
    }

    public Iterable<Integer> adj(int v){
        return this.adj[v];
    }
}


