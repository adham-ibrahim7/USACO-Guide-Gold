import java.util.*;
import java.io.*;

public class BFS_DFS {
    public static void main(String[] args) throws IOException {
        setIO();

        int N = ni();
        int[] bfs = nia(N), dfs = nia(N);

        if (N > 1 && bfs[1] != dfs[1]) {
            out.println(-1);
        } else if (N == 1) {
            out.println(0);
        } else {
            out.println(2 * N - 3);
            for (int i = 1; i < N; i++) {
                out.println("1 " + bfs[i]);
            }
            for (int i = 2; i < N; i++) {
                out.println(dfs[i-1] + " " + dfs[i]);
            }
        }

        f.close();
        out.close();
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