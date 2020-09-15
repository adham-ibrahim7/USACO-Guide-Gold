import java.util.*;
import java.io.*;

public class Snakes {
	public static void main(String[] args) throws IOException {
		setIO("snakes");

		st = nl();
		int N = ni(st), K = ni(st);
		int[] A = new int[N+1];
		st = nl();
		for (int i = 1; i <= N; i++) A[i] = ni(st);
		
		long[][] dp = new long[N+1][K+1];
		long high = 0, total = 0;
		for (int i = 1; i <= N; i++) {
			high = Math.max(high, A[i]);
			total += A[i];
			dp[i][0] = high * i;
			for (int k = 1; k <= K; k++) {
				dp[i][k] = 1000000000;
				
				int max = A[i];
				for (int j = i-1; j >= 0; j--) {
					dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + (i-j) * max);
					max = Math.max(max, A[j]);
				}
			}
		}
		
		out.println(dp[N][K] - total);
		
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
