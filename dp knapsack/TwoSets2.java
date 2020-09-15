import java.util.*;
import java.io.*;

public class TwoSets2 {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		out.println(solve(N));
		
		f.close();
		out.close();
	}
	
	static long solve(int N) {
		if (N * (N + 1) % 4 != 0) return 0;
		
		int S = N * (N + 1) / 4;
		long[][] dp = new long[N+1][S+1];
		dp[0][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int s = 0; s <= S; s++) {
				dp[i][s] = dp[i-1][s];
				if (s-i >= 0) dp[i][s] += dp[i-1][s-i];
				dp[i][s] %= MOD;
			}
		}
		
		return dp[N][S] * INV % MOD;
	}
	
	static long MOD = 1000000007, INV = 500000004;

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
