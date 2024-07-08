package programmercarl.other;

public class findRedundantConnection {
    int n;
    int[] father = new int[1000 + 1];

    public void init(int n) {
        this.n = n;
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int u) {
        if (u == father[u]) {
            return u;
        }
        return father[u] = find(father[u]);
    }

    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 根进行连接 即不能用isSame简写,此时得到的不是u的根而是u本身
    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        init(n);
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            }
            join(edges[i][0], edges[i][1]);
        }
        return null;
    }
}
