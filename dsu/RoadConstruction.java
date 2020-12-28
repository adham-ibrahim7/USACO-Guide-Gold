import java.util.*;
import java.io.*;

public class RoadConstruction {
    public static void main(String[] args) throws IOException {
        setIO();

        st = nl();
        int N = ni(st), M = ni(st);

        init(N);

        while (M-- > 0) {
            st = nl();
            int u = ni(st)-1, v = ni(st)-1;

            union(u, v);

            out.println(components + " " + maxSize);
        }

        f.close();
        out.close();
    }

    static int[] root;
    static int[] size;

    static int components;
    static int maxSize;

    static void init(int N) {
        root = new int[N];
        size = new int[N];
        for (int u = 0; u < N; u++) {
            root[u] = u;
            size[u] = 1;
        }

        components = N;
        maxSize = 1;
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

        maxSize = Math.max(maxSize, size[v]);
        components--;
    }

    static BufferedReader f;
    static PrintWriter out;
    static StringTokenizer st;

    static String rl() throws IOException {
        return f.readLine();
    }

    static int ni(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static long nlg(StringTokenizer st) {
        return Long.parseLong(st.nextToken());
    }

    static int ni() throws IOException {
        return Integer.parseInt(rl());
    }

    static long nlg() throws IOException {
        return Long.parseLong(rl());
    }

    static StringTokenizer nl() throws IOException {
        return new StringTokenizer(rl());
    }

    static int[] nia(int N) throws IOException {
        StringTokenizer st = nl();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = ni(st);
        return A;
    }

    static void setIn(String s) throws IOException {
        f = new BufferedReader(new FileReader(s));
    }

    static void setOut(String s) throws IOException {
        out = new PrintWriter(new FileWriter(s));
    }

    static void setIn() {
        f = new BufferedReader(new InputStreamReader(System.in));
    }

    static void setOut() {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    static void setIO(String s) throws IOException {
        setIn(s + ".in");
        setOut(s + ".out");
    }

    static void setIO() {
        setIn();
        setOut();
    }
}