import java.util.*;
import java.io.*;

public class MoneySums {
	public static void main(String[] args) throws IOException {
		setIO();
		
		int N = ni();
		st = nl();
		int[] A = new int[N+1];
		for (int i = 1; i <= N; i++) A[i] = ni(st);
		
		int MAX = 100000;
		boolean[] dp = new boolean[MAX+1];
		dp[0] = true;
		
		for (int i = 1; i <= N; i++) {
			boolean[] newdp = new boolean[MAX+1];
			for (int s = 0; s <= MAX; s++) {
				newdp[s] = dp[s];
				if (s >= A[i]) newdp[s] |= dp[s-A[i]];
			}
			dp = newdp;
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int s = 1; s <= MAX; s++) {
			if (dp[s]) ans.add(s);
		}
		
		out.println(ans.size());
		for (int k : ans) out.print(k + " ");

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
