import java.util.*;
import java.io.*;

public class UnionFindTest {
    public static void main(String[] args) throws IOException {
        setIO();

        st = nl();
        int N = ni(st), Q = ni(st);
        init(N);
        while (Q-- > 0) {
            st = nl();
            int t = ni(st), u = ni(st), v = ni(st);
            if (t == 0) {
                union(u, v);
            } else {
                out.println(find(u) == find(v) ? 1 : 0);
            }
        }

        f.close();
        out.close();
    }

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