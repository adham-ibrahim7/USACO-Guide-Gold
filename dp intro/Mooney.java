import java.util.*;
import java.io.*;

public class Mooney {
    public static void main(String[] args) throws IOException {
        setIO("time");

        st = nl();
        int N = ni(st), M = ni(st), C = ni(st);

        int[] mooney = nia(N);

        List<Integer>[] adj = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = nl();
            int u = ni(st)-1, v = ni(st)-1;
            adj[u].add(v);
        }

        int MAX_TIME = 1000;
        int[][] dp = new int[N][MAX_TIME+1];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -100000);
        dp[0][0] = 0;

        for (int t = 0; t < MAX_TIME; t++) {
            for (int i = 0; i < N; i++) {
                for (int j : adj[i]) {
                    //out.println(i + " " + j);
                    dp[j][t+1] = Math.max(dp[j][t+1], dp[i][t] + mooney[j]);
                }
                //out.print(dp[i][t] + " ");
            }
            //out.println();
        }

        int ans = 0;
        for (int t = 1; t <= MAX_TIME; t++) {
            ans = Math.max(ans, dp[0][t] - C * t * t);
        }

        out.println(ans);

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