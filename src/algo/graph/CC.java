package algo.graph;

/**
 * Find connected components in a graph G.
 */
public class CC {

    int count;
    private int[] id;
    private boolean[] marked;
    private Graph g;

    public CC(Graph g) {

        marked = new boolean[g.V()];
        id = new int[g.V()];
        this.g=g;

        for (int v=0;v<g.V();v++) {
            if (!marked[v]) {
                dfs(v);
                count++;
            }
        }
    }

    /*
    Mark component id
     */
    private void dfs(int v) {

        marked[v] = true;
        id[v] = count;

        for(int i: g.adj(v)) {
            if (!marked[i])
                dfs(i);
        }
    }

    /*
    Returns the # of components.
     */
    public int count() {
        return count+1;
    }

    /*
    Returns the component id
     */
    public int id(int v) {
        return id[v];
    }

    /*
    Identifies if two vertices are connected
     */
    public boolean isConnected(int v , int w) {
        return id[v] == id[w];
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

        CC cc = new CC(g);
        System.out.println("component count : " + cc.count );
        System.out.println("is connected [0,7]?"+ cc.isConnected(0,7));
        System.out.println("is connected [1,4]?" + cc.isConnected(1,4));
        System.out.println("is connected [7,8]?" + cc.isConnected(7,8));


    }
}
