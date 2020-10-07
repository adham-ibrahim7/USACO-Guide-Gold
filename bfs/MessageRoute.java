import java.util.*;
import java.io.*;

public class MessageRoute {
	public static void main(String[] args) throws IOException {
		setIO();
		
		st = nl();
		int N = ni(st), M = ni(st);
		LinkedList<Integer>[] adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		while (M-- > 0) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int[] prev = new int[N+1];
		Arrays.fill(prev, -1);
		prev[1] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : adj[u]) {
				if (prev[v] > -1) continue;
				prev[v] = u;
				q.add(v);
			}
		}
		
		Stack<Integer> ans = new Stack<>();
		int u = N;
		while (prev[u] != -1) {
			ans.push(u);
			u = prev[u];
		}
		
		if (ans.isEmpty() || ans.peek() != 1) out.println("IMPOSSIBLE");
		else {
			out.println(ans.size());
			while (!ans.isEmpty()) out.print(ans.pop() + " ");
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
