public class WeightedQuickUnionWithCompaction {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionWithCompaction(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pr = root(p);
        int qr = root(q);
        if (pr == qr) return;
        if (sz[pr] < sz[qr]) {
            id[p] = qr;
            sz[qr] += sz[pr];
        } else {
            id[q] = pr;
            sz[pr] += sz[qr];
        }
    }
}
