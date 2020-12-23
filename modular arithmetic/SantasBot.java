import java.util.*;
import java.io.*;

public class SantasBot {
    public static void main(String[] args) throws IOException {
        setIO();

        int N = ni();

        Map<Integer, Integer> counts = new HashMap<>();

        int[] K = new int[N];
        List<Integer> items[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            st = nl();
            K[i] = ni(st);
            items[i] = new ArrayList<>();
            for (int k = 0; k < K[i]; k++) {
                items[i].add(ni(st));
                counts.put(items[i].get(k), counts.getOrDefault(items[i].get(k), 0) + 1);
            }
        }

        long MOD = 998244353;

        int MAX = 1000007;
        long[] inv = new long[1000007];
        for (int i = 1; i < MAX; i++) {
            inv[i] = modinv(i, MOD);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < K[i]; k++) {
                ans += counts.get(items[i].get(k)) * inv[N] % MOD * inv[N] % MOD * inv[K[i]] % MOD;
                ans %= MOD;
            }
        }

        out.println(ans);

        f.close();
        out.close();
    }

    static long modpow(long a, long b, long m) {
        if (b == 0) return 1;
        long res = modpow(a, b / 2, m);
        res = res * res % m;
        if (b % 2 == 1) res = res * a % m;
        return res;
    }

    static long modinv(long x, long m) {
        return modpow(x, m-2, m);
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