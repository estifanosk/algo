package algo.graph;

/**
 * Reachability of Graph G from vertex s
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private Graph graph;

    public DepthFirstSearch(Graph g,int s) {

        marked = new boolean[g.V()];
        this.graph=g;
        dfs(s);

    }

    private void dfs(int v) {
        marked[v]=true;

        for(int i: graph.adj(v)) {
            if (!marked[i]) {
                dfs(i);
            }
        }
    }

    /*
    is v connected to s
     */
    public boolean marked(int v){
        return marked[v];
    }

    /*
    how many vertices are connected with s.
     */
    public int count() {

        int count = 0;
        for (int i=0;i<marked.length;i++) {
            if (marked[i]) count++;
        }

        return count-1;
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

        DepthFirstSearch search = new DepthFirstSearch(g,0);
        System.out.println("# of vertices connected to 0  : " + search.count());
        System.out.println("3 connectdd to 0?"+ search.marked[3]);
        System.out.println("7 connectdd to 0?"+ search.marked[7]);
    }
}
