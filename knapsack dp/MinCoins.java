import java.util.*;
import java.io.*;

public class MinCoins {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), S = ni(st);
		int[] coins = nia(N);
		
		int[] dp = new int[S+1];
		int MAX = 2000000;
		Arrays.fill(dp, MAX);
		dp[0] = 0;
		
		for (int s = 1; s <= S; s++) {
			for (int k : coins) {
				if (s-k < 0) continue;
				dp[s] = Math.min(dp[s], 1 + dp[s-k]);
			}
		}
		
		out.println(dp[S] == MAX ? -1 : dp[S]);
		
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
