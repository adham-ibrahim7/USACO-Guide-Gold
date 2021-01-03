import java.util.*;
import java.io.*;
import java.util.function.Function;

public class SubtreeQueries {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), Q = ni(st);
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++) adj[i] = new LinkedList<>();

		int[] A = nia(N);

		for (int i = 0; i < N-1; i++) {
			st = nl();
			int u = ni(st)-1, v = ni(st)-1;

			adj[u].add(v);
			adj[v].add(u);
		}

		start = new int[N];
		end = new int[N];
		dfs(0, -1);

		init(N);
		for (int i = 0; i < N; i++) {
			update(start[i], A[i]);
		}

		while (Q-- > 0) {
			st = nl();
			int q = ni(st), u = ni(st)-1;
			if (q == 1) {
				update(u, ni(st));
			} else {
				out.println(query(start[u], end[u]));
			}
		}

		f.close();
		out.close();
	}

	static List<Integer>[] adj;
	static int[] start, end;
	static int t = 0;

	static void dfs(int u, int e) {
		start[u] = t++;
		for (int v : adj[u]) {
			if (v == e) continue;
			dfs(v, u);
		}
		end[u] = t;
	}

	static int N;
	static long tree[];

	static long ID = 0;
	static Function<Long, Function<Long, Long>> comb = (Long a) -> ((Long b) -> a + b);

	static void init(int _N) {
		N = _N;
		tree = new long[2 * _N];
		Arrays.fill(tree, ID);
	}

	static void init(int _N, int[] A) {
		init(_N);
		for (int i = 0; i < _N; i++) update(i, A[i]);
	}

	static void update(int p, long value) {  // set value at position p
		for (tree[p += N] = value; p > 1; p >>= 1) tree[p>>1] = comb.apply(tree[p]).apply(tree[p^1]);
	}

	static long query(int l, int r) {  // sum on interval [l, r) (0-INDEXED)
		long res = ID;
		for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
			if ((l&1) != 0) res = comb.apply(res).apply(tree[l++]);
			if ((r&1) != 0) res = comb.apply(res).apply(tree[--r]);
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