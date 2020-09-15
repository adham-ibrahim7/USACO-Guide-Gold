import java.util.*;
import java.io.*;

public class EditDistance {
	public static void main(String[] args) throws IOException {
		setIO();

		char[] A = rl().toCharArray();
		char[] B = rl().toCharArray();
		int N = A.length, M = B.length;
		
		int[][] dp = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) dp[i][0] = i;
		for (int j = 1; j <= M; j++) dp[0][j] = j;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
				dp[i][j] = Math.min(dp[i][j], (A[i-1] == B[j-1] ? 0 : 1) + dp[i-1][j-1]);
			}
		}
		
		out.println(dp[N][M]);
		
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
