import java.util.LinkedList;


public class BellmanFord {
    private int[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQueue;
    private LinkedList<Integer> queue;

    public BellmanFord(EdgeWeightedDigraph G, int s) {
        distTo = new int[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQueue = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;

        queue = new LinkedList<>();
        queue.addLast(s);
        onQueue[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            onQueue[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (!onQueue[w]) {
                    queue.addLast(w);
                    onQueue[w] = true;
                }
            }
        }
    }
}
