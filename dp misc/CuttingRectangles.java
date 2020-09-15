import java.util.*;
import java.io.*;

public class CuttingRectangles {
	public static void main(String[] args) throws IOException {
		setIO();

		int INF = 1000000000;
		
		st = nl();
		int A = ni(st), B = ni(st);
		if (A < B) {
			int t = B;
			B = A;
			A = t;
		}
		int[][] dp = new int[A+1][B+1];
		
		for (int i = 0; i <= A; i++) Arrays.fill(dp[i], INF);
		
		for (int a = 1; a <= A; a++) {
			for (int b = 1; b <= B; b++) {
				if (a == b) dp[a][b] = 0;
				else {					
					for (int i = 1; i <= a / 2; i++) {
						dp[a][b] = Math.min(dp[a][b], 1 + dp[i][b] + dp[a-i][b]);
					}
					
					for (int i = 1; i <= b / 2; i++) {
						dp[a][b] = Math.min(dp[a][b], 1 + dp[a][i] + dp[a][b-i]);
					}
				}
			}
		}
		
		out.println(dp[A][B]);
		
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
