import java.util.*;
import java.io.*;

public class Teamwork {
	public static void main(String[] args) throws IOException {
		setIO("teamwork");
		
		st = nl();
		int N = ni(st), K = ni(st);
		int[] A = new int[N+1];
		for (int i = 1; i <= N; i++) A[i] = ni();
		
		long[] dp = new long[N+1];
		for (int i = 1; i <= N; i++) {
			int max = A[i];
			for (int k = 1; k <= K; k++) {
				if (i - k < 0) break;
				dp[i] = Math.max(dp[i], dp[i-k] + k * max);
				max = Math.max(max, A[i-k]);
			}
		}
		
		out.println(dp[N]);

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
