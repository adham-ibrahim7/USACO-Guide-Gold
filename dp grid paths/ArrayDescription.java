import java.util.*;
import java.io.*;

public class ArrayDescription {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), M = ni(st);
		int[] A = new int[N+1]; st = nl();
		for (int i = 1; i <= N; i++)
			A[i] = ni(st);
		
		boolean[][] good = new boolean[N+1][M+2];
		Arrays.fill(good[0], true);
		good[0][0] = good[0][M+1] = false;
		
		long[][] dp = new long[N+1][M+2];
		Arrays.fill(dp[0], 1);
		
		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= M; k++) {
				if (A[i] > 0) {
					good[i][k] = A[i] == k;
				} else {
					good[i][k] = good[i-1][k] ||
								 good[i-1][k+1] ||
								 good[i-1][k-1];
				}
				
				if (!good[i][k]) continue;
				
				if (i == 1) dp[i][k] = 1;
				else {
					if (good[i-1][k]) dp[i][k] += dp[i-1][k];
					if (good[i-1][k-1]) dp[i][k] += dp[i-1][k-1];
					if (good[i-1][k+1]) dp[i][k] += dp[i-1][k+1];
				}
				dp[i][k] %= 1000000007;
			}
		}
		
		long ans = 0;
		for (int k = 1; k <= M; k++) {
			ans = (ans + dp[N][k]) % 1000000007;
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
