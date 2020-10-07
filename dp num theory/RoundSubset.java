import java.util.*;
import java.io.*;

public class RoundSubset {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), K = ni(st);
		int[][] A = new int[N+1][2];
		st = nl();
		for (int i = 1; i <= N; i++) {
			long M = nlg(st);
			
			while (M % 2 == 0) {
				M /= 2;
				A[i][0]++;
			}
			
			while (M % 5 == 0) {
				M /= 5;
				A[i][1]++;
			}
		}
		
		int[][][] dp = new int[N+1][K+1][2];
		//0 - 2, 1 - 5
		
		for (int k = 1; k <= K; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					int exclude = Math.min(dp[i][k][0], dp[i][k][1]);
					int include = Math.min(dp[j][k-1][0] + A[i][0], dp[j][k-1][1] + A[i][1]);
					
					if (exclude < include) {
						dp[i][k][0] = dp[i-1][k-1][0] + A[i][0];
						dp[i][k][1] = dp[i-1][k-1][1] + A[i][1];
					}
				}
				
				out.print(dp[i][k][0] + "/" + dp[i][k][1] + " ");
			}
			out.println();
		}
		
		out.println(Math.min(dp[N][K][0], dp[N][K][1]));
		
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
