import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

interface DirectedEdge {
    int from();
    int to();
    int weight();
}

interface EdgeWeightedDigraph {
    //the num of vertexes
    int V();
    //return list of adjacent edges
    List<DirectedEdge> adj(int v);
}

public class Dijkstra {
    private DirectedEdge[] edgeTo;
    private int[] distTo;

    //Min heap of [vertex, distance]
    private PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    public Dijkstra(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;

        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int vertex[] = pq.remove();
            int vertexId = vertex[0];
            for (DirectedEdge e : G.adj(vertexId))
                relax(e);
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            // update this new vertex in PQ
            int[] vertexToUpdate = new int[]{w, distTo[w]};
            pq.remove(vertexToUpdate);
            pq.add(vertexToUpdate);
        }
    }
}
