import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class RangeMinQueries2 {
    public static void main(String[] args) throws IOException {
        setIO();
        
        st = nl();
        int N = ni(st), Q = ni(st);
        int[] A = nia(N);
        init(N, A);

        while (Q-- > 0) {
        	st = nl();
        	int q = ni(st), x = ni(st), y = ni(st);

        	if (q == 1) {
        		update(x-1, y);
			} else {
        		out.println(query(x-1, y));
			}
		}

        f.close();
        out.close();
    }

	static int N;
	static long t[];

	static long ID = Long.MAX_VALUE;
	static Function<Long, Function<Long, Long>> comb = (Long a) -> ((Long b) -> Math.min(a, b));

	static void init(int _N, int[] A) {
		N = _N;
		t = new long[2 * _N];
		Arrays.fill(t, ID);
		for (int i = 0; i < _N; i++) update(i, A[i]);
	}

	static void update(int p, long value) {  // set value at position p
		for (t[p += N] = value; p > 1; p >>= 1) t[p>>1] = comb.apply(t[p]).apply(t[p^1]);
	}

	static long query(int l, int r) {  // sum on interval [l, r) (0-INDEXED)
		long res = ID;
		for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
			if ((l&1) != 0) res = comb.apply(res).apply(t[l++]);
			if ((r&1) != 0) res = comb.apply(res).apply(t[--r]);
		}
		return res;
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