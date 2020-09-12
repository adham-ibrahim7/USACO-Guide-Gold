import java.util.*;
import java.io.*;

public class HoofPaperScissors {
	public static void main(String[] args) throws IOException {
		setIO("hps");
		
		st = nl();
		int N = ni(st), K = ni(st);
		int[] A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			char c = rl().charAt(0);
			A[i] = c == 'H' ? 0 : c == 'P' ? 1 : 2;
		}
		
		int[][][] dp = new int[N+1][K+1][3];
		
		int ans = 0;
		for (int i = 0; i <= N; i++) {
			for (int k = 0; k <= K; k++) {
				for (int s = 0; s < 3; s++) {
					if (i == 0) continue;
					
					if (k == 0) {
                        dp[i][k][s] = dp[i-1][k][s] + (A[i] == s ? 1 : 0);
                    } else {
                        int lose = (s + 1) % 3;
                        int win = (s + 2) % 3;
                        dp[i][k][s] = Math.max(Math.max(dp[i-1][k][s], dp[i-1][k-1][lose]), dp[i-1][k-1][win]) + (A[i] == s ? 1 : 0);
                    }
					
					if (i == N && k == K) ans = Math.max(ans, dp[i][k][s]);
				}
			}
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
