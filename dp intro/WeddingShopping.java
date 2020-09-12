import java.util.*;
import java.io.*;

public class WeddingShopping {
	public static void main(String[] args) throws IOException {
		setIO();

		int T = ni();
		t: while (T-- > 0) {
			st = nl();
			int S = ni(st), N = ni(st);
			boolean [][] dp = new boolean[N+1][S+1];
			dp[0][0] = true;
			
			for (int i = 1; i <= N; i++) {
				st = nl();
				int K = ni(st);
				List<Integer> ls = new ArrayList<>();
				for (int j = 0; j < K; j++) ls.add(ni(st));
				
				for (int s = 0; s <= S; s++) {
					for (int n : ls) if (s >= n) dp[i][s] |= dp[i-1][s - n];
				}
			}
			
			for (int s = S; s >= 1; s--) {
				if (dp[N][s]) {
					out.println(s);
					continue t;
				}
			}
			
			out.println("no solution");
		}
		
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
