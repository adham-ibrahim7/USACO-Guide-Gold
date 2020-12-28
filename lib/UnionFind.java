/*
 * Created by Adham Ibrahim on 12/25/2020
 */

public class UnionFind {
    static int[] root;
    static int[] size;

    static void init(int N) {
        root = new int[N];
        size = new int[N];
        for (int u = 0; u < N; u++) {
            root[u] = u;
            size[u] = 1;
        }
    }

    static int find(int v) {
        if (root[v] == v) {
            return v;
        }
        root[v] = find(root[v]);
        return root[v];
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return;
        }

        if (size[u] >= size[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        root[u] = v;
        size[v] += size[u];
    }
}