package algo.graph;

import java.util.Stack;

/**
 * Find path to vertex v from vertex s in graph G using DFS
 */
public class DepthFirstPath {

    private Integer[] edgeTo;
    private boolean[] marked;
    private Graph graph;

    public DepthFirstPath(Graph g, int s) {

        edgeTo = new Integer[g.V()];
        marked = new boolean[g.V()];
        graph = g;

        dfs(s);
    }

    private void dfs(int v) {

        marked[v] = true;
        for (int i: graph.adj(v) ) {
            if (!marked[i])  {
                edgeTo[i] = v;
                dfs(i);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

        Stack<Integer> s = new Stack<Integer>();

        Integer x = v;
        s.push(x);

        while (edgeTo[x]!=null) {
            x= edgeTo[x];
            s.push(x);
        }

        return s;
    }

    public static void main(String[] args) {
        Graph g=new Graph(13);

        g.addEdge(0,5);
        g.addEdge(4,3);
        g.addEdge(0,1);
        g.addEdge(9,12);
        g.addEdge(6,4);
        g.addEdge(5,4);
        g.addEdge(0,2);
        g.addEdge(11,12);
        g.addEdge(9,10);
        g.addEdge(0,6);
        g.addEdge(7,8);
        g.addEdge(9,11);
        g.addEdge(5,3);

        assert(g.E()==13);

        DepthFirstPath path = new DepthFirstPath(g,0);
        System.out.println("has path to 5?: "+ path.hasPathTo(5));
        System.out.println("path to 5: "+ path.pathTo(5));
        System.out.println("has path to 4?: "+ path.hasPathTo(4));
        System.out.println("path to 4 : "+ path.pathTo(4));

        System.out.println("has path to 7?: "+ path.hasPathTo(7));
    }
}
