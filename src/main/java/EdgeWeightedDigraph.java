import java.util.List;

interface EdgeWeightedDigraph {
    //the num of vertexes
    int V();
    //return list of adjacent edges
    List<DirectedEdge> adj(int v);
}
